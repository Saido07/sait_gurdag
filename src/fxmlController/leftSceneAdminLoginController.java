package fxmlController;

import com.BIN.Config;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class leftSceneAdminLoginController extends AnchorPane{
    
    @FXML
    private ImageView image;
   
    @FXML
    private Label text;

    @FXML
    private Button userAdd;
    
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
    
    public Button getUserAdd() {
        return userAdd;
    }

    public Button getCustomerAdd() {
        return customerAdd;
    }

    public Button getTestAdd() {
        return testAdd;
    }

    public Button getSurfaceAdd() {
        return surfaceAdd;
    }

    public Button getEquipmentAdd() {
        return equipmentAdd;
    }

    public ImageView getImage() {
        return image;
    }

    public Label getText() {
        return text;
    }
    
    public leftSceneAdminLoginController(){  
        Config.Loader(this, "/fxmlFiles/leftSceneAdminLogin.fxml");
        
        Image imageV = new Image("/images/icons/userOptions.png");
        image.setImage(imageV);
        image.setCache(true);
    }

   


    
    @FXML
    private void initialize() {
        
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0); 
    }  

    
       
    
}
