package edu.bsu.cs;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

import static com.jayway.jsonpath.internal.PathRef.createRoot;
import static javafx.application.Application.launch;

public class UI extends Main{
    public static void main(String[] args) {
        launch(args);
    }
    public ParseWikiInfo parseWikiInfo = new ParseWikiInfo();
    static final Button wikiButton = new Button("Enter Wikipedia Name");
    public TextField inputField = new TextField();
    public TextField outPutField = new TextField();

    @Override
    public void start(Stage primaryStage) {
        new Controller(this);
        outPutField.setEditable(false);
        configure(primaryStage);
    }

    private void configure(Stage stage) {
        stage.setTitle("Get Info");
        stage.setScene(new Scene(createRoot()));
        stage.sizeToScene();
        stage.show();
    }

    private Pane createRoot() {
        VBox root= new VBox();
        root.getChildren().add(inputField);
        root.getChildren().add(wikiButton);
        root.getChildren().add(outPutField);
        return root;
    }

}//end class UI
