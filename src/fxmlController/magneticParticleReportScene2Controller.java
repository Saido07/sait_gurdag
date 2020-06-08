package fxmlController;

import com.BIN.Config;
import com.BIN.Equi;
import com.BIN.Strings;
import com.database.database;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class magneticParticleReportScene2Controller extends AnchorPane {

    database db = new database();

    boolean result;
    
    @FXML
    private TextField kutupMesafe;
    @FXML
    private ComboBox<String> cihaz;
    @FXML
    private TextField mpTasiOrt;
    @FXML
    private TextField miklatisTek;
    @FXML
    private TextField uvIsikSid;
    @FXML
    private TextField IsikMesa;
    @FXML
    private TextField muaBol;
    @FXML
    private ComboBox<String> akimTip;
    @FXML
    private TextField luxIsikSid;
    @FXML
    private TextField muaOrt;
    @FXML
    private TextField mikGider;
    @FXML
    private TextField isilIslem;
    @FXML
    private TextField YuzeySicak;
    @FXML
    private TextField MuaBolAlanSid;
    @FXML
    private TextField yuzey;
    @FXML
    private TextField isikCihazTanim;
    @FXML
    private TextField KaldirmaTestTarihNo;
    @FXML
    private Button next2;

    public ComboBox<String> getAkimTip() {
        return akimTip;
    }

    public ComboBox<String> getCihaz() {
        return cihaz;
    }

    public TextField getIsikMesa() {
        return IsikMesa;
    }

    public TextField getKutupMesafe() {
        return kutupMesafe;
    }

    public TextField getIsilIslem() {
        return isilIslem;
    }

    public TextField getMuaBol() {
        return muaBol;
    }

    public TextField getMpTasiOrt() {
        return mpTasiOrt;
    }

    public TextField getYuzeySicak() {
        return YuzeySicak;
    }

    public TextField getYuzey() {
        return yuzey;
    }

    public TextField getUvIsikSid() {
        return uvIsikSid;
    }

    public TextField getMuaOrt() {
        return muaOrt;
    }

    public TextField getIsikCihazTanim() {
        return isikCihazTanim;
    }

    public TextField getKaldirmaTestTarihNo() {
        return KaldirmaTestTarihNo;
    }

    public TextField getMiklatisTek() {
        return miklatisTek;
    }

    public TextField getMuaBolAlanSid() {
        return MuaBolAlanSid;
    }

    public TextField getMikGider() {
        return mikGider;
    }

    public TextField getLuxIsikSid() {
        return luxIsikSid;
    }

    public Button getNext2() {
        return next2;
    }

    public magneticParticleReportScene2Controller(){
        Config.Loader(this, "/fxmlFiles/magneticParticleReportScene2.fxml");
        
        Strings.setList(2);
        
        try {
            db.doInBackground("getEqui2");
        } catch (SQLException ex) {
            Logger.getLogger(magneticParticleReportScene2Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(magneticParticleReportScene2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        cihaz.getItems().setAll(Equi.getEqui()); 
        muaBol.setText("KAYNAK+HAZ");
        ObservableList<String> v =FXCollections.observableArrayList (" AC" , " DC");
        akimTip.getItems().setAll(v);
        luxIsikSid.setText("1200 Lux");
        MuaBolAlanSid.setText("3.2 kA/m");
        yuzey.setText("TAŞLANMIŞ / GRINDING");
        isikCihazTanim.setText("***");
    }
    
    
    @FXML
    public void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
        
        cihaz.setOnAction(a ->{                          //combobox fonk.
            if(cihaz.isShowing()==true){
                Equi.setDb_equiId(cihaz.getValue().toString().
                        substring(0, cihaz.getValue().toString().indexOf(" "))); // seçilen müşterinin id'sini alıyor.
            }
            
            try {
                db.doInBackground("findEqui", Equi.getDb_equiId());
            } catch (SQLException ex) {
                Logger.getLogger(EquipmentAddController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EquipmentAddController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            kutupMesafe.setText(Equi.getDb_poleDistance());
            mpTasiOrt.setText(Equi.getDb_mpTasiyici());
            miklatisTek.setText(Equi.getDb_magTech());
            uvIsikSid.setText(Equi.getDb_uvLightInte());
            IsikMesa.setText(Equi.getDb_distanceOfLight());
            
            
        });
        
    } 
    
}
