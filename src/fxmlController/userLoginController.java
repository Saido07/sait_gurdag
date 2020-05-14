package fxmlController;

import com.BIN.User;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class userLoginController implements Initializable {
    
    @FXML
    private TextField user_name;
    @FXML
    private PasswordField password;
    @FXML
    private Button login_btn; 
    @FXML
    private Label ResultTxt;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        password_hash p = new password_hash();
        database db = new database();
        
        login_btn.setOnAction(a ->{
            boolean isTrue = false;
            User.setUsername((String) this.user_name.getText().toString());
            try {
                isTrue = db.doInBackground("login", User.getUsername(), p.password_hash((String) this.password.getText().toString()));
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
                    
            }else{
                ResultTxt.setVisible(true);
                ResultTxt.setStyle("-fx-text-fill: red;");
                ResultTxt.setText("Kullanıcı Adı ya da Şifre Yanlış");
                password.clear();
            }
            

            });
        
    }    

    
}
