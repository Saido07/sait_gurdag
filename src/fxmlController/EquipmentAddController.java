package fxmlController;

import com.BIN.Config;
import com.BIN.Equi;
import com.BIN.Equi;
import com.database.database;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class EquipmentAddController extends AnchorPane {

    @FXML
    private ComboBox<String> SelectEqui;
    @FXML
    private TextField equiName;
    @FXML
    private TextField poleDistance;
    @FXML
    private TextField magTech;
    @FXML
    private TextField uvLightInte;
    @FXML
    private TextField distanceOfLight;
    @FXML
    private TextField mpTasiyici;
    @FXML
    private Button save;
    @FXML
    private Button equiDelete;
    @FXML
    private Label resultTxt;
    @FXML
    private TextField addMP;
    @FXML
    private ImageView add;

    database db = new database();

    boolean result;
    
    public EquipmentAddController(){
        Config.Loader(this, "/fxmlFiles/equipmentAdd.fxml");
        
        try {
            db.doInBackground("getEqui");
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentAddController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EquipmentAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        SelectEqui.getItems().setAll(Equi.getEqui()); 
       
    }
    
    @FXML
    public void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
        
        SelectEqui.setOnAction(a ->{                          //combobox fonk.
            if(SelectEqui.isShowing()==true){
                Equi.setDb_equiId(SelectEqui.getValue().toString().
                        substring(0, SelectEqui.getValue().toString().indexOf(" "))); // seçilen cihazın id'sini alıyor.
            }
        
        if(Equi.getDb_equiId().equals("Yeni")){
                equiName.clear();
                poleDistance.clear();
                magTech.clear();
                uvLightInte.clear();
                distanceOfLight.clear();
                mpTasiyici.clear();
        }else{
            try {
                db.doInBackground("findEqui", Equi.getDb_equiId());
            } catch (SQLException ex) {
                Logger.getLogger(EquipmentAddController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EquipmentAddController.class.getName()).log(Level.SEVERE, null, ex);
            }

            equiName.setText(Equi.getDb_equi_name());
            poleDistance.setText(Equi.getDb_poleDistance());
            magTech.setText(Equi.getDb_magTech());
            uvLightInte.setText(Equi.getDb_uvLightInte());
            distanceOfLight.setText(Equi.getDb_distanceOfLight());
            mpTasiyici.setText(Equi.getDb_mpTasiyici());
            }
        });
        
        save.setOnAction(b -> {
            if(Equi.getDb_equiId()==null){
                addEqui();
            }else if(SelectEqui.getValue().toString().equals("Yeni Ekipman")){                
                addEqui();
            }else{
                if(Equi.getDb_equiId()!=null){
                    try {
                        result=db.doInBackground("updateEqui", equiName.getText().toString() , poleDistance.getText().toString(),
                    magTech.getText().toString(), uvLightInte.getText().toString(), distanceOfLight.getText().toString(), mpTasiyici.getText().toString());
                        if(result==false){
                            resultTxt.setStyle("-fx-text-fill: red;");
                            resultTxt.setText("Hatalı ya da Eksik Bilgi");
                        }else{
                            resultTxt.setStyle("-fx-text-fill: black;");
                            resultTxt.setText("Ekipman Bilgileri Başarıyla Güncellendi");
                            refreshSelectEqui();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(EquipmentAddController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(EquipmentAddController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
            
        });
        
        equiDelete.setOnAction(n ->{                         //silme tuşu fonk.
            if(Equi.getDb_equiId().equals("Yeni")){
                resultTxt.setStyle("-fx-text-fill: red;");
                resultTxt.setText("Hatalı İşlem");
            }else{
                try {
                    db.doInBackground("equiDelete", Equi.getDb_equiId());
                    String equi = SelectEqui.getValue().toString().substring(SelectEqui.getValue().toString().indexOf("|"));
                    equi = equi.substring(equi.indexOf(" "));
                    resultTxt.setStyle("-fx-text-fill: black;");
                    resultTxt.setText(equi + " Adlı Ekipman Silindi");
                    refreshSelectEqui();
                } catch (SQLException ex) {
                    Logger.getLogger(EquipmentAddController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(EquipmentAddController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
        
            
        
    }   
    
    public void addEqui(){
        try {
            result=db.doInBackground("addNewEqui", equiName.getText().toString() , poleDistance.getText().toString(),
                    magTech.getText().toString(), uvLightInte.getText().toString(), distanceOfLight.getText().toString(), mpTasiyici.getText().toString());
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentAddController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EquipmentAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(result==false){
            resultTxt.setStyle("-fx-text-fill: red;");
            resultTxt.setText("Hatalı ya da Eksik Bilgi");
        }else{
            resultTxt.setStyle("-fx-text-fill: black;");
            resultTxt.setText("Ekipman Başarıyla Eklendi");
            refreshSelectEqui();
        }
    }

    private void refreshSelectEqui() {    
        try {
            db.doInBackground("getEqui");
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentAddController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EquipmentAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        SelectEqui.getItems().setAll(Equi.getEqui());
        
    }
    
}
