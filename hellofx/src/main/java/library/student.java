package library;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class student extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Logo and title
        Text logo = new Text("DegreeWorks");
        logo.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Username and Password fields
        TextField usernameField = new TextField();
        usernameField.setPromptText("Please Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Please Password");

        // Remember me checkbox
        CheckBox rememberMeCheckBox = new CheckBox("Remember");

        // Login button
        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-background-color: #FFA500; -fx-text-fill: white;");

        // Layout for the login form
        VBox loginForm = new VBox(10, logo, usernameField, passwordField, rememberMeCheckBox, loginButton);
        loginForm.setAlignment(Pos.CENTER);
        loginForm.setStyle("-fx-padding: 20; -fx-background-color: white; -fx-border-color: black; -fx-border-width: 2;");

        // Main layout pane
        StackPane root = new StackPane(loginForm);
        root.setStyle("-fx-background-color: #F0F0F0;");

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

