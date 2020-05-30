package fxmlController;

import com.BIN.Config;
import com.BIN.Customer;
import com.BIN.Strings;
import com.BIN.User;
import com.database.database;
import com.excel.Excel;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class magneticParticleReportScene5Controller extends AnchorPane {
    
    database db = new database();
    boolean result;
    
    @FXML
    private ComboBox<String> opeName;

    @FXML
    private TextField opLevel;

    @FXML
    private ComboBox<String> degerName;

    @FXML
    private Button savePDF;

    @FXML
    private ComboBox<String> OnayName;

    @FXML
    private TextField opTarih;

    @FXML
    private TextField dLevel;

    @FXML
    private TextField dTarih;

    @FXML
    private TextField oLevel;

    @FXML
    private TextField oTarih;

    @FXML
    private TextField musName;

    @FXML
    private TextField CusTarih;

    @FXML
    private Button saveExcel;

    public TextField getMusName() {
        return musName;
    }

    public TextField getCusTarih() {
        return CusTarih;
    }

    public ComboBox<String> getDegerName() {
        return degerName;
    }

    public ComboBox<String> getOnayName() {
        return OnayName;
    }

    public TextField getoTarih() {
        return oTarih;
    }

    public TextField getoLevel() {
        return oLevel;
    }

    public TextField getdTarih() {
        return dTarih;
    }

    public TextField getdLevel() {
        return dLevel;
    }

    public Button getSavePDF() {
        return savePDF;
    }

    public Button getSaveExcel() {
        return saveExcel;
    }

    public ComboBox<String> getOpeName() {
        return opeName;
    }

    public TextField getOpTarih() {
        return opTarih;
    }

    public TextField getOpLevel() {
        return opLevel;
    }
    
    public magneticParticleReportScene5Controller(){
        Config.Loader(this, "/fxmlFiles/magneticParticleReportScene5.fxml");
        
        Date today = new Date();
        today.getTime();
        String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(today);
    
        try {
            db.doInBackground("getusers2");
        } catch (SQLException ex) {
            Logger.getLogger(magneticParticleReportSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(magneticParticleReportSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        opeName.getItems().setAll(User.getUsers());
        OnayName.getItems().setAll(User.getUsers());
        degerName.getItems().setAll(User.getUsers());
        oTarih.setText(modifiedDate);
        opTarih.setText(modifiedDate);
        dTarih.setText(modifiedDate);
        CusTarih.setText(modifiedDate);
    }
    
    @FXML
    public void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
        opeName.setOnAction(a -> {
            if(opeName.isShowing()==true){
                User.setDb_Ope_id(opeName.getValue().toString().
                        substring(0, opeName.getValue().toString().indexOf(" "))); // seçilen müşterinin id'sini alıyor.
            }

            try {
                db.doInBackground("finduser", User.getDb_Ope_id());

            } catch (SQLException ex) {
                Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
            }
            opLevel.setText(User.getDb_level());
                
        });
        degerName.setOnAction(a -> {
            if(degerName.isShowing()==true){
                User.setDb_Deger_id(degerName.getValue().toString().
                        substring(0, degerName.getValue().toString().indexOf(" "))); // seçilen müşterinin id'sini alıyor.
            }

            try {
                db.doInBackground("finduser", User.getDb_Deger_id());

            } catch (SQLException ex) {
                Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
            }
            dLevel.setText(User.getDb_level());
                
        });
        
        OnayName.setOnAction(a -> {
            if(OnayName.isShowing()==true){
                User.setDb_Onay_id(OnayName.getValue().toString().
                        substring(0, OnayName.getValue().toString().indexOf(" "))); // seçilen müşterinin id'sini alıyor.
            }

            try {
                db.doInBackground("finduser", User.getDb_Onay_id());

            } catch (SQLException ex) {
                Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
            }
            oLevel.setText(User.getDb_level());
                
        });
        
    }
    
}