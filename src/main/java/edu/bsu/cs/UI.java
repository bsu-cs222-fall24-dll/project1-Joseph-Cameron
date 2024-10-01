package edu.bsu.cs;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URLConnection;


public class UI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public final TextField wikiInputField = new TextField();
    public final TextArea outputTextArea = new TextArea();
    @FXML
    Button fetchButton = new Button("Fetch Revisions");


    @Override
    public void start(Stage primaryStage) {
        configure(primaryStage);
        configureGetRevisionsButton();
        wikiInputField.setPromptText("Enter Wikipedia Page Name");

    }
    private void configure(Stage stage) {
        stage.setTitle("Get Info");
        stage.setScene(new Scene(createRoot()));
        stage.sizeToScene();
        stage.show();
    }
    private Pane createRoot() {
        VBox root = new VBox();
        root.getChildren().add(wikiInputField);
        root.getChildren().add(fetchButton);
        root.getChildren().add(outputTextArea);
        return root;
    }

    public void configureGetRevisionsButton() {
        fetchButton.setOnAction(actionEvent -> {
            fetchButton.setDisable(true);
            try {
                getWikiRevisions();
                fetchButton.setDisable(false);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });//borrowed from Manning and Johnson
    }
    private void getWikiRevisions() throws IOException {
        URLConnection connection = PickUserPage.connectToWikipedia(wikiInputField.getText());
        String wikiPage = wikiInputField.getText();

        if (wikiPage.isEmpty()) {
            outputTextArea.setText("Please enter a valid Wikipedia page name.");
            guiAlert("Empty Entry Alert", "Please Enter something");
        } else {
            try {
                String jsonData = PickUserPage.readJsonAsStringFrom(
                        PickUserPage.connectToWikipedia(wikiPage)
                );

                String parsedInfo = new ParseWikiInfo().parseUserAndTimestamp(jsonData);
                String redirectInfo = new ParseWikiInfo().parseRedirect(jsonData);
                outputTextArea.setText(redirectInfo + "\n" + parsedInfo);
            } catch (IOException e) {
                outputTextArea.setText("Error fetching Wikipedia data: " + e.getMessage());
            } catch (Exception e) {
                guiAlert("Network Error Alert", "Network Error, Please Connect");
            }
        }
    }
    private void guiAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}