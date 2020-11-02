/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPkg.CH_32.Threads;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author laura
 */
public class _32_02_FlashText_LambdaExp extends Application {
    private String text = "";
  
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {   
        StackPane pane = new StackPane();
        Label lblText = new Label("Programming is fun");
        pane.getChildren().add(lblText);

        new Thread(() -> { // lambda expression
            try {
                Thread.sleep(1000);
                while (true) {
                    if (lblText.getText().trim().length() == 0)
                        text = "Welcome";
                    else
                        text = "";
                    Platform.runLater(() -> lblText.setText(text)); // lambda exp
                    Thread.sleep(200);
                }
            }catch (InterruptedException ex) {}
        }).start();
    
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 50);
        primaryStage.setTitle("FlashText"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
      launch(args);
    }
}