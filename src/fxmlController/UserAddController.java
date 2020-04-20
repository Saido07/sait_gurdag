/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlController;

import com.BIN.Config;
import com.BIN.Strings;
import com.database.database;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
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
    @FXML
    private Label resultTxt;
    
    database db = new database();
    boolean result;
    
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
        
        SelectUser.setOnAction(a ->{
            if(SelectUser.getValue().toString().equals("Yeni Kullanıcı")){
                name.clear();
                surname.clear();
                userName.clear();
                level.clear();
                signature_e_date.clear();
            }else{
                Strings.setDb_id(SelectUser.getValue().toString().
                        substring(0, SelectUser.getValue().toString().indexOf(" "))); // seçilen kişinin id'sini alıyor.
                try {
                    db.doInBackground("finduser", Strings.getDb_id());
                } catch (SQLException ex) {
                    Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
                }

                name.setText(Strings.getDb_name());
                surname.setText(Strings.getDb_surname());
                userName.setText(Strings.getDb_username());
                level.setText(Strings.getDb_level());
                signature_e_date.setText(Strings.getDb_signature_expiry_date());
            }
        });
        
        
        save.setOnAction(b -> {
            if(Strings.getDb_id()==null){
                addUser();
            }else if(SelectUser.getValue().toString().equals("Yeni Kullanıcı")){                
                addUser();
            }else{
                if(Strings.getDb_id()!=null){
                try {
                    result=db.doInBackground("updateUser", userName.getText().toString() , name.getText().toString(),
                            surname.getText().toString(), level.getText().toString(), signature_e_date.getText().toString());
                    
                    resultTxt.setText("Kullanıcı Bilgileri Başarıyla Güncellendi");
                } catch (SQLException ex) {
                    Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            }
            
            
        });
        
        userDelete.setOnAction(n ->{
            if(Strings.getDb_id().equals("1")){
                System.out.println("Bu kullanıcı silinemez");
                resultTxt.setText("Admin Hesabı Silinemez!");
            }else{
            try {
                db.doInBackground("userDelete", Strings.getDb_id());
                String users = SelectUser.getValue().toString().substring(SelectUser.getValue().toString().indexOf("|"));
                users = users.substring(users.indexOf(" "));
                resultTxt.setText(users + " Adlı Kullanıcı Silindi");
            } catch (SQLException ex) {
                Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        });
        
    } 
    
    public void addUser(){
        try {
            result=db.doInBackground("addNewUser", userName.getText().toString() , name.getText().toString(),
                    surname.getText().toString(), level.getText().toString(), signature_e_date.getText().toString());
        } catch (SQLException ex) {
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(result==false)
            resultTxt.setText("Hatalı ya da Eksik Bilgi");
        else
            resultTxt.setText("Kullanıcı Başarıyla Eklendi");
    }
    
}
