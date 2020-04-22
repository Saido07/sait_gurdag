/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlController;

import com.BIN.Config;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author sait_
 */
public class leftSceneUserLoginController extends AnchorPane {
    
    @FXML
    private Button back;

    //butonların get fonksiyonları
    
    public Button getBack() {
        return back;
    }
    

    public leftSceneUserLoginController(){  
      Config.Loader(this, "/fxmlFiles/leftSceneUserLogin.fxml");
    }
    
    @FXML
    public void initialize() {
       Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
      
    }   
    

}
