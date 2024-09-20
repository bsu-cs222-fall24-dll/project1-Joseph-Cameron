package edu.bsu.cs;

public class ErrorReport {
    public static String noPage(String wikiName) {
        if (wikiName.isEmpty()) {
            System.err.println("Invalid Characters: ");
        }
        return wikiName;
    }
}
