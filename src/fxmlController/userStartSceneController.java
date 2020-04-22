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
import javafx.scene.Node;


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
    
    Node nodeLeft=null;
    Node nodeRight=null;
    boolean controlBack=false;
    
    leftSceneAdminLoginController la = new leftSceneAdminLoginController();
    leftSceneUserLoginController lu = new leftSceneUserLoginController();
    startOptionsController so = new startOptionsController();   
    magneticParticleReportListController list = new magneticParticleReportListController();
    magneticParticleReportSceneController mag = new magneticParticleReportSceneController();
    UserAddController add = new UserAddController();
        

    public void initialize(URL url, ResourceBundle rb) {
        
        if(Strings.getUsername().equals("admin")){      //kullanıcı girişinde admin giriş yaparsa bu fonksiyon çalışacak
            left.getChildren().clear(); 
            left.getChildren().add(la);
        }else{
            left.getChildren().clear();
            left.getChildren().add(lu);
        } 
        
        right.getChildren().add(so);
        
        
        
        //userStartScene ekranında değişikliklere neden olan tuşlar
        
        ////////////////////////////////////
        ////////////////////////////////////
        
        //startOptions ekranındaki tuşlar
        
        so.getMan().setOnAction(e -> {              //1. raporun butonuna tıklanması
            backSave();
            right.getChildren().clear();
            right.getChildren().add(mag);
            
            left.getChildren().clear();
            left.getChildren().add(list);
        });

        so.getRad().setOnAction(e -> {
            backSave();
            System.out.println("2. Rapora tıklandı.");
            
        });
        
        ///////////////////////////
        ///////////////////////////
        
        //sol taraftaki tuşlar
        
        la.getUserAdd().setOnAction(a -> {          //admin control panelinde kullanıcı ekleye tıklama  
            backSave();
            right.getChildren().clear();
            right.getChildren().add(add);            
        });
        
                
        la.getBack().setOnAction(a->{
            left.getChildren().clear();
            right.getChildren().clear();
            left.getChildren().add(nodeLeft);
            right.getChildren().add(nodeRight);
            controlBack=false;
        });
  
             
        lu.getBack().setOnAction(a->{
            left.getChildren().clear();
            right.getChildren().clear();
            left.getChildren().add(nodeLeft);
            right.getChildren().add(nodeRight);
            controlBack=false;
        });
  
             
        list.getBack().setOnAction(a->{
            left.getChildren().clear();
            right.getChildren().clear();
            left.getChildren().add(nodeLeft);
            right.getChildren().add(nodeRight);
            controlBack=false;
        });
  
        
    }

    public void backSave(){
        if(controlBack==false){
        nodeLeft = left.getChildren().get(0);
        nodeRight = right.getChildren().get(0);
        la.getBack().setVisible(true);
        lu.getBack().setVisible(true);
        list.getBack().setVisible(true);
        controlBack=true;
        }
    }
    
 
}
