package edu.bsu.cs;

import java.io.IOException;
import java.net.URLConnection;

public class Main extends PickUserPage {
    public static void main(String[] args) throws IOException {
        ParseWikiInfo parseWikiInfo = new ParseWikiInfo();
        String wikiName = promptUser();
        URLConnection connection = connectToWikipedia(wikiName);
        String jsonData = readJsonAsStringFrom(connection);
        String parsedData = parseWikiInfo.parseUserAndTimestamp(jsonData);
        String parsedRedirect = parseWikiInfo.parseRedirect(jsonData);
        System.out.println(parsedRedirect);
        ErrorReport.missingPage(jsonData);
        System.out.println(parsedData);
    }
}
