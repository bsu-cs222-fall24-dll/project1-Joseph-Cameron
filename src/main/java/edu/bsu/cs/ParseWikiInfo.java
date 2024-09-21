package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class ParseWikiInfo extends PickUserPage{

    public static String parseUserAndTimestamp(String jsonData){
        //Creates string with resultFromRevisions using StringBuilder
        StringBuilder resultFromRevisions = new StringBuilder();
        for (int i = 1; i < 16; i++) {
            JSONArray userValue = JsonPath.read(jsonData, "$..revisions[" + i + "].user");
            JSONArray timestampValue = JsonPath.read(jsonData, "$..revisions[" + i + "].timestamp");
            resultFromRevisions.append("  ").append(timestampValue.get(0));
            resultFromRevisions.append("  ").append(userValue.get(0)).append("\n");
        }
        return resultFromRevisions.toString();
    }
    public static JSONArray parseMissingData(String jsonData) {
        //method Idea Borrowed from burch-smith project
        return JsonPath.read(jsonData, "$..missing");
    }

}