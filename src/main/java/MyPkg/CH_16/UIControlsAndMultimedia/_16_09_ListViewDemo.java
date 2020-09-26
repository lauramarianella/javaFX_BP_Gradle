/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPkg.CH_16.UIControlsAndMultimedia;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
/**
 *
 * @author laura
 */
public class _16_09_ListViewDemo extends Application {
  // Declare an array of Strings for flag titles
  private String[] flagTitles = {"Canada", "France", "United Kingdom"};

  // Declare an ImageView array for the national flags of 9 countries
  private ImageView[] ImageViews = {
     new ImageView("https://upload.wikimedia.org/wikipedia/commons/3/39/Animated-Flag-Canada.gif")
    ,new ImageView("https://upload.wikimedia.org/wikipedia/commons/1/1d/Flag_of_France_%28WFB_2004%29.gif")
    ,new ImageView("https://upload.wikimedia.org/wikipedia/commons/5/58/UK_flag_m_v.gif")
  };

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    ListView<String> lv = new ListView<>
      (FXCollections.observableArrayList(flagTitles));
    lv.setPrefSize(140, 80);
    lv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    
    // Create a pane to hold image views
    FlowPane imagePane = new FlowPane(10, 10);
    BorderPane pane = new BorderPane();
    pane.setLeft(new ScrollPane(lv));   
    pane.setCenter(imagePane);
    
    for(ImageView jk : ImageViews){
        jk.setFitWidth(200);
        jk.setFitHeight(120);
    }

    lv.getSelectionModel().selectedItemProperty().addListener(
      ov -> { 
        imagePane.getChildren().clear();
        for (Integer i: lv.getSelectionModel().getSelectedIndices()) {
          imagePane.getChildren().add(ImageViews[i]);
        }
    });

    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 350, 150);
    primaryStage.setTitle("ListViewDemo"); // Set the stage title
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