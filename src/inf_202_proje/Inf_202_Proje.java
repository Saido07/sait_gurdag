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
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.BasicConfigurator;

        
public class Inf_202_Proje extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/fxmlFiles/userLogin.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
   
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        BasicConfigurator.configure();
        
        database db = new database();
        String type = "firstTimeConnection";
        db.doInBackground(type);
        
        launch(args);


      
    }

   
    
    
 
        
    
}
