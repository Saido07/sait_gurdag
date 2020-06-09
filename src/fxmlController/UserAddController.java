package fxmlController;

import com.BIN.Config;
import com.BIN.Strings;
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
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    
    @FXML
    private TextField search;
    
    @FXML
    private ImageView searchImage;
    
    database db = new database();

    boolean result;
    
    boolean ctrl=false;
    
    public UserAddController() {
        Config.Loader(this,"/fxmlFiles/userAdd.fxml");

        Image image = new Image("/images/icons/search_icon.png");
        searchImage.setImage(image);
        searchImage.setCache(true);
        searchImage.setVisible(false);
        
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
        
        searchImage.setOnMouseClicked(a->{
            if(!search.getText().toString().equals("")){
                Strings.isSearch(true);
                Strings.setSearchedText(search.getText().toString());
                refreshSelectUser();
                SelectUser.setVisible(true);
                search.setVisible(false);
                searchImage.setVisible(false);
                SelectUser.show();
                name.clear();
                surname.clear();
                userName.clear();
                level.clear();
                signature_e_date.clear(); 
            }else{
                Strings.isSearch(false);
                refreshSelectUser();
                SelectUser.setVisible(true);
                search.setVisible(false);
                searchImage.setVisible(false);
                SelectUser.show();
                name.clear();
                surname.clear();
                userName.clear();
                level.clear();
                signature_e_date.clear();
            }
            
        });
        
        
        SelectUser.setOnAction(a ->{                          //combobox fonk.
            
            if(SelectUser.isShowing()){
                emptyLabels();
                if(SelectUser.getValue()!=null){  
                    if(!SelectUser.getValue().toString().equals("Ara")){
                    User.setDb_id(SelectUser.getValue().toString().
                            substring(0, SelectUser.getValue().toString().indexOf(" "))); // seçilen kişinin id'sini alıyor.
                    if(!SelectUser.getValue().toString().substring(0, SelectUser.getValue().toString().indexOf(" ")).equals(User.getDb_id())){
                        System.out.println("ppppppppppppppppppppp");
                        } 
                    }else{
                        ctrl=true;
                        Strings.isSearch(true);
                        User.setDb_id("");
                    }
                }
            } 
            if((User.getDb_id().equals("") || User.getDb_id()==null) && Strings.isSearch()){
                if(SelectUser.getValue().toString().equals("Ara") ){
                    SelectUser.setVisible(false);
                    search.setVisible(true);
                    searchImage.setVisible(true);
                    name.setEditable(false);
                    surname.setEditable(false);
                    userName.setEditable(false);
                    level.setEditable(false);
                    signature_e_date.setEditable(false);
                    name.clear();
                    surname.clear();
                    userName.clear();
                    level.clear();
                    signature_e_date.clear();
                }   
            }else if(User.getDb_id().equals("Yeni")){
                System.out.println("jjjjjjjjjjjjjjjjjj");
                search.setVisible(false);
                searchImage.setVisible(false);
                name.clear();
                surname.clear();
                userName.clear();
                level.clear();
                signature_e_date.clear();
                name.setEditable(true);
                surname.setEditable(true);
                userName.setEditable(true);
                level.setEditable(true);
                signature_e_date.setEditable(true);
                SelectUser.setEditable(false);
                SelectUser.setCursor(Cursor.DEFAULT);
                if(ctrl){
                    refreshSelectUser();
                    System.out.println("66666666");
                    ctrl=false;
                }
                
            }else{
                if(SelectUser.isVisible()==true && !search.isVisible()){
                    System.out.println("zzzzzzzzzzzzzzzzz");
                    search.setVisible(false);
                    searchImage.setVisible(false);
                    name.setEditable(true);
                    surname.setEditable(true);
                    userName.setEditable(true);
                    level.setEditable(true);
                    signature_e_date.setEditable(true);
                    SelectUser.setEditable(false);
                    SelectUser.setCursor(Cursor.DEFAULT);
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
                    if(ctrl){
                        refreshSelectUser();
                        System.out.println("9999999999");
                        ctrl=false;
                    }
                } 
            }
        });
        
        
        save.setOnAction(b -> {
            boolean na=false;
            boolean su=false;
            boolean us=false;
            boolean ta=false;
            boolean le=false;
            
            if(name.getText().isEmpty()==true){
                nameL.setStyle("-fx-text-fill: red;");
                name.setStyle("-fx-border-color: red;");
                na=false;
            }else{
                nameL.setStyle("-fx-text-fill: black;");
                name.setStyle("-fx-border-style: none;");
                na=true;
            }
            if(userName.getText().isEmpty()==true){
                usernameL.setStyle("-fx-text-fill: red;");
                userName.setStyle("-fx-border-color: red;");
                us=false;
            }else{
                usernameL.setStyle("-fx-text-fill: black;");
                userName.setStyle("-fx-border-style: none;");
                us=true;
            }
            if(surname.getText().isEmpty()==true){
                surnameL.setStyle("-fx-text-fill: red;");
                surname.setStyle("-fx-border-color: red;"); 
                su=false;
            }else{
                surnameL.setStyle("-fx-text-fill: black;");
                surname.setStyle("-fx-border-style: none;");
                su=true;
            }
            if(level.getText().isEmpty()==true){
                levelL.setStyle("-fx-text-fill: red;");
                level.setStyle("-fx-border-color: red;"); 
                le=false;
            }else{
                int a;
                try{
                    a = Integer.parseInt(level.getText().toString());
                    levelL.setStyle("-fx-text-fill: black;");
                    level.setStyle("-fx-border-style: none;");
                    le=true;
                }catch(Exception ex){
                    levelL.setStyle("-fx-text-fill: red;");
                    level.setStyle("-fx-border-color: red;"); 
                    System.out.println("buradsaaaa");
                    le=false;
                }
            }
            if(signature_e_date.getText().isEmpty()==true){
                signature_e_date.setStyle("-fx-border-color: red;"); 
                tarihL.setStyle("-fx-text-fill: red;");
                ta=false;
            }else{
                Date date = null;
                try {
                    date = new SimpleDateFormat("yyyy-MM-dd").parse(signature_e_date.getText().toString());
                    signature_e_date.setStyle("-fx-border-style: none;");
                    tarihL.setStyle("-fx-text-fill: black;");
                    ta=true;
                } catch (Exception ex) {
                    signature_e_date.setStyle("-fx-border-color: red;"); 
                    tarihL.setStyle("-fx-text-fill: red;");
                    ta=false;
                }
            }
            
            if(na==true && su==true && us==true && le==true && ta==true){
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
                    name.clear();
                    surname.clear();
                    userName.clear();
                    level.clear();
                    signature_e_date.clear();
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
            System.out.println("buradaaaaaaaaaaaaaaaaaaaaaaaa");
        } catch (SQLException ex) {
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        SelectUser.getItems().setAll(User.getUsers());
        
    }
   
    public void emptyLabels(){
        levelL.setStyle("-fx-text-fill: black;");
        level.setStyle("-fx-border-style: none;");
        nameL.setStyle("-fx-text-fill: black;");
        name.setStyle("-fx-border-style: none;");
        usernameL.setStyle("-fx-text-fill: black;");
        userName.setStyle("-fx-border-style: none;");
        surnameL.setStyle("-fx-text-fill: black;");
        surname.setStyle("-fx-border-style: none;");
        signature_e_date.setStyle("-fx-border-style: none;");
        tarihL.setStyle("-fx-text-fill: black;");
        resultTxt.setStyle("-fx-text-fill: black;");
        resultTxt.setText("");
    }
    
    
}
