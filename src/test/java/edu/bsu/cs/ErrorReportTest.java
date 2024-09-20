package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Objects;

public class ErrorReportTest {


    @Test
    public void testAccessToJsonFile() throws IOException {
        String jsonData = readSampleMissingFile();
        Assertions.assertNotNull(jsonData);
    }

    @Test
    public void MissedFileTest() throws IOException {
        String jsonData = readSampleMissingFile();
        JSONArray dataError = getNullDataFromJson(jsonData);
        String data = (String) dataError.getFirst();
        Assertions.assertNotNull(data);
    }

    private String readSampleMissingFile() throws NullPointerException, IOException {
        try (InputStream sampleFile = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("error.json")) {
            return new String(Objects.requireNonNull(sampleFile).readAllBytes(), Charset.defaultCharset());
        }
    }
    private JSONArray getNullDataFromJson(String jsonData) {
        return JsonPath.read(jsonData, "$..missing");
        //command for missing data
    }
}
