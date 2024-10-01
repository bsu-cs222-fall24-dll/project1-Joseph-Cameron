package edu.bsu.cs;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class WikiConnect {
    static URLConnection connectToWikipedia(String wikiName) throws IOException {
        String encodedUrlString = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" +
                URLEncoder.encode(wikiName, Charset.defaultCharset()) +
                "&rvprop=timestamp|user&rvlimit=15&redirects";
        URL url = new URL(encodedUrlString);
        ErrorReport.NetWorkConnect(url);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent",
                "CS222FirstProject1 (joseph.sobiech@bsu.edu, cameron.hosler@bsu.edu)");
        connection.connect();
        return connection;
    }
}
