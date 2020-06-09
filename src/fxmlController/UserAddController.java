package fxmlController;

import com.BIN.Config;
import com.BIN.User;
import com.database.database;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;

public class UserAddController extends AnchorPane {

    @FXML                               
    private ComboBox<String> SelectUser;
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
        
    @FXML
    private Label usernameL;

    @FXML
    private Label nameL;

    @FXML
    private Label surnameL;

    @FXML
    private Label levelL;

    @FXML
    private Label tarihL;
    
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
        SelectUser.getItems().setAll(User.getUsers());    //tüm kullanıcıları combo boxta listeler

                
    }

    @FXML
    public void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0); 
        
        
        SelectUser.setOnAction(a ->{                          //combobox fonk.
            if(SelectUser.isShowing()==true){
                User.setDb_id(SelectUser.getValue().toString().
                        substring(0, SelectUser.getValue().toString().indexOf(" "))); // seçilen kişinin id'sini alıyor.
            } 
            if(User.getDb_id().equals("Yeni")){
                name.clear();
                surname.clear();
                userName.clear();
                level.clear();
                signature_e_date.clear();
            }else{
                try {
                    db.doInBackground("finduser", User.getDb_id());
                } catch (SQLException ex) {
                    Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
                }

                name.setText(User.getDb_name());
                surname.setText(User.getDb_surname());
                userName.setText(User.getDb_username());
                level.setText(User.getDb_level());
                signature_e_date.setText(User.getDb_signature_expiry_date());

            }
        });
        
        
        save.setOnAction(b -> {
            boolean na=false;
            boolean su=false;
            boolean us=false;
            boolean ta=false;
            boolean le=false;
            boolean ta2=false;
            
            if(name.getText().isEmpty()==true){
                nameL.setStyle("-fx-text-fill: red;");
                name.setStyle("-fx-border-color: red");
                na=false;
            }else{
                nameL.setStyle("-fx-text-fill: black;");
                name.setBorder(Border.EMPTY);
                na=true;
            }
            if(userName.getText().isEmpty()==true){
                usernameL.setStyle("-fx-text-fill: red;");
                userName.setStyle("-fx-border-color: red");
                us=false;
            }else{
                usernameL.setStyle("-fx-text-fill: black;");
                userName.setBorder(Border.EMPTY);
                us=true;
            }
            if(surname.getText().isEmpty()==true){
                surnameL.setStyle("-fx-text-fill: red;");
                surname.setStyle("-fx-border-color: red"); 
                su=false;
            }else{
                surnameL.setStyle("-fx-text-fill: black;");
                surname.setBorder(Border.EMPTY);
                su=true;
            }
            if(level.getText().isEmpty()==true){
                levelL.setStyle("-fx-text-fill: red;");
                level.setStyle("-fx-border-color: red"); 
                le=false;
            }else{
                levelL.setStyle("-fx-text-fill: black;");
                level.setBorder(Border.EMPTY);
                le=true;
            }
            if(signature_e_date.getText().isEmpty()==true){
                signature_e_date.setStyle("-fx-border-color: red"); 
                tarihL.setStyle("-fx-text-fill: red;");
                ta=false;
            }else{
                signature_e_date.setBorder(Border.EMPTY);
                tarihL.setStyle("-fx-text-fill: black;");
                ta=true;
            }
            
            Date date = null;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(signature_e_date.getText().toString());
                ta2=true;
                signature_e_date.setBorder(Border.EMPTY);
                tarihL.setStyle("-fx-text-fill: black;");
            } catch (Exception ex) {
                ta2=false;
                signature_e_date.setStyle("-fx-border-color: red"); 
                tarihL.setStyle("-fx-text-fill: red;");
            }
            
            if(na==true && su==true && us==true && le==true && ta==true && ta2==true){
                if(User.getDb_id()==null){
                    addUser();
                }else if(SelectUser.getValue().toString().equals("Yeni Kullanıcı")){                
                    addUser();
                }else{
                    if(User.getDb_id()!=null){
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
            }else{
                resultTxt.setStyle("-fx-text-fill: red;");
                resultTxt.setText("Hatalı ya da Eksik Bilgi");
            }
            
        });
        
        userDelete.setOnAction(n ->{
            if(User.getDb_username().equals("admin")){
                System.out.println("Bu kullanıcı silinemez");
                resultTxt.setStyle("-fx-text-fill: red;");
                resultTxt.setText("Admin Hesabı Silinemez!");
            }else if(User.getDb_id().equals("Yeni")){
                resultTxt.setStyle("-fx-text-fill: red;");
                resultTxt.setText("Hatalı İşlem");
            }else{
                try {
                    db.doInBackground("userDelete", User.getDb_id());
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
        SelectUser.getItems().setAll(User.getUsers());
        
    }
   
    
}
