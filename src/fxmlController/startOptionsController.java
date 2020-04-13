/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlController;

import com.BIN.Strings;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxmlFiles/startOptions.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(leftSceneAdminLoginController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    @FXML
    public void initialize() {
        
        man.setOnMouseClicked(b ->{
            this.getChildren().clear();
            magneticParticleReportSceneController ma = new magneticParticleReportSceneController();
            this.getChildren().add(ma);   
        });
        
    }    
    
}
