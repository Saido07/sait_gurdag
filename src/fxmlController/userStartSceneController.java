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
import java.util.Vector;
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
    
    
    Vector <Node> nodeRight = new Vector<Node>();
    Vector <Node> nodeLeft = new Vector<Node>();
    boolean controlBack=false;
    
    leftSceneAdminLoginController la = new leftSceneAdminLoginController();
    leftSceneUserLoginController lu = new leftSceneUserLoginController();
    startOptionsController so = new startOptionsController();   
    magneticParticleReportListController list = new magneticParticleReportListController();
    magneticParticleReportSceneController mag = new magneticParticleReportSceneController();
    UserAddController add = new UserAddController();
    CustomerAddController cus = new CustomerAddController();
    EquipmentAddController equ = new EquipmentAddController();
    ProfilController pro = new ProfilController();
    SurfaceConAddController sur = new SurfaceConAddController();
    TestAddController test = new TestAddController();
    magneticParticleReportScene2Controller mag2 = new magneticParticleReportScene2Controller();
        

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
        
        //sağ taraftaki tuşlar
        
        mag.getNext().setOnAction(a->{
            backSave();
            right.getChildren().clear();
            right.getChildren().add(mag2); 
        });
        
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
        
        
        ////////////////////////////////////////////////////////////////////////
        //admin ekranı tuşları
        
        la.getUserAdd().setOnAction(a -> {          //admin control panelinde kullanıcı ekleye tıklama  
            backSave();
            right.getChildren().clear();
            right.getChildren().add(add);            
        });
        
                
        la.getBack().setOnAction(a->{
            turnBack();
        });
        
        la.getEquipmentAdd().setOnAction(a->{
            backSave();
            right.getChildren().clear();
            right.getChildren().add(equ);  
        });
  
        la.getSurfaceAdd().setOnAction(a->{
            backSave();
            right.getChildren().clear();
            right.getChildren().add(sur);  
        });
        
        la.getTestAdd().setOnAction(a->{
            backSave();
            right.getChildren().clear();
            right.getChildren().add(test);  
        });  
        
        la.getCustomerAdd().setOnAction(a->{
            backSave();
            right.getChildren().clear();
            right.getChildren().add(cus);  
        });
        
        la.getHome().setOnAction(a ->{
            home();
        });
        

        ////////////////////////////////////////////////////////////////////////
        //user ekranı tuşları
        
        lu.getEquipmentAdd().setOnAction(a->{
            backSave();
            right.getChildren().clear();
            right.getChildren().add(equ);  
        });
  
        lu.getSurfaceAdd().setOnAction(a->{
            backSave();
            right.getChildren().clear();
            right.getChildren().add(sur);  
        });
        
        lu.getTestAdd().setOnAction(a->{
            backSave();
            right.getChildren().clear();
            right.getChildren().add(test);  
        });  
        
        lu.getCustomerAdd().setOnAction(a->{
            backSave();
            right.getChildren().clear();
            right.getChildren().add(cus);  
        });
             
        lu.getBack().setOnAction(a->{
            turnBack();
        });
        
        lu.getHome().setOnAction(a ->{
            home();
        });
  
        ////////////////////////////////////////////////////////////////////////
        //list ekranı tuşları
        
        list.getBack().setOnAction(a->{
            turnBack();
        });
        
        list.getHome().setOnAction(a ->{
            home();
        });
  
        
    }

    int i=0;
    
    public void backSave(){
        if(i==0){
           controlBack=false; 
        }else{
            if(right.getChildren().get(0)!=nodeRight.get(i-1)){
                controlBack=false;
            }
        }
        backSaveIn();
    }

    public void backSaveIn(){
            if(i==0 && controlBack==false){
                nodeLeft.add(left.getChildren().get(0));
                nodeRight.add(right.getChildren().get(0));
                la.getBack().setVisible(true);
                lu.getBack().setVisible(true);
                list.getBack().setVisible(true);
                la.getHome().setVisible(true);
                lu.getHome().setVisible(true);
                list.getHome().setVisible(true);
                controlBack=true;
                i++;
            }else if(right.getChildren().get(0)!=nodeRight.get(i-1) && controlBack==false){
                nodeLeft.add(left.getChildren().get(0));
                nodeRight.add(right.getChildren().get(0));
                la.getBack().setVisible(true);
                lu.getBack().setVisible(true);
                list.getBack().setVisible(true);
                la.getHome().setVisible(true);
                lu.getHome().setVisible(true);
                list.getHome().setVisible(true);
                controlBack=true;
                i++;
            }

    }
    
    public void turnBack(){
            if(controlBack==true && i>0){
                if(left.getChildren().get(0)==nodeLeft.get(i-1) && right.getChildren().get(0)==nodeRight.get(i-1)){
                    left.getChildren().clear();
                    right.getChildren().clear();
                    left.getChildren().add(nodeLeft.get(i-2));
                    right.getChildren().add(nodeRight.get(i-2));
                }else{
                    left.getChildren().clear();
                    right.getChildren().clear();
                    left.getChildren().add(nodeLeft.get(i-1));
                    right.getChildren().add(nodeRight.get(i-1));
                }
                i--;
                if(right.getChildren().get(0).equals(so) && (left.getChildren().get(0).equals(la) || left.getChildren().get(0).equals(lu))){
                    nodeLeft.clear();
                    nodeRight.clear();
                    la.getBack().setVisible(false);
                    lu.getBack().setVisible(false);
                    la.getHome().setVisible(false);
                    lu.getHome().setVisible(false);
                    i=0;
                }         
            }    
    }
    
    public void home(){
        backSave();
        left.getChildren().clear();
        right.getChildren().clear();
        right.getChildren().add(nodeRight.get(0));
        left.getChildren().add(nodeLeft.get(0));
        la.getBack().setVisible(false);
        lu.getBack().setVisible(false);
        la.getHome().setVisible(false);
        lu.getHome().setVisible(false);
    }
}
