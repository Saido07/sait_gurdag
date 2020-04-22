
package fxmlController;

import com.BIN.Config;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;



public class magneticParticleReportListController extends AnchorPane {

    @FXML
    private Button back;

    //butonların get fonksiyonları
    
    public Button getBack() {
        return back;
    }
    
    
    
    public magneticParticleReportListController(){
        Config.Loader(this, "/fxmlFiles/magneticParticleReportList.fxml");
        
    }
    
    
    @FXML
    public void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
    }    
    
}
