/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlController;

import com.BIN.Config;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author sait_
 */
public class leftSceneAdminLoginController extends AnchorPane{
    
    public leftSceneAdminLoginController(){  
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxmlFiles/leftSceneAdminLogin.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(leftSceneAdminLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      
    }

    @FXML
    private void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
        
    }    
    
}
