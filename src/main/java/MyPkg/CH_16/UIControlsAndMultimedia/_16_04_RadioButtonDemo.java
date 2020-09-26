/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPkg.CH_16.UIControlsAndMultimedia;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 *
 * @author laura
 */
public class _16_04_RadioButtonDemo extends CheckBoxDemo {
  @Override // Override the getPane() method in the super class
  protected BorderPane getPane() {
    BorderPane pane = super.getPane();
    
    VBox paneForRadioButtons = new VBox(20);
    paneForRadioButtons.setPadding(new Insets(5, 5, 5, 5)); 
    paneForRadioButtons.setStyle("-fx-border-width: 2px; -fx-border-color: green");
    
    RadioButton rbRed   = new RadioButton("Red");
    RadioButton rbGreen = new RadioButton("Green");
    RadioButton rbBlue  = new RadioButton("Blue");
    paneForRadioButtons.getChildren().addAll(rbRed, rbGreen, rbBlue);
    pane.setLeft(paneForRadioButtons);

    ToggleGroup group = new ToggleGroup();
    rbRed.setToggleGroup(group);
    rbGreen.setToggleGroup(group);
    rbBlue.setToggleGroup(group);
    
    rbRed.setOnAction(e -> {
      if (rbRed.isSelected()) {
        text.setFill(Color.RED);
      }
    });
    
    rbGreen.setOnAction(e -> text.setFill(Color.GREEN));

    rbBlue.setOnAction(e -> text.setFill(Color.BLUE));
    
    return pane;
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}


class CheckBoxDemo extends ButtonDemo2 {
  @Override // Override the getPane() method in the super class
  protected BorderPane getPane() {
    BorderPane pane = super.getPane();

    Font fontBoldItalic = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20);
    Font fontBold       = Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20);
    Font fontItalic     = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.ITALIC, 20);
    Font fontNormal     = Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.REGULAR, 20);
    
    text.setFont(fontNormal);
    
    VBox paneForCheckBoxes = new VBox(20);
    paneForCheckBoxes.setPadding(new Insets(5, 5, 5, 5)); 
    paneForCheckBoxes.setStyle("-fx-border-color: green");
    CheckBox chkBold = new CheckBox("Bold");
    CheckBox chkItalic = new CheckBox("Italic");
    paneForCheckBoxes.getChildren().addAll(chkBold, chkItalic);
    pane.setRight(paneForCheckBoxes);

    EventHandler<ActionEvent> handler = e -> { 
      if (chkBold.isSelected() && chkItalic.isSelected()) {
        text.setFont(fontBoldItalic); // Both check boxes checked
      }
      else if (chkBold.isSelected()) {
        text.setFont(fontBold); // The Bold check box checked
      }
      else if (chkItalic.isSelected()) {
        text.setFont(fontItalic); // The Italic check box checked
      }      
      else {
        text.setFont(fontNormal); // Both check boxes unchecked
      }
    };
    
    chkBold.setOnAction(handler);
    chkItalic.setOnAction(handler);
    
    return pane; // Return a new pane
  }
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    super.start(primaryStage);
    primaryStage.setTitle("CheckBoxDemo"); // Set the stage title
  }
}

class ButtonDemo2 extends Application {
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
  }