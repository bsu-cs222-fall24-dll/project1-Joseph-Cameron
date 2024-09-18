package edu.bsu.cs;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

public class ParseWikiInfo extends PickUserPage{


    public String parseUserAndTimestamp(String jsonData){
        //Creates string with resultFromRevisions using StringBuilder
        StringBuilder resultFromRevisions = new StringBuilder();
        for(int i = 1; i < 15; i++) {
            JSONArray userValue = JsonPath.read(jsonData, "$..revisions["+ i +"].user");
            JSONArray timestampValue = JsonPath.read(jsonData, "$..revisions[" + i + "].timestamp");
            resultFromRevisions.append("User: ").append(userValue.get(0));
            resultFromRevisions.append(", Timestamp: ").append(timestampValue.get(0)).append("\n");


        }
        return resultFromRevisions.toString();
    }

}