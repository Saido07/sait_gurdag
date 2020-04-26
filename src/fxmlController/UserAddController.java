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

public class UserAddController extends AnchorPane {

    @FXML                               
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

        try {                                                 //db'den kullanıcı bilg. çekme
            db.doInBackground("getusers");
        } catch (SQLException ex) {
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        SelectUser.getItems().setAll(Strings.getUsers());    //tüm kullanıcıları combo boxta listeler

                
    }

    @FXML
    public void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0); 
        
        
        SelectUser.setOnAction(a ->{                          //combobox fonk.
            if(SelectUser.isShowing()==true){
                Strings.setDb_id(SelectUser.getValue().toString().
                        substring(0, SelectUser.getValue().toString().indexOf(" "))); // seçilen kişinin id'sini alıyor.
            } 
            if(Strings.getDb_id().equals("Yeni")){
                name.clear();
                surname.clear();
                userName.clear();
                level.clear();
                signature_e_date.clear();
            }else{
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
                        if(result==false){
                            resultTxt.setStyle("-fx-text-fill: red;");
                            resultTxt.setText("Hatalı ya da Eksik Bilgi");
                        }else{
                            resultTxt.setStyle("-fx-text-fill: black;");
                            resultTxt.setText("Kullanıcı Bilgileri Başarıyla Güncellendi");
                            refreshSelectUser();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
            
        });
        
        userDelete.setOnAction(n ->{
            if(Strings.getDb_username().equals("admin")){
                System.out.println("Bu kullanıcı silinemez");
                resultTxt.setStyle("-fx-text-fill: red;");
                resultTxt.setText("Admin Hesabı Silinemez!");
            }else if(Strings.getDb_id().equals("Yeni")){
                resultTxt.setStyle("-fx-text-fill: red;");
                resultTxt.setText("Hatalı İşlem");
            }else{
                try {
                    db.doInBackground("userDelete", Strings.getDb_id());
                    String users = SelectUser.getValue().toString().substring(SelectUser.getValue().toString().indexOf("|"));
                    users = users.substring(users.indexOf(" "));
                    resultTxt.setStyle("-fx-text-fill: black;");
                    resultTxt.setText(users + " Adlı Kullanıcı Silindi");
                    refreshSelectUser();
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
        if(result==false){
            resultTxt.setStyle("-fx-text-fill: red;");
            resultTxt.setText("Hatalı ya da Eksik Bilgi");
        }else{
            resultTxt.setStyle("-fx-text-fill: black;");
            resultTxt.setText("Kullanıcı Başarıyla Eklendi");
            refreshSelectUser();
        }
    }

    private void refreshSelectUser() {    
        try {
            db.doInBackground("getusers");
        } catch (SQLException ex) {
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        SelectUser.getItems().setAll(Strings.getUsers());
        
    }

    
}
