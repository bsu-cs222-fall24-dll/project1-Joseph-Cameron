package edu.bsu.cs;
import net.minidev.json.JSONArray;

import java.net.URL;

public class ErrorReport {
    public static String emptyPage(String wikiName) {
        if (wikiName.isEmpty()) {
            System.err.println("Invalid Characters: ");
            System.exit(0);
        }
        return wikiName;
    }
    public static void missingPage(String jsonData) {
        try {
            JSONArray parsedData = ParseWikiInfo.parseMissingData(jsonData);
            if (parsedData.getFirst().toString().isEmpty()) {
                System.err.println("\nMissing Page");
                System.exit(0);
            }
            System.out.println(parsedData);
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
