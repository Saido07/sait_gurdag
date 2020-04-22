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
public class CustomerAddController extends AnchorPane {

    @FXML
    private ComboBox<?> SelectCustomer;
    @FXML
    private TextField customerName;
    @FXML
    private TextField place;
    @FXML
    private TextField jobOrderNo;
    @FXML
    private TextField offerNo;
    @FXML
    private Button save;
    @FXML
    private Button customerDelete;
    @FXML
    private Label resultTxt;

    /**
     * Initializes the controller class.
     */
    
    public CustomerAddController(){
        Config.Loader(this, "/fxmlFiles/customerAdd.fxml");
    }
    
    
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
        
    }  
}
