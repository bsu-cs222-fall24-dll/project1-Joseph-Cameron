package edu.bsu.cs;

import net.minidev.json.JSONArray;

import java.io.IOException;
import java.net.URLConnection;


public class Main extends PickUserPage {
    public static void main(String[] args) throws IOException {
        PickUserPage userPage = new PickUserPage();
        ParseWikiInfo parseWikiInfo = new ParseWikiInfo();
        String wikiName = userPage.promptUser();
        URLConnection connection = connectToWikipedia(wikiName);
        String jsonData = readJsonAsStringFrom(connection);
        String parsedData = parseWikiInfo.parseUserAndTimestamp(jsonData);
        String parsedRedirect = parseWikiInfo.parseRedirect(jsonData);
        System.out.println(parsedRedirect);
        ErrorReport.missingPage(jsonData);
        System.out.println(parsedData);


    }

}
