package fxmlController;

import com.BIN.Config;
import com.BIN.Strings;
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
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        SelectTest.getItems().setAll(Strings.getTest());
    }
    
    @FXML
    public void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
        
    }   
    
}
