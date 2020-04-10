/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlController;

import com.database.database;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.security.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author sait_
 */
public class userLoginController implements Initializable {

    @FXML
    private TextField user_name;
    @FXML
    private PasswordField password;
    @FXML
    private Button login_btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        password_hash p = new password_hash();
        database db = new database();
        
        login_btn.setOnMouseClicked(a ->{
            boolean isTrue = false;
            String user_name = (String) this.user_name.getText().toString();
            String hash = "";
            try {
                hash = p.password_hash((String) this.password.getText().toString());
                isTrue = db.doInBackground("login", user_name, hash);
            } catch (Exception ex) {
                Logger.getLogger(userLoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(isTrue==true){
                System.out.println("doğru");
            }

            });
        
    }    

    
}
