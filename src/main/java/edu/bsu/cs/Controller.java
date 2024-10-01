package edu.bsu.cs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.net.MalformedURLException;
import java.net.URL;

public class Controller{
    private ParseWikiInfo parseWikiInfo = new ParseWikiInfo();
    private final UI view;
    public Controller(final UI view, UI view1) {
        this.view = view1;
        UI.wikiButton.setOnAction(new EventHandler<ActionEvent>() {
            @FXML
            public void handle(ActionEvent actionEvent) {
                String parsedInfo = parseWikiInfo.parseUserAndTimestamp(view.inputField.getText());
                view.outPutField.setText(parsedInfo);
            }
        });
    }// end Controller method
}
