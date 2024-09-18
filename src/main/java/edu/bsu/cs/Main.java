package edu.bsu.cs;

import java.io.IOException;
import java.net.URLConnection;


public class Main extends PickUserPage {
    public static void main(String[] args) throws IOException {

        URLConnection connection = connectToWikipedia();
        String jsonData = readJsonAsStringFrom(connection);
        ParseWikiInfo parseWikiInfo = new ParseWikiInfo();
        String parsedData = parseWikiInfo.parseUserAndTimestamp(jsonData);
        System.out.println(parsedData);
    }

}
