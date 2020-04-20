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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author sait_
 */
public class UserAddController extends AnchorPane {

    @FXML                                          //combobox program çalışırken her yenilemede yanlış çalışıyor.
    private ComboBox<?> SelectUser;
    @FXML
    private TextField userName;
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField signature_e_date;
    @FXML
    private Button save;
    @FXML
    private Button userDelete;
    @FXML
    private TextField level;
    
    database db = new database();
    
    public UserAddController() {
        Config.Loader(this,"/fxmlFiles/userAdd.fxml");

        try {
            db.doInBackground("getusers");
        } catch (SQLException ex) {
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        SelectUser.getItems().addAll(Strings.getUsers());   //tüm kullanıcıları combo boxta listeler
  
    }

    @FXML
    public void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);    
        
        save.setOnAction(a -> {
            try {
                db.doInBackground("setusers", userName.getText().toString() , name.getText().toString(),
                        surname.getText().toString(), level.getText().toString(), signature_e_date.getText().toString());
            } catch (SQLException ex) {
                Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        
    }    
    
}
