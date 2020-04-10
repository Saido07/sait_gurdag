/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inf_202_proje;
/**
 *
 * @author sait_
 */
import com.excel.Excel;
import com.database.*;
import fxmlController.*;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

        
public class Inf_202_Proje extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/fxmlFiles/userLogin.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);

        stage.show();
    }
   
    public static void main(String[] args) throws IOException {
        
        launch(args);

        Excel e = new Excel();
        
        e.main(0, 0,"deneme");
        
        
        //119 doldurulması gereken alan ve 2 tik atılalık alan var.
        
        
        
        
        
        
        
    }

   
 
        
    
}
