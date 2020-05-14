package fxmlController;

import com.BIN.Config;
import com.BIN.User;
import com.database.database;
import com.security.password_hash;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ProfilController extends AnchorPane{

    @FXML
    private TextField username;
    
    @FXML
    private TextField name;
    
    @FXML
    private TextField surname;
    
    @FXML
    private Button save;
    
    @FXML
    private Label resultTxt;
    
    @FXML
    private PasswordField old_pass;

    @FXML
    private PasswordField pass1;
    
    @FXML
    private PasswordField pass2;

    database db = new database();
    boolean result;
    password_hash p = new password_hash();
    
    public ProfilController(){
        Config.Loader(this, "/fxmlFiles/profil.fxml");
        
        try {
            db.doInBackground("finduser2");
        } catch (SQLException ex) {
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        username.setText(User.getUsername());
        name.setText(User.getDb_name());
        surname.setText(User.getDb_surname());
    }
    
    @FXML
    public void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
        
        save.setOnAction(a ->{            
            try {
                if(old_pass.getText().trim().isEmpty()==true){
                    resultTxt.setStyle("-fx-text-fill: red;");
                    resultTxt.setText("Değişiklik Yapabilmek İçin Şifrenizi Giriniz");
                }else{
                    if(db.doInBackground("login",User.getUsername() , p.password_hash((String) old_pass.getText().toString()))==true){
                        if(pass1.getText().trim().isEmpty()==false){
                            if(pass1.getText().toString().equals(pass2.getText().toString())){
                                if(db.doInBackground("login",User.getUsername() , p.password_hash((String) pass1.getText().toString()))==true){
                                    resultTxt.setStyle("-fx-text-fill: red;");
                                    resultTxt.setText("Girdiğiniz Şifre Öncekiyle Aynı");
                                    old_pass.clear();
                                    pass1.clear();
                                    pass2.clear();
                                }else{
                                
                                    try {
                                        result=db.doInBackground("updateUser","pro",username.getText().toString(),
                                                name.getText().toString(),surname.getText().toString(),
                                                p.password_hash((String) pass1.getText().toString()));
                                        if(result==false){
                                            resultTxt.setStyle("-fx-text-fill: red;");
                                            resultTxt.setText("Hatalı ya da Eksik Bilgi");
                                        }else{
                                            resultTxt.setStyle("-fx-text-fill: black;");
                                            resultTxt.setText("Kullanıcı Bilgileri Başarıyla Güncellendi");
                                        }
                                    } catch (SQLException ex) {
                                        Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (ClassNotFoundException ex) {
                                        Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
                                    }catch (Exception ex) {
                                        Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }else{
                                resultTxt.setStyle("-fx-text-fill: red;");
                                resultTxt.setText("Yeni Şifreler Uyuşmuyor");
                                old_pass.clear();
                                pass1.clear();
                                pass2.clear();
                            }
                        }else{
                            try {
                                result=db.doInBackground("updateUser","pro2",username.getText().toString(),
                                        name.getText().toString(),surname.getText().toString());
                                if(result==false){
                                    resultTxt.setStyle("-fx-text-fill: red;");
                                    resultTxt.setText("Hatalı ya da Eksik Bilgi");
                                }else{
                                    resultTxt.setStyle("-fx-text-fill: black;");
                                    resultTxt.setText("Kullanıcı Bilgileri Başarıyla Güncellendi");
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
                            }catch (Exception ex) {
                                Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }else{
                        resultTxt.setStyle("-fx-text-fill: red;");
                        resultTxt.setText("Yanlış Şifre");
                        old_pass.clear();
                        pass1.clear();
                        pass2.clear();
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(ProfilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }     
    
}
