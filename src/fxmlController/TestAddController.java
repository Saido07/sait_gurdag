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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class TestAddController extends AnchorPane{

    @FXML
    private ComboBox<?> SelectTest;
    @FXML
    private TextField test;
    @FXML
    private Button save;
    @FXML
    private Button testDelete;
    @FXML
    private Label resultTxt;

    public TestAddController(){
        Config.Loader(this, "/fxmlFiles/testAdd.fxml");
    }
    
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
        
    }   
    
}
