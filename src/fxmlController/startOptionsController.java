package fxmlController;

/////////////////////Sait Gürdağ-160501132

import com.BIN.Config;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


public class startOptionsController extends AnchorPane {

    @FXML
    private Button man;
    @FXML
    private Button rad;


    public startOptionsController(){
        Config.Loader(this, "/fxmlFiles/startOptions.fxml");
    }
    
    @FXML
    public void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
    }   

    public Button getMan() {
        return man;
    }

    public Button getRad() {
        return rad;
    }

    
    
}
