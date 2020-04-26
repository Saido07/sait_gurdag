package fxmlController;

import com.BIN.Config;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class magneticParticleReportSceneController extends AnchorPane {

    @FXML
    private TextField testYeri;
    @FXML
    private ComboBox<?> musteriler;
    @FXML
    private ComboBox<?> projeler;
    @FXML
    private TextField degerStand;
    @FXML
    private TextField muaPro;
    @FXML
    private TextField resimNo;
    @FXML
    private TextField muaKap;
    @FXML
    private TextField sayfaNo;
    @FXML
    private Button next;
    @FXML
    private ComboBox<?> yüzeyDurum;
    @FXML
    private ComboBox<?> MuaAsa;
    @FXML
    private TextField raporNo;
    @FXML
    private TextField raporTarih;
    @FXML
    private ComboBox<?> isEmriNo;
    @FXML
    private ComboBox<?> teklifNo;

    public Button getNext() {
        return next;
    }
    

    public magneticParticleReportSceneController(){
        Config.Loader(this, "/fxmlFiles/magneticParticleReportScene.fxml");
    }
    
    
    @FXML
    public void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
        
    }    
    
}
