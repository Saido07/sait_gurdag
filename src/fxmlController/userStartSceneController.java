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
        leftSceneUserLoginController lu = new leftSceneUserLoginController();
        startOptionsController so = new startOptionsController();   
        magneticParticleReportListController list = new magneticParticleReportListController();
        magneticParticleReportSceneController mag = new magneticParticleReportSceneController();
        
        
        if(Strings.getUsername().equals("admin")){      //kullanıcı girişinde admin giriş yaparsa bu fonksiyon çalışacak
            left.getChildren().clear(); 
            left.getChildren().add(la);
        }else{
            left.getChildren().clear();
            left.getChildren().add(lu);
        } 
        
        right.getChildren().add(so);
        
        //userStartScene ekranında değişikliklere neden olan tuşlar
        
        so.getMan().setOnAction(e -> {              //1. raporun butonuna tıklanması
            System.out.println("nura");
            right.getChildren().clear();
            right.getChildren().add(mag); 
            left.getChildren().clear();
            left.getChildren().add(list);
        });
        
        la.getUserAdd().setOnAction(a -> {          //admin control panelinde kullanıcı ekleye tıklama  
            right.getChildren().clear();
            UserAddController add = new UserAddController();
            right.getChildren().add(add);            
        });
        
        so.getRad().setOnAction(e -> {
            
            System.out.println("2. Rapora tıklandı.");
            
        });
        
     
        
        
        
        
    }

 
    
 
}
