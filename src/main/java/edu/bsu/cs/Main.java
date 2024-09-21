package edu.bsu.cs;

import java.io.IOException;
import java.net.URLConnection;
import java.util.Scanner;
import java.io.*;

public class Main extends PickUserPage{
    public static void main(String[] args) throws IOException {
        PickUserPage userPage = new PickUserPage();
        String wikiName = userPage.askUser();
        URLConnection connection = userPage.connectToWikipedia(wikiName);
        String jsonData = readJsonAsStringFrom(connection);
        ParseWikiInfo parseWikiInfo = new ParseWikiInfo();
        String parsedData = parseWikiInfo.parseUserAndTimestamp(jsonData);
        System.out.println(parsedData);
    }
}
