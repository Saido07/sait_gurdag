package fxmlController;

import com.BIN.Config;
import com.BIN.Test;
import com.database.database;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class TestAddController extends AnchorPane{

    @FXML
    private ComboBox<?> SelectTest;
    @FXML
    private TextField test;
    @FXML
    private Button save;
    @FXML
    private Button testDelete;
    @FXML
    private Label resultTxt;

    database db = new database();

    boolean result;
    
    public TestAddController(){
        Config.Loader(this, "/fxmlFiles/testAdd.fxml");
        
        try {
            db.doInBackground("getTest");
        } catch (SQLException ex) {
            Logger.getLogger(TestAddController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        SelectTest.getItems().setAll(Test.getTest());
    }
    
    @FXML
    public void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
        SelectTest.setOnAction(a ->{                     //combo box a tıklama fonk.               
            if(SelectTest.isShowing()==true){
                Test.setDb_testId(SelectTest.getValue().toString().
                        substring(0, SelectTest.getValue().toString().indexOf(" "))); // seçilen testin id'sini alıyor.
            } 
            if(Test.getDb_testId().equals("Yeni")){
                test.clear();
            }else{
                try {
                    db.doInBackground("findTest", Test.getDb_testId());
                } catch (SQLException ex) {
                    Logger.getLogger(TestAddController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TestAddController.class.getName()).log(Level.SEVERE, null, ex);
                }

                test.setText(Test.getDb_test_name());
               
            }
        });
        
        save.setOnAction(b -> {                              //kaydetme tuşu fonk.
            if(Test.getDb_testId()==null){
                addTest();
            }else if(SelectTest.getValue().toString().equals("Yeni Test Türü")){                
                addTest();
            }else{
                if(Test.getDb_testId()!=null){
                try {
                    result=db.doInBackground("updateTest", test.getText().toString());
                    if(result==false){
                        resultTxt.setStyle("-fx-text-fill: red;");
                        resultTxt.setText("Hatalı ya da Eksik Bilgi");
                    }else{
                        resultTxt.setStyle("-fx-text-fill: black;");
                        resultTxt.setText("Test Türü Bilgileri Başarıyla Güncellendi");
                        refreshSelectTest();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            }
        });
        
        testDelete.setOnAction(n ->{                         //silme tuşu fonk.
            if(Test.getDb_testId().equals("Yeni")){
                resultTxt.setStyle("-fx-text-fill: red;");
                resultTxt.setText("Hatalı İşlem");
            }else{
                try {
                    db.doInBackground("testDelete", Test.getDb_testId());
                    String t = SelectTest.getValue().toString().substring(SelectTest.getValue().toString().indexOf("|"));
                    t = t.substring(t.indexOf(" "));
                    resultTxt.setStyle("-fx-text-fill: black;");
                    resultTxt.setText(t + " Adlı Test Türü Silindi");
                    test.clear();
                    refreshSelectTest();
                } catch (SQLException ex) {
                    Logger.getLogger(TestAddController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TestAddController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }   
    
    public void addTest(){                                   //yeni ekleme fonk.
        try {
            result=db.doInBackground("addNewTest", test.getText().toString());
        } catch (SQLException ex) {
            Logger.getLogger(TestAddController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(result==false){
            resultTxt.setStyle("-fx-text-fill: red;");
            resultTxt.setText("Hatalı ya da Eksik Bilgi");
        }else{
            resultTxt.setStyle("-fx-text-fill: black;");
            resultTxt.setText("Test Türü Başarıyla Eklendi");
            refreshSelectTest();
        }
    }
    
    private void refreshSelectTest() {                       //yenileme fonk. combo box için
        try {
            db.doInBackground("getTest");
        } catch (SQLException ex) {
            Logger.getLogger(TestAddController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        SelectTest.getItems().setAll(Test.getTest());
        
    }
    
    
    
}
