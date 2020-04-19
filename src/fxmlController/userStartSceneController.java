/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlController;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import com.BIN.Strings;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


public class userStartSceneController implements Initializable{
    


    @FXML
    private AnchorPane left;
    @FXML
    private AnchorPane right;

    public AnchorPane getLeft() {
        return left;
    }

    public AnchorPane getRight() {
        return right;
    }
    
    
    

    public void initialize(URL url, ResourceBundle rb) {
        leftSceneAdminLoginController la = new leftSceneAdminLoginController();
        if(Strings.getUsername().equals("admin")){
            left.getChildren().clear(); 
            left.getChildren().add(la);
        }else{
            left.getChildren().clear();
            leftSceneUserLoginController lu = new leftSceneUserLoginController();
            left.getChildren().add(lu);
        }  
        
        startOptionsController sa = new startOptionsController();
        right.getChildren().add(sa);
        
        la.getUserAdd().setOnAction(a -> {
            
            right.getChildren().clear();
            UserAddController add = new UserAddController();
            right.getChildren().add(add);
            
        });
        
    }

 
    
 
}
