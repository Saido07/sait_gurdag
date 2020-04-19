/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlController;

import com.BIN.Config;
import com.BIN.Strings;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;


/**
 * FXML Controller class
 *
 * @author sait_
 */
public class startOptionsController extends AnchorPane {

    @FXML
    private Button man;
    @FXML
    private Button rad;


    public startOptionsController(){
        Config.Loader(this, "/fxmlFiles/startOptions.fxml");
    }
    @FXML
    public void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);

        man.setOnAction(b ->{
            this.getChildren().clear();
            magneticParticleReportSceneController ma = new magneticParticleReportSceneController();
            this.getChildren().add(ma); 
        });
        
        
        
    }   


    
}
