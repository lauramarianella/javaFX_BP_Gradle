package MyPkg.CH_16.UIControlsAndMultimedia;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class _16_02_ButtonDemo extends Application {
  protected Text text = new Text(50, 50, "JavaFX Programming");
  
  protected BorderPane getPane() {
    HBox paneForButtons = new HBox(20);
    Image image = new Image("https://icons.iconarchive.com/icons/hopstarter/button/128/Button-Previous-icon.png");
    ImageView ivBtnLeft = new ImageView(image);
    ivBtnLeft.setFitHeight(30);
    ivBtnLeft.setFitWidth(30);
    Button btLeft = new Button("Left", ivBtnLeft);
    
    ImageView ivBtnRight = new ImageView("https://icons.iconarchive.com/icons/hopstarter/button/128/Button-Next-icon.png");
    Button btRight = new Button("Right", ivBtnRight); 
    ivBtnRight.setFitHeight(30);
    ivBtnRight.setFitWidth(30);
    paneForButtons.getChildren().addAll(btLeft, btRight);
    paneForButtons.setAlignment(Pos.CENTER);
    paneForButtons.setStyle("-fx-border-color: green");

    BorderPane pane = new BorderPane();
    pane.setBottom(paneForButtons);
    
    Pane paneForText = new Pane();
    paneForText.getChildren().add(text);
    pane.setCenter(paneForText);
    
    btLeft.setOnAction(e -> text.setX(text.getX() - 10));
    btRight.setOnAction(e -> text.setX(text.getX() + 10));
    
    return pane;
  }
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create a scene and place it in the stage
    Scene scene = new Scene(getPane(), 450, 200);
    primaryStage.setTitle("ButtonDemo"); // Set the stage title
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