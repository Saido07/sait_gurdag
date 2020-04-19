/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlController;

import com.BIN.Config;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author sait_
 */
public class leftSceneAdminLoginController extends AnchorPane{
   
    @FXML
    private Label text;

    @FXML
    private Button userAdd;

    @FXML
    private Button customerAdd;

    @FXML
    private Button testAdd;

    @FXML
    private Button surfaceAdd;
    
    @FXML
    private Button equipmentAdd;
    
    public leftSceneAdminLoginController(){  
        Config.Loader(this, "/fxmlFiles/leftSceneAdminLogin.fxml");
    }

   


    
    @FXML
    private void initialize() {
        
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0); 
    }  

    public Button getUserAdd() {
        return userAdd;
    }
       
    
}
