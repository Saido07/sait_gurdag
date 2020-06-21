/////////////////////Sait Gürdağ-160501132

package fxmlController;

import com.BIN.Config;
import com.BIN.Strings;
import com.BIN.Surface;
import com.database.database;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SurfaceConAddController extends AnchorPane{

    @FXML
    private ComboBox<String> SelectSurface;
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
    boolean problem=false;
   
    public SurfaceConAddController(){
        Config.Loader(this, "/fxmlFiles/surfaceConAdd.fxml");
        
        try {                                               //database'den yüzey durumu bilg. çekme
            db.doInBackground("getSurface");
        } catch (SQLException ex) {
            Logger.getLogger(SurfaceConAddController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SurfaceConAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        SelectSurface.getItems().setAll(Surface.getSurface());
    }
    
    @FXML
    public void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
        
        SelectSurface.setOnAction(a ->{                     //combo box a tıklama fonk.               
            if(problem){
                resultTxt.setStyle("-fx-text-fill: black;");
                resultTxt.setText("");
                problem=false;
            }
            if(SelectSurface.isShowing()==true){
                Surface.setDb_surId(SelectSurface.getValue().toString().
                        substring(0, SelectSurface.getValue().toString().indexOf(" "))); // seçilen yüzeyin id'sini alıyor.
            } 
            if(Surface.getDb_surId().equals("Yeni")){
                surface.clear();
            }else{
                try {
                    db.doInBackground("findSurface", Surface.getDb_surId());
                } catch (SQLException ex) {
                    Logger.getLogger(SurfaceConAddController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SurfaceConAddController.class.getName()).log(Level.SEVERE, null, ex);
                }

                surface.setText(Surface.getDb_surf_name());
               
            }
        });
        
        save.setOnAction(b -> {                              //kaydetme tuşu fonk.
            if((SelectSurface.getValue()!=null || Surface.getDb_surId()==null)){
                if(Surface.getDb_surId()==null){
                    addSurface();
                }else if(SelectSurface.getValue().toString().equals("Yeni Yüzey Durumu")){                
                    addSurface();
                }else{
                    if(Surface.getDb_surId()!=null){
                    try {
                        result=db.doInBackground("updateSurface", surface.getText().toString());
                        if(result==false){
                            resultTxt.setStyle("-fx-text-fill: red;");
                            resultTxt.setText("Hatalı ya da Eksik Bilgi");
                        }else{
                            resultTxt.setStyle("-fx-text-fill: black;");
                            resultTxt.setText("Yüzey Durumu Bilgileri Başarıyla Güncellendi");
                            refreshSelectSurface();
                            Strings.setOy(true);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(SurfaceConAddController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(SurfaceConAddController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    }
                }
            }else{
                resultTxt.setStyle("-fx-text-fill: red;");
                resultTxt.setText("Lütfen Listeden seçim yaptığınızdan emin olun");
                problem=true;
            } 
        });
        
        surfaceDelete.setOnAction(n ->{                         //silme tuşu fonk.
            if(SelectSurface.getValue()!=null && (!surface.getText().toString().equals("") || Surface.getDb_surId().equals("Yeni"))){
                if(Surface.getDb_surId().equals("Yeni")){
                    resultTxt.setStyle("-fx-text-fill: red;");
                    resultTxt.setText("Hatalı İşlem");
                }else{
                    try {
                        db.doInBackground("surfaceDelete", Surface.getDb_surId());
                        String sur = SelectSurface.getValue().toString().substring(SelectSurface.getValue().toString().indexOf("|"));
                        sur = sur.substring(sur.indexOf(" "));
                        resultTxt.setStyle("-fx-text-fill: black;");
                        resultTxt.setText(sur + " Adlı Yüzüy Durumu Silindi");
                        refreshSelectSurface();
                        Strings.setOy(true);
                        surface.clear();
                    } catch (SQLException ex) {
                        Logger.getLogger(SurfaceConAddController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(SurfaceConAddController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }else{
                resultTxt.setStyle("-fx-text-fill: red;");
                resultTxt.setText("Lütfen Listeden seçim yaptığınızdan emin olun");
                problem=true;
            }
        });
        
    }    
    
    public void addSurface(){                                   //yeni ekleme fonk.
        if(!surface.getText().toString().equals("")){
            try {
                result=db.doInBackground("addNewSurface", surface.getText().toString());
            } catch (SQLException ex) {
                Logger.getLogger(SurfaceConAddController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SurfaceConAddController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(result==false){
                resultTxt.setStyle("-fx-text-fill: red;");
                resultTxt.setText("Hatalı ya da Eksik Bilgi");
            }else{
                resultTxt.setStyle("-fx-text-fill: black;");
                resultTxt.setText("Yüzey Durumu Başarıyla Eklendi");
                refreshSelectSurface();
                Strings.setOy(true);
            }
        }
    }
                
                
    private void refreshSelectSurface() {                       //yenileme fonk. combo box için
        try {
            db.doInBackground("getSurface");
        } catch (SQLException ex) {
            Logger.getLogger(SurfaceConAddController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SurfaceConAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        SelectSurface.getItems().setAll(Surface.getSurface());
        
    }
}
