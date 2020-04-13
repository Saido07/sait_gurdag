/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlController;

import com.BIN.Strings;
import com.database.database;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.security.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
            Strings.setUsername((String) this.user_name.getText().toString());
            try {
                isTrue = db.doInBackground("login", Strings.getUsername(), p.password_hash((String) this.password.getText().toString()));
            } catch (Exception ex) {
                Logger.getLogger(userLoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(isTrue==true){
                System.out.println("Login successful");
                Stage stage = (Stage) login_btn.getScene().getWindow();;
                stage.close();
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/fxmlFiles/userStartScene.fxml"));
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(userLoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
            }

            });
        
    }    

    
}
