/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlController;

import com.BIN.Config;
import com.BIN.Strings;
import com.database.database;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author sait_
 */
public class EquipmentAddController extends AnchorPane {

    @FXML
    private ComboBox<?> SelectEqui;
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
    private ComboBox<?> mpCarrierMedium;
    @FXML
    private Button save;
    @FXML
    private Button equiDelete;
    @FXML
    private Label resultTxt;

    database db = new database();

    boolean result;
    
    public EquipmentAddController(){
        Config.Loader(this, "/fxmlFiles/equipmentAdd.fxml");
        
        try {
            db.doInBackground("getEqui");
        } catch (SQLException ex) {
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        SelectEqui.getItems().setAll(Strings.getEqui()); 
    }
    
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
        
    }    
    
}
