package MyPkg.CH_31.JavaFX_FXML;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FXMLController {
    @FXML private Label lblText;
    
    public void handleOnClick(){
        System.out.println("You clicked me!!");
        lblText.setText("You clicked me!!");
    }
}