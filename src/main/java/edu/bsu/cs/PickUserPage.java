package edu.bsu.cs;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Scanner;
public class PickUserPage {

    private static final Scanner scanner = new Scanner(System.in);
    public static String promptUser() {
        //User Enters page name --> enters into the link and returns the connection made by the resulting link
        System.out.println("Enter Wikipedia Page Name");
        return ErrorReport.emptyPage(scanner.nextLine());
    }
    static String readJsonAsStringFrom(URLConnection connection) throws IOException {
        return new String(connection.getInputStream().readAllBytes(), Charset.defaultCharset());
    }



}

