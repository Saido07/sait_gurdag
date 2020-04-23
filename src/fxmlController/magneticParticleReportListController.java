
package fxmlController;

import com.BIN.Config;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;



public class magneticParticleReportListController extends AnchorPane {

    @FXML
    private Button back;
    
    @FXML
    private Accordion list;
    
    @FXML
    private Button home;

    //butonların get fonksiyonları
    
    public Button getBack() {
        return back;
    }
    
    public Button getHome() {
        return home;
    }
    
    
    
    public magneticParticleReportListController(){
        Config.Loader(this, "/fxmlFiles/magneticParticleReportList.fxml");
        
    }
    
    
    @FXML
    public void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
    }    
    
}
