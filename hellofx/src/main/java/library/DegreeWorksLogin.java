package library;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DegreeWorksLogin extends Application {

    public void start(Stage primaryStage) {
        // Title
        Label titleLabel = new Label("DegreeWorks");
        titleLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // Description
        Label descriptionLabel = new Label("Welcome to DegreeWorks, a DegreeWorks that Works!\nDegreeWorks is a tool used by academic advisors and students alike.\nPlease indicate which field describes you best.");
        descriptionLabel.setStyle("-fx-font-size: 16px;");
        descriptionLabel.setWrapText(true);

        // Buttons
        Button studentButton = new Button("Student");
        studentButton.setStyle("-fx-font-size: 14px;");
        Button advisorButton = new Button("Advisor");
        advisorButton.setStyle("-fx-font-size: 14px;");

        // Layout
        VBox layout = new VBox(20, titleLabel,/*  */ descriptionLabel, studentButton, advisorButton);
        layout.setAlignment(Pos.CENTER);

        // Scene
        Scene scene = new Scene(layout, 600, 400); // Set the window size

        primaryStage.setTitle("DegreeWorks");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}




