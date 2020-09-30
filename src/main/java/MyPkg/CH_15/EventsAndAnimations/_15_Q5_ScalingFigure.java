/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPkg.CH_15.EventsAndAnimations;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class _15_Q5_ScalingFigure extends Application {
    final Rectangle rectangle = new Rectangle(100, 100, 150, 100); 
    final Duration duration = Duration.seconds(2);
    ScaleTransition animationScale;
    FadeTransition transitionFade;
    
    
    @Override
    public void start(Stage primaryStage) {
        rectangle.setFill(Color.BLUEVIOLET); 
        final Pane root = new Pane(); 
        root.getChildren().setAll(rectangle); 
         
        final Scene scene = new Scene(root, 350, 300); 
        primaryStage.setTitle("Quiz 5 - Scaling Animation"); 
        primaryStage.setScene(scene); 
        primaryStage.show(); 
       
        setAnimationScaling();
        setTransitionFading();
                
        rectangle.setOnMousePressed(e->animationScale.pause());
        rectangle.setOnMouseReleased(e->animationScale.play());
    } 
    public void setAnimationScaling(){
         animationScale= new ScaleTransition(duration, rectangle); 
         animationScale.setCycleCount(TranslateTransition.INDEFINITE); 
         animationScale.setAutoReverse(true); 
         animationScale.setFromX(0.5); 
         animationScale.setToX(2); 
         animationScale.setFromY(0.5); 
         animationScale.setToY(2); 
         animationScale.setInterpolator(Interpolator.LINEAR); 
         animationScale.play(); 
     }
     public void setTransitionFading(){
         transitionFade= new FadeTransition(duration.multiply(2), rectangle);
         transitionFade.setFromValue(1);
         transitionFade.setToValue(0.1);
         transitionFade.setAutoReverse(true);
         transitionFade.setCycleCount(Timeline.INDEFINITE);
         transitionFade.play();
     }
    
    public static void main(String[] args) { 
        launch(args); 
    } 

}