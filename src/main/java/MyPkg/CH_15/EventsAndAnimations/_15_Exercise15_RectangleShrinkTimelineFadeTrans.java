/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPkg.CH_15.EventsAndAnimations;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author laura
 */
public class _15_Exercise15_RectangleShrinkTimelineFadeTrans extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    StackPane pane = new StackPane();
    int initialWidht = 250;
    int initialHeight = 100;
    int finalWidht = 80;
    int finalHeight = 50;
    
    Rectangle r = new Rectangle(25,50,80,50);
    r.setArcWidth(15);
    r.setArcHeight(25);
    r.setFill(Color.SALMON);
    pane.getChildren().add(r); // Place text into the stack pane

    // Create a handler for changing text
    EventHandler<ActionEvent> eventHandler = e -> {
    };
    
    // Create an animation for alternating text
    Timeline animation = new Timeline(
      new KeyFrame(Duration.millis(1000), eventHandler));
    animation.setCycleCount(Timeline.INDEFINITE);
    //animation.play(); // Start animation

    // Pause and resume animation
    pane.setOnMouseClicked(e -> {
      if (animation.getStatus() == Animation.Status.PAUSED) {
      }
      else {
      }
    });
    
     // Apply a fade transition to ellipse
    FadeTransition ft = 
      new FadeTransition(Duration.millis(10000), r);
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 300, 250);
    primaryStage.setTitle("TimelineDemo"); // Set the stage title
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