package edu.bsu.cs;

import java.io.IOException;
import java.net.URLConnection;
import java.util.Scanner;
import java.io.*;

public class Main extends PickUserPage{
    public static void main(String[] args) throws IOException {
        PickUserPage page = new PickUserPage();
        String wikiName = page.askUser();
        URLConnection connection = connectToWikipedia(wikiName);
        String jsonData = readJsonAsStringFrom(connection);
        ParseWikiInfo parseWikiInfo = new ParseWikiInfo();
        String parsedData = parseWikiInfo.parseUserAndTimestamp(jsonData);
        ErrorReport.missingPage(jsonData);
        System.out.println(parsedData);
    }
}
