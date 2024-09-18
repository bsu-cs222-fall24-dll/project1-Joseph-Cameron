package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Objects;



public class TestWiki {

        @Test
        public void testAccessToJsonFile() throws IOException {
            String jsonData = readSampleFileAsString();
            Assertions.assertNotNull(jsonData);
        }

        @Test
        public void testCountRevisionsWithJsonPath() throws IOException {
            String jsonData = readSampleFileAsString();
            JSONArray revisions = getRevisionsFromJson(jsonData);
            Assertions.assertEquals(15, revisions.size());
        }

        @Test
        public void testParserUserAndTimestamp(){
            ParseWikiInfo parser = new ParseWikiInfo();
            InputStream parsedData = Thread.currentThread().getContextClassLoader().getResourceAsStream("sample.json");
            String user = parser.parseUserAndTimestamp(parsedData.toString());
            String timestamp = parser.parseUserAndTimestamp(parsedData.toString());
            Assertions.assertEquals("{timestamp=2024-09-14T07:25:13Z}", timestamp);
            Assertions.assertEquals("{user=3df}", user);
        }

        private String readSampleFileAsString() throws NullPointerException, IOException {
            try (InputStream sampleFile = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream("sample.json")) {
                return new String(Objects.requireNonNull(sampleFile).readAllBytes(), Charset.defaultCharset());
            }
        }

        private JSONArray getRevisionsFromJson(String jsonData) {
            return JsonPath.read(jsonData, "$..revisions[*]");
            //Changing the "*" to a number gives that data values from top to bottom
        }
    }
