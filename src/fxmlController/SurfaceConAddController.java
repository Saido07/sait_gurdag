/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlController;

import com.BIN.Config;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author sait_
 */
public class SurfaceConAddController extends AnchorPane{

    @FXML
    private ComboBox<?> SelectSurface;
    @FXML
    private TextField surface;
    @FXML
    private Button save;
    @FXML
    private Button surfaceDelete;
    @FXML
    private Label resultTxt;

   
    public SurfaceConAddController(){
        Config.Loader(this, "/fxmlFiles/surfaceConAdd.fxml");
    }
    
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
        
    }    
    
}
