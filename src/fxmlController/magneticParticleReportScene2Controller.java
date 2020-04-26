package fxmlController;

import com.BIN.Config;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class magneticParticleReportScene2Controller extends AnchorPane {

    @FXML
    private TextField kutupMesafe;
    @FXML
    private TextField cihaz;
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
    private ComboBox<?> akimTip;
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

    
    public magneticParticleReportScene2Controller(){
        Config.Loader(this, "/fxmlFiles/magneticParticleReportScene2.fxml");
    }
    
    
    @FXML
    public void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
        
    } 
    
}
