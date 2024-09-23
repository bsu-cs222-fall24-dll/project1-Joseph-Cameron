package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Objects;

public class TestParseWikiInfo {
    @Test
    public void testParserUserAndTimestamp() throws IOException {
        InputStream parsedUserAndTimeStamp = Thread.currentThread().getContextClassLoader().getResourceAsStream("sample.json");
        StringBuilder resultFromRevisions = new StringBuilder();
        for (int dataValue = 0; dataValue < 1; dataValue++) {
            JSONArray timestampValue = JsonPath.read(parsedUserAndTimeStamp, "$..revisions[" + dataValue + "].timestamp");
            JSONArray userValue = JsonPath.read(parsedUserAndTimeStamp, "$..revisions[" + dataValue + "].user");
            resultFromRevisions.append("  ").append(timestampValue.getFirst());
            resultFromRevisions.append("  ").append(userValue.getFirst()).append("\n");
            Assertions.assertEquals("  2024-09-14T07:25:13Z", timestampValue);
            Assertions.assertEquals("  3df", userValue);
        }
    }

    @Test
    public void testParseRedirect(){
        ParseWikiInfo parser = new ParseWikiInfo();
        InputStream parsedRedirect = Thread.currentThread().getContextClassLoader().getResourceAsStream("sample.json");
        String redirect = parser.parseRedirect(parsedRedirect.toString());
        Assertions.assertEquals("", redirect);
    }

    private String readSampleFileAsString(InputStream parsedData) throws NullPointerException, IOException {
        try (InputStream sampleFile = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("sample.json")) {
            return new String(Objects.requireNonNull(sampleFile).readAllBytes(), Charset.defaultCharset());
        }
    }
}
