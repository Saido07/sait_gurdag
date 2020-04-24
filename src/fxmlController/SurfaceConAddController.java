/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlController;

import com.BIN.Config;
import com.BIN.Strings;
import com.database.database;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author sait_
 */
public class SurfaceConAddController extends AnchorPane{

    @FXML
    private ComboBox<?> SelectSurface;
    @FXML
    private TextField surface;
    @FXML
    private Button save;
    @FXML
    private Button surfaceDelete;
    @FXML
    private Label resultTxt;
    
    database db = new database();

    boolean result;
   
    public SurfaceConAddController(){
        Config.Loader(this, "/fxmlFiles/surfaceConAdd.fxml");
        
        try {
            db.doInBackground("getSurface");
        } catch (SQLException ex) {
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        SelectSurface.getItems().setAll(Strings.getSurface());
    }
    
    @FXML
    public void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
        
        SelectSurface.setOnAction(a ->{
            if(SelectSurface.isShowing()==true){
                Strings.setDb_surId(SelectSurface.getValue().toString().
                        substring(0, SelectSurface.getValue().toString().indexOf(" "))); // seçilen yüzeyin id'sini alıyor.
            } 
            if(Strings.getDb_surId().equals("Yeni")){
                surface.clear();
            }else{
                try {
                    db.doInBackground("findSurface", Strings.getDb_surId());
                } catch (SQLException ex) {
                    Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
                }

                surface.setText(Strings.getDb_surf_name());
               
            }
        });
        
        save.setOnAction(b -> {
            if(Strings.getDb_surId()==null){
                addSurface();
            }else if(SelectSurface.getValue().toString().equals("Yeni Yüzey Durumu")){                
                addSurface();
            }else{
                if(Strings.getDb_surId()!=null){
                try {
                    result=db.doInBackground("updateSurface", surface.getText().toString());
                    if(result==false){
                        resultTxt.setStyle("-fx-text-fill: red;");
                        resultTxt.setText("Hatalı ya da Eksik Bilgi");
                    }else{
                        resultTxt.setStyle("-fx-text-fill: black;");
                        resultTxt.setText("Yüzey Durumu Bilgileri Başarıyla Güncellendi");
                        refreshSelectSurface();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            }
        });
        
        surfaceDelete.setOnAction(n ->{
            if(Strings.getDb_surId().equals("Yeni")){
                resultTxt.setStyle("-fx-text-fill: red;");
                resultTxt.setText("Hatalı İşlem");
            }else{
            try {
                db.doInBackground("surfaceDelete", Strings.getDb_surId());
                String surface = SelectSurface.getValue().toString().substring(SelectSurface.getValue().toString().indexOf("|"));
                surface = surface.substring(surface.indexOf(" "));
                resultTxt.setStyle("-fx-text-fill: black;");
                resultTxt.setText(surface + " Adlı Kullanıcı Silindi");
                refreshSelectSurface();
            } catch (SQLException ex) {
                Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        });
        
    }    
    
    public void addSurface(){
        try {
            result=db.doInBackground("addNewSurface", surface.getText().toString());
        } catch (SQLException ex) {
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(result==false){
            resultTxt.setStyle("-fx-text-fill: red;");
            resultTxt.setText("Hatalı ya da Eksik Bilgi");
        }else{
            resultTxt.setStyle("-fx-text-fill: black;");
            resultTxt.setText("Yüzey Durumu Başarıyla Eklendi");
            refreshSelectSurface();
        }
    }
                
                
    private void refreshSelectSurface() {    
        try {
            db.doInBackground("getSurface");
        } catch (SQLException ex) {
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        SelectSurface.getItems().setAll(Strings.getSurface());
        
    }
}
