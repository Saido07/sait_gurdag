package fxmlController;

/////////////////////Sait Gürdağ-160501132

import com.BIN.Config;
import com.BIN.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class leftSceneUserLoginController extends AnchorPane {
    
    @FXML
    private ImageView image;
    
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
    
    @FXML
    private Label username;

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

    public Label getUsername() {
        return username;
    }

    public ImageView getImage() {
        return image;
    }

    public leftSceneUserLoginController(){  
        Config.Loader(this, "/fxmlFiles/leftSceneUserLogin.fxml");
      
        Image imageV = new Image("/images/icons/userOptions.png");
        image.setImage(imageV);
        image.setCache(true);
        
        username.setText(User.getUsername());
    }
    
    @FXML
    public void initialize() {
       Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
    }   
    

}
