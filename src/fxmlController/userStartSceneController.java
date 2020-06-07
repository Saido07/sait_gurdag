package fxmlController;

import com.BIN.Strings;
import com.BIN.User;
import com.excel.Excel;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;


public class userStartSceneController implements Initializable{
    
    Image imageY = new Image("/images/icons/yCheck.png");

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
    
    
    Vector <Node> nodeRight = new Vector<Node>();           //geri alma sırasının kayd. vectorler
    Vector <Node> nodeLeft = new Vector<Node>();
    boolean controlBack=false;                              //geri komutunun bozulmasını önlemek için
    
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
    magneticParticleReportScene3Controller mag3 = new magneticParticleReportScene3Controller();
    magneticParticleReportScene4Controller mag4 = new magneticParticleReportScene4Controller();
    magneticParticleReportScene5Controller mag5 = new magneticParticleReportScene5Controller();
    Excel e = new Excel();    

    public void initialize(URL url, ResourceBundle rb) {
        
        if(User.getUsername().equals("admin")){      //kullanıcı girişinde admin giriş yaparsa bu fonksiyon çalışacak
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
        
        mag.getNext().setOnAction(a->{              //mag. raporunda sonraki tuşu fonksiyonu
            backSave();
            
            right.getChildren().clear();
            right.getChildren().add(mag2);
            
            list.getList().setExpandedPane(list.getTitle2());
            
            if(Strings.getOkey1()){
                list.getImaP1().setImage(imageY);
            }
        });
        
        mag2.getNext2().setOnAction(a->{              //mag. raporunda sonraki tuşu fonksiyonu
            backSave();
            
            right.getChildren().clear();
            right.getChildren().add(mag3);
            
            list.getList().setExpandedPane(list.getTitle3());
        });
        
        mag3.getNext().setOnAction(a->{              //mag. raporunda sonraki tuşu fonksiyonu
            backSave();
            
            right.getChildren().clear();
            right.getChildren().add(mag4);
            
            list.getList().setExpandedPane(list.getTitle4());
        });
        
        mag4.getNext().setOnAction(a->{              //mag. raporunda sonraki tuşu fonksiyonu
            backSave();
            
            right.getChildren().clear();
            right.getChildren().add(mag5);
            
            list.getList().setExpandedPane(list.getTitle5());
            mag5.getMusName().setText(Strings.getMusName());
        });
        
        mag5.getSaveExcel().setOnAction(a->{

            try {
                e.doInBackground();
                WriteFon();
                e.finallyE();
            } catch (IOException ex) {
                Logger.getLogger(userStartSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        mag5.getSavePDF().setOnAction(a->{
            try {   
                e.doInBackground();
                WriteFon();
                e.finallyPDF();
            } catch (IOException ex) {
                Logger.getLogger(userStartSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        //startOptions ekranındaki tuşlar
        
        so.getMan().setOnAction(e -> {              //1. rapor tuşu fonksiyonu
            backSave();
            right.getChildren().clear();
            right.getChildren().add(mag);
            
            left.getChildren().clear();
            left.getChildren().add(list);
            
            list.getList().setExpandedPane(list.getTitle1());
        });

        so.getRad().setOnAction(e -> {              //2. rapor tuşu fonksiyonu
           // backSave();
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
        
                
        la.getBack().setOnAction(a->{               //geri tuşu fonksiyonu
            turnBack();
        });
        
        la.getEquipmentAdd().setOnAction(a->{       //ekip. ekleme tuşu fonk.
            backSave();
            right.getChildren().clear();
            right.getChildren().add(equ);  
        });
  
        la.getSurfaceAdd().setOnAction(a->{         //yüzey d. ekleme tuşu fonk.
            backSave();
            right.getChildren().clear();
            right.getChildren().add(sur);  
        });
        
        la.getTestAdd().setOnAction(a->{            //test ek. tuşu fonk.
            backSave();
            right.getChildren().clear();
            right.getChildren().add(test);  
        });  
        
        la.getCustomerAdd().setOnAction(a->{        //müşt. ekl. tuşu fonk.
            backSave();
            right.getChildren().clear();
            right.getChildren().add(cus);  
        });
        
        la.getHome().setOnAction(a ->{              //anasayfa tuşu fonk.
            home();
        });
        
        la.getImage().setOnMouseClicked(a ->{       //profil resmine tıkl. fonk.
            backSave();
            right.getChildren().clear();
            right.getChildren().add(pro); 
        });
        
        la.getText().setOnMouseClicked(a ->{        //kullanıcı adının üzerine tıkl. fonk.
            backSave();
            right.getChildren().clear();
            right.getChildren().add(pro);
        });
        

        ////////////////////////////////////////////////////////////////////////
        //user ekranı tuşları
        
        lu.getEquipmentAdd().setOnAction(a->{       //ekip. ekleme tuşu fonk.
            backSave();
            right.getChildren().clear();
            right.getChildren().add(equ);  
        });
  
        lu.getSurfaceAdd().setOnAction(a->{         //yüzey d. ekl. tuşu fonk.
            backSave();
            right.getChildren().clear();
            right.getChildren().add(sur);  
        });
        
        lu.getTestAdd().setOnAction(a->{            //test ekl. tuşu fonk.
            backSave();
            right.getChildren().clear();
            right.getChildren().add(test);  
        });  
        
        lu.getCustomerAdd().setOnAction(a->{        //müşt. ekl. tuşu fonk.
            backSave();
            right.getChildren().clear();
            right.getChildren().add(cus);  
        });
             
        lu.getBack().setOnAction(a->{               //geri tuşu fonk.
            turnBack();
        });
        
        lu.getHome().setOnAction(a ->{              //anasay. tuşu fonk.
            home();
        });
        
        lu.getImage().setOnMouseClicked(a ->{       //profil resmi üzerine tıklama fonk.
            backSave();
            right.getChildren().clear();
            right.getChildren().add(pro); 
        });
        
        lu.getUsername().setOnMouseClicked(a ->{    //kullanıcı adının üzerine tıkl. fonk.
            backSave();
            right.getChildren().clear();
            right.getChildren().add(pro);
        });
  
        ////////////////////////////////////////////////////////////////////////
        //list ekranı tuşları
        
        list.getBack().setOnAction(a->{             //liste ekranında geri fonk.
            turnBack();
        });
        
        list.getHome().setOnAction(a ->{            //liste ekra. anasay. fonk.
            home();
        });
  
        
    }

    int i=0;
    
    public void backSave(){                         //geri alma sırasını kaydetme 1. aşama
        if(i==0){
           controlBack=false; 
        }else{
            if(right.getChildren().get(0)!=nodeRight.get(i-1)){
                controlBack=false;
            }
        }
        backSaveIn();
    }

    public void backSaveIn(){                       //geri alma sırasını kaydetme 2. aşama
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
    
    public void turnBack(){                         //geri alma fonk.
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
    
    public void home(){                             //home fonksiyonu
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
    
    public void WriteFon(){
                e.writeE(2, 3, mag.getMusteriler().getValue().toString().
                    substring(mag.getMusteriler().getValue().toString().indexOf("| ")).substring(mag.getMusteriler().getValue().toString().indexOf(" ")));
                e.writeE(3, 3, mag.getProjeler().getValue().toString().
                        substring(mag.getProjeler().getValue().toString().indexOf(" ")));
                e.writeE(4, 3, mag.getTestYeri().getText().toString());
                e.writeE(5, 3, mag.getMuayeneStandart().getText().toString());
                e.writeE(6, 3, mag.getDegerStand().getText().toString());
                e.writeE(2, 19, mag.getMuaPro().getText().toString());
                e.writeE(3, 19, mag.getMuaKap().getText().toString());
                e.writeE(4, 19, mag.getResimNo().getText().toString());
                e.writeE(5, 19, mag.getYuzeyDurum().getValue().toString().
                        substring(mag.getYuzeyDurum().getValue().toString().indexOf(" ")));
                e.writeE(6, 19, mag.getMuaAsa().getValue().toString());
                e.writeE(2, 26, mag.getSayfaNo().getText().toString());
                e.writeE(3, 26, mag.getRaporNo().getText().toString());
                e.writeE(4, 26, mag.getRaporTarih().getText().toString());
                e.writeE(5, 26, mag.getIsEmriNo().getText().toString());
                e.writeE(6, 26, mag.getTeklifNo().getText().toString());
                e.writeE(8, 4, mag2.getKutupMesafe().getText().toString());
                e.writeE(9, 4, mag2.getCihaz().getValue().toString().
                        substring(mag2.getCihaz().getValue().toString().indexOf("| ")).substring(mag2.getCihaz().getValue().toString().indexOf(" ")));
                e.writeE(10, 4, mag2.getMpTasiOrt().getText().toString());
                e.writeE(11, 4, mag2.getMiklatisTek().getText().toString());
                e.writeE(12, 4, mag2.getUvIsikSid().getText().toString());
                e.writeE(13, 4, mag2.getIsikMesa().getText().toString());
                e.writeE(8, 16, mag2.getMuaBol().getText().toString());
                e.writeE(9, 16, mag2.getAkimTip().getValue().toString());
                e.writeE(10, 16, mag2.getLuxIsikSid().getText().toString());
                e.writeE(11, 16, mag2.getMuaOrt().getText().toString());
                e.writeE(12, 16, mag2.getMikGider().getText().toString());
                e.writeE(13, 16, mag2.getIsilIslem().getText().toString());
                e.writeE(8, 25, mag2.getYuzeySicak().getText().toString());
                e.writeE(9, 25, mag2.getMuaBolAlanSid().getText().toString());
                e.writeE(11, 25, mag2.getYuzey().getText().toString());
                e.writeE(12, 25, mag2.getIsikCihazTanim().getText().toString());
                e.writeE(13, 25, mag2.getKaldirmaTestTarihNo().getText().toString());
                e.writeE(19, 7, mag3.getStandart().getText().toString());
                e.writeE(20, 7, mag3.getMuaTarih().getText().toString());
                e.writeE(21, 7, mag3.getAciklama().getText().toString());
                
                if(mag4.getI()>=2){
                    e.writeE(24, 1, mag4.getKaynak1().getText().toString());
                    e.writeE(24, 8, mag4.getKontrolU1().getText().toString());
                    e.writeE(24, 11, mag4.getKaynakY1().getText().toString());
                    e.writeE(24, 17, mag4.getKalinlik1().getText().toString());
                    e.writeE(24, 18, mag4.getCap1().getText().toString());
                    e.writeE(24, 22, mag4.getHata1().getText().toString());
                    e.writeE(24, 24, mag4.getHataY1().getText().toString());
                    e.writeE(24, 27, mag4.getSonuc1().getText().toString());
                }
                if(mag4.getI()>=3){
                    e.writeE(25, 1, mag4.getKaynak2().getText().toString());
                    e.writeE(25, 8, mag4.getKontrolU2().getText().toString());
                    e.writeE(25, 11, mag4.getKaynakY2().getText().toString());
                    e.writeE(25, 17, mag4.getKalinlik2().getText().toString());
                    e.writeE(25, 18, mag4.getCap2().getText().toString());
                    e.writeE(25, 22, mag4.getHata2().getText().toString());
                    e.writeE(25, 24, mag4.getHataY2().getText().toString());
                    e.writeE(25, 27, mag4.getSonuc2().getText().toString());
                    
                }
                if(mag4.getI()>=4){
                    e.writeE(26, 1, mag4.getKaynak3().getText().toString());
                    e.writeE(26, 8, mag4.getKontrolU3().getText().toString());
                    e.writeE(26, 11, mag4.getKaynakY3().getText().toString());
                    e.writeE(26, 17, mag4.getKalinlik3().getText().toString());
                    e.writeE(26, 18, mag4.getCap3().getText().toString());
                    e.writeE(26, 22, mag4.getHata3().getText().toString());
                    e.writeE(26, 24, mag4.getHataY3().getText().toString());
                    e.writeE(26, 27, mag4.getSonuc3().getText().toString());
                }
                if(mag4.getI()>=5){
                    e.writeE(27, 1, mag4.getKaynak4().getText().toString());
                    e.writeE(27, 8, mag4.getKontrolU4().getText().toString());
                    e.writeE(27, 11, mag4.getKaynakY4().getText().toString());
                    e.writeE(27, 17, mag4.getKalinlik4().getText().toString());
                    e.writeE(27, 18, mag4.getCap4().getText().toString());
                    e.writeE(27, 22, mag4.getHata4().getText().toString());
                    e.writeE(27, 24, mag4.getHataY4().getText().toString());
                    e.writeE(27, 27, mag4.getSonuc4().getText().toString());
                }
                if(mag4.getI()>=6){
                    e.writeE(28, 1, mag4.getKaynak5().getText().toString());
                    e.writeE(28, 8, mag4.getKontrolU5().getText().toString());
                    e.writeE(28, 11, mag4.getKaynakY5().getText().toString());
                    e.writeE(28, 17, mag4.getKalinlik5().getText().toString());
                    e.writeE(28, 18, mag4.getCap5().getText().toString());
                    e.writeE(28, 22, mag4.getHata5().getText().toString());
                    e.writeE(28, 24, mag4.getHataY5().getText().toString());
                    e.writeE(28, 27, mag4.getSonuc5().getText().toString());
                }
 
                e.writeE(34, 5, mag5.getOpeName().getValue().toString().substring(mag5.getOpeName().
                        getValue().toString().indexOf("| ")).substring(mag5.getOpeName().getValue().toString().indexOf(" ")));
                e.writeE(35, 5, mag5.getOpLevel().getText().toString());
                e.writeE(36, 5, mag5.getOpTarih().getText().toString());
                e.writeE(34, 15, mag5.getDegerName().getValue().toString().substring(mag5.getDegerName().
                        getValue().toString().indexOf("| ")).substring(mag5.getDegerName().getValue().toString().indexOf(" ")));
                e.writeE(35, 15, mag5.getdLevel().getText().toString());
                e.writeE(36, 15, mag5.getdTarih().getText().toString());
                e.writeE(34, 20, mag5.getOnayName().getValue().toString().substring(mag5.getOnayName().
                        getValue().toString().indexOf("| ")).substring(mag5.getOnayName().getValue().toString().indexOf(" ")));
                e.writeE(35, 20, mag5.getoLevel().getText().toString());
                e.writeE(36, 20, mag5.getoTarih().getText().toString());
                e.writeE(34, 25, mag5.getMusName().getText().toString());
                e.writeE(36, 25, mag5.getCusTarih().getText().toString());
    }
}
