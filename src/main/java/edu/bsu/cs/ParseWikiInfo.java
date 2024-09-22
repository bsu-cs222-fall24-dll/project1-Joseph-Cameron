package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class ParseWikiInfo extends PickUserPage {


    public String parseUserAndTimestamp(String jsonData) {
        //Creates string with resultFromRevisions using StringBuilder
        StringBuilder resultFromRevisions = new StringBuilder();
        for (int i = 1; i < 16; i++) {
            JSONArray timestampValue = JsonPath.read(jsonData, "$..revisions[" + i + "].timestamp");
            JSONArray userValue = JsonPath.read(jsonData, "$..revisions[" + i + "].user");
            resultFromRevisions.append("  ").append(timestampValue.getFirst());
            resultFromRevisions.append("  ").append(userValue.getFirst()).append("\n");
        }
        return resultFromRevisions.toString();
    }

    public String parseRedirect(String jsonData) {
        StringBuilder resultFromRedirect = new StringBuilder();
        JSONArray redirectValue = JsonPath.read(jsonData, "$..redirects..to");
        if(!redirectValue.isEmpty()) {
            resultFromRedirect.append(" ").append(redirectValue.getFirst()).append("\n");
            System.out.println(("Redirected to" + resultFromRedirect));
        }
        return resultFromRedirect.toString();
    }
    public static JSONArray parseMissingData(String jsonData) {
        //method Idea Borrowed from burch-smith project
        return JsonPath.read(jsonData, "$..missing");
    }

}