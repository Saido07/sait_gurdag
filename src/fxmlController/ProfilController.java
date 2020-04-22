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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author sait_
 */
public class ProfilController extends AnchorPane{

    @FXML
    private TextField username;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private PasswordField pass1;
    @FXML
    private PasswordField pass2;
    @FXML
    private Button save;
    @FXML
    private Label resultTxt;

    public ProfilController(){
        Config.Loader(this, "/fxmlFiles/profil.fxml");
    }
    
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
        
    }     
    
}
