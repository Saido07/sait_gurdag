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
        
public class CustomerAddController extends AnchorPane {
    
    database db = new database();
    boolean result;


    @FXML
    private ComboBox<?> SelectCustomer;
    @FXML
    private TextField customerName;
    @FXML
    private TextField place;
    @FXML
    private TextField jobOrderNo;
    @FXML
    private TextField offerNo;
    @FXML
    private Button save;
    @FXML
    private Button customerDelete;
    @FXML
    private Label resultTxt;
    
    public CustomerAddController(){
        Config.Loader(this, "/fxmlFiles/customerAdd.fxml");
        
        try {
            db.doInBackground("getCustomer");
        } catch (SQLException ex) {
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        SelectCustomer.getItems().setAll(Strings.getCustomers());    //tüm müşterileri combo boxta listeler

    }
    
    
    @FXML
    public void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
        
    }  
}
