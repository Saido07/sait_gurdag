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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author sait_
 */
public class UserAddController extends AnchorPane {

    @FXML
    private Button newUser;
    @FXML
    private ComboBox<?> SelectUser;
    @FXML
    private TextField userName;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField signature_e_date;
    @FXML
    private Button save;
    @FXML
    private Button userDelete;
    
    public UserAddController(){
        Config.Loader(this,"/fxmlFiles/userAdd.fxml");
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
    }    
    
}
