package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class TestParseWikiInfo {
    @Test
    public void testParserUserAndTimestamp(){
        ParseWikiInfo parser = new ParseWikiInfo();
        InputStream parsedData = Thread.currentThread().getContextClassLoader().getResourceAsStream("sample.json");
        String user = parser.parseUserAndTimestamp(parsedData.toString());
        String timestamp = parser.parseUserAndTimestamp(parsedData.toString());
        Assertions.assertEquals("{timestamp=2024-09-14T07:25:13Z}", timestamp);
        Assertions.assertEquals("{user=3df}", user);
    }
}
