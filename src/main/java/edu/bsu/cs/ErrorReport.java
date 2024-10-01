package edu.bsu.cs;

import net.minidev.json.JSONArray;
import java.net.URL;

//Class and methods from Alec-Timothy
public class ErrorReport {
    public static String emptyPage(String wikiName) {
        if (wikiName.isEmpty()) {
            System.err.println("Empty String Error ");
            System.exit(0);
        }
        return wikiName;
    }

    public static void missingPage(String jsonData) {
        try {
            JSONArray missingData = ParseWikiInfo.parseMissingData(jsonData);
            if (!missingData.isEmpty()) {
                System.err.println("\nMissing Page");
                System.exit(0);
            }
        } catch (Exception ignored) {}
    }//end missingPage

    protected static void NetWorkConnect(URL url) {
        try {
            url.openConnection().connect();
        } catch (Exception NetworkError){
            System.err.println("Cannot connect\n");
            System.exit(0);
        }
    }
}
