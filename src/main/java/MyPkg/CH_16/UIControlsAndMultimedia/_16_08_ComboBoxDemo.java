/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyPkg.CH_16.UIControlsAndMultimedia;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class _16_08_ComboBoxDemo extends Application {
  // Declare an array of Strings for flag titles
  private String[] flagTitles = {"Canada", "France", "United Kingdom"};

  // Declare an ImageView array for the national flags of 9 countries
   ImageView[] flagImage = {  
     new ImageView("https://upload.wikimedia.org/wikipedia/commons/3/39/Animated-Flag-Canada.gif")
    ,new ImageView("https://upload.wikimedia.org/wikipedia/commons/1/1d/Flag_of_France_%28WFB_2004%29.gif")
    ,new ImageView("https://upload.wikimedia.org/wikipedia/commons/5/58/UK_flag_m_v.gif")
  };
  
  // Declare an array of strings for flag descriptions
  private String[] flagDescription = new String[3];

  // Declare and create a description pane
  private DescriptionPane descriptionPane = new DescriptionPane();

  // Create a combo box for selecting countries
  private ComboBox<String> cbo = new ComboBox<>(); // flagTitles

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Set text description
    flagDescription[0] = "The Canadian national flag ...";
    flagDescription[1] = "Description for France ... ";
    flagDescription[2] = "Description for UK ... ";

    // Set the first country (Canada) for display
    setDisplay(0);
    
    for(ImageView jk : flagImage){
        jk.setFitWidth(100);
        jk.setFitHeight(80);
    }

    // Add combo box and description pane to the border pane
    BorderPane pane = new BorderPane();
      
    BorderPane paneForComboBox = new BorderPane();
    paneForComboBox.setLeft(new Label("Select a country: "));
    paneForComboBox.setCenter(cbo);
    pane.setTop(paneForComboBox);
    cbo.setPrefWidth(400);
    cbo.setValue("Canada");
    
    ObservableList<String> items = 
      FXCollections.observableArrayList(flagTitles);
    cbo.getItems().addAll(items); // Add items to combo box
    pane.setCenter(descriptionPane);
    
    // Display the selected country
    cbo.setOnAction(e -> setDisplay(items.indexOf(cbo.getValue())));
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 450, 170);
    primaryStage.setTitle("ComboBoxDemo"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  /** Set display information on the description pane */
  public void setDisplay(int index) {
    descriptionPane.setTitle(flagTitles[index]);
    descriptionPane.setImageView(flagImage[index]);
    descriptionPane.setDescription(flagDescription[index]);
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
  
  class DescriptionPane extends BorderPane {
    /** Label for displaying an image and a title */
    private Label lblImageTitle = new Label();

    /** Text area for displaying text */
    private TextArea taDescription = new TextArea();

    public DescriptionPane() {
      // Center the icon and text and place the text under the icon
      lblImageTitle.setContentDisplay(ContentDisplay.TOP);
      lblImageTitle.setPrefSize(200,  100);

      // Set the font in the label and the text field
      lblImageTitle.setFont(new Font("SansSerif", 16));
      taDescription.setFont(new Font("Serif", 14));

      taDescription.setWrapText(true);
      taDescription.setEditable(false);

      // Create a scroll pane to hold the text area
      ScrollPane scrollPane = new ScrollPane(taDescription);

      // Place label and scroll pane in the border pane
      setLeft(lblImageTitle);
      setCenter(scrollPane);
      setPadding(new Insets(5, 5, 5, 5));
    }

    /** Set the title */
    public void setTitle(String title) {
      lblImageTitle.setText(title);
    }

    /** Set the image view */
    public void setImageView(ImageView icon) {
      lblImageTitle.setGraphic(icon);
    }

    /** Set the text description */
    public void setDescription(String text) {
      taDescription.setText(text);
    }
  }
}