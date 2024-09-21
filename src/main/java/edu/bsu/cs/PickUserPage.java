package edu.bsu.cs;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Scanner;
public class PickUserPage {
    private static final Scanner scanner = new Scanner(System.in);

    public static String askUser() {
        //User Enters page name --> enters into the link and returns the connection made by the resulting link
        System.out.println("Enter Wikipedia Page Name");
        return ErrorReport.noPage(scanner.nextLine());
    }


    static URLConnection connectToWikipedia(String wikiName) throws IOException {
        String encodedUrlString = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" +
                URLEncoder.encode(wikiName, Charset.defaultCharset()) +
                "&rvprop=timestamp|user&rvlimit=15&redirects";
        URL url = new URL(encodedUrlString);
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent",
                "CS222FirstProject1 (joseph.sobiech@bsu.edu, cameron.hosler@bsu.edu)");
        connection.connect();
        return connection;
    }

    static String readJsonAsStringFrom(URLConnection connection) throws IOException {
        return new String(connection.getInputStream().readAllBytes(), Charset.defaultCharset());
    }


}

