/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlController;

import com.BIN.Config;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author sait_
 */
public class magneticParticleReportListController extends AnchorPane {

    public magneticParticleReportListController(){
        Config.Loader(this, "/fxmlFiles/magneticParticleReportList.fxml");
        
    }
    
    
    @FXML
    public void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
    }    
    
}
