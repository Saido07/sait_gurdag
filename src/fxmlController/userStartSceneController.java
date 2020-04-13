/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import com.BIN.Strings;


public class userStartSceneController implements Initializable {

    @FXML
    private AnchorPane left;
    @FXML
    private AnchorPane right;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
      if(Strings.getUsername().equals("admin")){
        leftSceneAdminLoginController la = new leftSceneAdminLoginController();
        left.getChildren().add(la);
      }else{
        leftSceneUserLoginController lu = new leftSceneUserLoginController();
        left.getChildren().add(lu);
      }
      
     
      startOptionsController sa = new startOptionsController();
      right.getChildren().add(sa);
      
      
        
    }    
    
}
