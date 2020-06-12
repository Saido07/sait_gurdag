package fxmlController;

import com.BIN.Customer;
import com.BIN.Equi;
import com.BIN.Strings;
import com.BIN.Surface;
import com.BIN.Test;
import com.BIN.User;
import com.aspose.cells.b.a.b.zk;
import com.database.database;
import com.excel.Excel;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;


public class userStartSceneController implements Initializable{
    database db = new database();
    
    Image imageY = new Image("/images/icons/yCheck.png");
    Image imageN = new Image("/images/icons/gCheck.png");

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
                
            if(mag.getMusteriler().getValue() != null && mag.getProjeler().getValue() != null &&
                    mag.getTestYeri().getText().isEmpty()==false && mag.getMuayeneStandart().getText().isEmpty()==false &&
                    mag.getDegerStand().getText().isEmpty()==false && mag.getMuaPro().getText().isEmpty()==false &&
                    mag.getMuaKap().getText().isEmpty()==false && mag.getYuzeyDurum().getValue() != null &&
                    mag.getMuaAsa().getValue() != null && mag.getSayfaNo().getText().isEmpty()==false &&
                    mag.getRaporNo().getText().isEmpty()==false && mag.getRaporTarih().getText().isEmpty()==false &&
                    mag.getIsEmriNo().getText().isEmpty()==false && mag.getTeklifNo().getText().isEmpty()==false){
                list.getImaP1().setImage(imageY);
                Strings.setOkey1(true);
            }else{
                list.getImaP1().setImage(imageN);
                Strings.setOkey1(false);
            }
            
        });
        
        mag2.getNext2().setOnAction(a->{              //mag. raporunda sonraki tuşu fonksiyonu
            backSave();
            
            right.getChildren().clear();
            right.getChildren().add(mag3);
            
            list.getList().setExpandedPane(list.getTitle3());
            
            if(mag2.getCihaz().getValue() != null && mag2.getKutupMesafe().getText().isEmpty()==false && 
                    mag2.getMpTasiOrt().getText().isEmpty()==false && mag2.getMiklatisTek().getText().isEmpty()==false &&
                    mag2.getUvIsikSid().getText().isEmpty()==false && mag2.getIsikMesa().getText().isEmpty()==false &&
                    mag2.getMuaBol().getText().isEmpty()==false && mag2.getAkimTip().getValue() != null &&
                    mag2.getLuxIsikSid().getText().isEmpty()==false && mag2.getYuzeySicak().getText().isEmpty()==false &&
                    mag2.getMuaBolAlanSid().getText().isEmpty()==false && mag2.getYuzey().getText().isEmpty()==false &&
                    mag2.getIsikCihazTanim().getText().isEmpty()==false && mag2.getKaldirmaTestTarihNo().getText().isEmpty()==false){
                list.getImaP2().setImage(imageY);
                Strings.setOkey2(true);
            }else{
                list.getImaP2().setImage(imageN);
                Strings.setOkey2(false);
            }
        });
        
        mag3.getNext().setOnAction(a->{              //mag. raporunda sonraki tuşu fonksiyonu
            backSave();
            
            right.getChildren().clear();
            right.getChildren().add(mag4);
            
            list.getList().setExpandedPane(list.getTitle4());
            
            if((mag3.getC1().isSelected() || mag3.getC2().isSelected()) && mag3.getStandart().getText().isEmpty()==false && 
                    mag3.getMuaTarih().getText().isEmpty()==false){
                list.getImaP3().setImage(imageY);
                Strings.setOkey3(true);
            }else{
                list.getImaP3().setImage(imageN);
                Strings.setOkey3(false);
            }
        });
        
        mag4.getNext().setOnAction(a->{              //mag. raporunda sonraki tuşu fonksiyonu
            backSave();
            
            right.getChildren().clear();
            right.getChildren().add(mag5);
            list.getList().setExpandedPane(list.getTitle5());
            mag5.getMusName().setText(Strings.getMusName());
            mag5.getError().setVisible(false);
            mag5.getError2().setVisible(false);
                        
            boolean bi=false;
            boolean ik=false;
            boolean uc=false;
            boolean dor=false;
            boolean be=false;
            
            if(mag4.getI()>=2){
                if(mag4.getKaynak1().getText().isEmpty()==false &&
                mag4.getKontrolU1().getText().isEmpty()==false &&
                mag4.getKaynakY1().getText().isEmpty()==false &&
                mag4.getKalinlik1().getText().isEmpty()==false &&
                mag4.getCap1().getText().isEmpty()==false &&
                mag4.getSonuc1().getText().isEmpty()==false){
                    bi=true;
                }    
            }
            if(mag4.getI()>=3){
                if(mag4.getKaynak2().getText().isEmpty()==false &&
                mag4.getKontrolU2().getText().isEmpty()==false &&
                mag4.getKaynakY2().getText().isEmpty()==false &&
                mag4.getKalinlik2().getText().isEmpty()==false &&
                mag4.getCap2().getText().isEmpty()==false &&
                mag4.getSonuc2().getText().isEmpty()==false){
                    
                    ik=true;
                }    
            }
            if(mag4.getI()>=4){
                if(mag4.getKaynak3().getText().isEmpty()==false &&
                mag4.getKontrolU3().getText().isEmpty()==false &&
                mag4.getKaynakY3().getText().isEmpty()==false &&
                mag4.getKalinlik3().getText().isEmpty()==false &&
                mag4.getCap3().getText().isEmpty()==false &&
                mag4.getSonuc3().getText().isEmpty()==false){
                    
                    uc=true;
                }    
            }
            if(mag4.getI()>=5){
                if(mag4.getKaynak4().getText().isEmpty()==false &&
                mag4.getKontrolU4().getText().isEmpty()==false &&
                mag4.getKaynakY4().getText().isEmpty()==false &&
                mag4.getKalinlik4().getText().isEmpty()==false &&
                mag4.getCap4().getText().isEmpty()==false &&
                mag4.getSonuc4().getText().isEmpty()==false){
                    
                    dor=true;
                    
                }
            }
            if(mag4.getI()>=6){
                if(mag4.getKaynak5().getText().isEmpty()==false &&
                mag4.getKontrolU5().getText().isEmpty()==false &&
                mag4.getKaynakY5().getText().isEmpty()==false &&
                mag4.getKalinlik5().getText().isEmpty()==false &&
                mag4.getCap5().getText().isEmpty()==false &&
                mag4.getSonuc5().getText().isEmpty()==false){
                    be=true;
                    
                }
            }
            
            if(bi==true && mag4.getI()==2){
                list.getImaP4().setImage(imageY);
                Strings.setOkey4(true);
            }else if(bi==true && ik==true && mag4.getI()==3){
                list.getImaP4().setImage(imageY);
                Strings.setOkey4(true);
            }else if(bi==true && ik==true && uc==true && mag4.getI()==4){
                list.getImaP4().setImage(imageY);
                Strings.setOkey4(true);
            }else if(bi==true && ik==true && uc==true && dor==true && mag4.getI()==5){
                list.getImaP4().setImage(imageY);
                Strings.setOkey4(true);
            }else if(bi==true && ik==true && uc==true && dor==true && be==true && mag4.getI()==6){
                list.getImaP4().setImage(imageY);
                Strings.setOkey4(true);
            }else{
                list.getImaP4().setImage(imageN);
                Strings.setOkey4(false);
            }
        });
        
        mag5.getSaveExcel().setOnAction(a->{
            if(mag5Control()==true){
                list.getImaP5().setImage(imageY);
                Strings.setOkey5(true);
            }else{
                list.getImaP5().setImage(imageN);
                Strings.setOkey5(false);
            }
                
            if(Strings.getOkey1() && Strings.getOkey2() && Strings.getOkey3() && Strings.getOkey4() && Strings.getOkey5()){
                mag5.getError().setVisible(false);
                mag5.getError2().setVisible(false);
                try {
                    e.doInBackground();
                    WriteFon();
                    e.finallyE();
                } catch (IOException ex) {
                    Logger.getLogger(userStartSceneController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                mag5.getError().setVisible(true);
                mag5.getError2().setVisible(true);
            }
        });
        
        mag5.getSavePDF().setOnAction(a->{
            if(mag5Control()==true){
                list.getImaP5().setImage(imageY);
                Strings.setOkey5(true);
               
            }else{
                list.getImaP5().setImage(imageN);
                Strings.setOkey5(false);
            }
            if(Strings.getOkey1() && Strings.getOkey2() && Strings.getOkey3() && Strings.getOkey4() && Strings.getOkey5()){
                mag5.getError().setVisible(false);
                mag5.getError2().setVisible(false);
                try {   
                    e.doInBackground();
                    WriteFon();
                    e.finallyPDF();
                } catch (IOException ex) {
                    Logger.getLogger(userStartSceneController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                mag5.getError().setVisible(true);
                mag5.getError2().setVisible(true);
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
            
            refresh();
            
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
        
        list.getTitle1().setOnMouseClicked(a ->{
            backSave();
            
            right.getChildren().clear();
            right.getChildren().add(mag);
        });
        
        list.getTitle2().setOnMouseClicked(a ->{
            backSave();
            
            right.getChildren().clear();
            right.getChildren().add(mag2);
        });
        
        list.getTitle3().setOnMouseClicked(a ->{
            backSave();
            
            right.getChildren().clear();
            right.getChildren().add(mag3);
        });
        
        list.getTitle4().setOnMouseClicked(a ->{
            backSave();
            
            right.getChildren().clear();
            right.getChildren().add(mag4);
        });
  
        list.getTitle5().setOnMouseClicked(a ->{
            backSave();
            
            right.getChildren().clear();
            right.getChildren().add(mag5);
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
                    Strings.setListBack(nodeRight.get(i-1).toString().substring(0, nodeRight.get(i-1).toString().indexOf("@")));
                    if(Strings.getListBack().equals("magneticParticleReportSceneController")==true){
                        list.getList().setExpandedPane(list.getTitle1());
                    }else if(Strings.getListBack().equals("magneticParticleReportScene2Controller")==true){
                        list.getList().setExpandedPane(list.getTitle2());    
                    }else if(Strings.getListBack().equals("magneticParticleReportScene3Controller")==true){
                        list.getList().setExpandedPane(list.getTitle3());
                    }else if(Strings.getListBack().equals("magneticParticleReportScene4Controller")==true){
                        list.getList().setExpandedPane(list.getTitle4());
                    }else if(Strings.getListBack().equals("magneticParticleReportScene5Controller")==true){
                        list.getList().setExpandedPane(list.getTitle5());
                    }
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
        left.getChildren().clear();
        right.getChildren().clear();
        right.getChildren().add(nodeRight.get(0));
        left.getChildren().add(nodeLeft.get(0));
        nodeLeft.clear();
        nodeRight.clear();
        i=0;
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
    
    public boolean mag5Control(){
        if(mag5.getoTarih().getText().isEmpty()==false && mag5.getoLevel().getText().isEmpty()==false && mag5.getdTarih().getText().isEmpty()==false &&
                mag5.getdLevel().getText().isEmpty()==false && mag5.getOpeName().getValue() != null && mag5.getCusTarih().getText().isEmpty()==false &&
                mag5.getOpTarih().getText().isEmpty()==false && mag5.getOpLevel().getText().isEmpty()==false && mag5.getOnayName().getValue() != null &&
                mag5.getDegerName().getValue() != null && mag5.getMusName().getText().isEmpty()==false){
            return true;
        }else{
            return false;
        }   
        
    }
    
    public void refresh(){
        try {
                db.doInBackground("getCustomer2");
                db.doInBackground("getTest2");
                db.doInBackground("getSurface2");
                db.doInBackground("getusers2");
                db.doInBackground("getEqui2");
        } catch (SQLException ex) {
            Logger.getLogger(userStartSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(userStartSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(Strings.getOy()){
            System.out.println("55");
            mag.getYuzeyDurum().getItems().setAll(Surface.getSurface2());
            Strings.setOy(false);
        }
        if(Strings.getOm()){
            System.out.println("66");
            mag.getMusteriler().getItems().setAll(Customer.getCustomers2());
            Strings.setOm(false);
        }
        if(Strings.getOp()){
            System.out.println("77");
            mag.getProjeler().getItems().setAll(Test.getTest2());
            Strings.setOp(false);
        }    
        if(Strings.getOku()){
            System.out.println("88");
            mag5.getOpeName().getItems().setAll(User.getUsers2());
            mag5.getDegerName().getItems().setAll(User.getUsers2());
            mag5.getOnayName().getItems().setAll(User.getUsers2());
            mag5.getOpLevel().clear();
            mag5.getoLevel().clear();
            mag5.getdLevel().clear();
            Strings.setOku(false);
        }    
        if(Strings.getOc()){
            System.out.println("99");
            mag2.getCihaz().getItems().setAll(Equi.getEqui2());
            Strings.setOc(false);
        }
    }
    
}
