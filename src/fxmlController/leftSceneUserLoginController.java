/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlController;

import com.BIN.Config;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author sait_
 */
public class leftSceneUserLoginController extends AnchorPane {
    
    @FXML
    private ImageView image;

    @FXML
    private Label text;
    
    @FXML
    private Button home;

    @FXML
    private Button customerAdd;

    @FXML
    private Button testAdd;

    @FXML
    private Button surfaceAdd;

    @FXML
    private Button equipmentAdd;

    @FXML
    private Button back;

    //butonların get fonksiyonları

    public Button getHome() {
        return home;
    }
    
    public Button getBack() {
        return back;
    }

    public Button getEquipmentAdd() {
        return equipmentAdd;
    }

    public Button getSurfaceAdd() {
        return surfaceAdd;
    }

    public Button getTestAdd() {
        return testAdd;
    }

    public Button getCustomerAdd() {
        return customerAdd;
    }

    public Label getText() {
        return text;
    }

    public ImageView getImage() {
        return image;
    }

    public leftSceneUserLoginController(){  
      Config.Loader(this, "/fxmlFiles/leftSceneUserLogin.fxml");
    }
    
    @FXML
    public void initialize() {
       Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
      
    }   
    

}
