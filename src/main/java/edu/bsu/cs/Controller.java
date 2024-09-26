package edu.bsu.cs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Controller {
    private ParseWikiInfo parseWikiInfo = new ParseWikiInfo();
    public Controller(UI view) {
        UI.wikiButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String parsedInfo = parseWikiInfo.parseUserAndTimestamp(view.inputField.getText());
                view.outPutField.setText(parsedInfo);
            }
        });
    }
}
