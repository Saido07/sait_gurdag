package fxmlController;

import com.BIN.Config;
import com.BIN.Customer;
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
            Logger.getLogger(CustomerAddController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        SelectCustomer.getItems().setAll(Customer.getCustomers());    //tüm müşterileri combo boxta listeler

    }
    
    
    @FXML
    public void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
        SelectCustomer.setOnAction(a ->{                          //combobox fonk.
            if(SelectCustomer.isShowing()==true){
                Customer.setDb_customerId(SelectCustomer.getValue().toString().
                        substring(0, SelectCustomer.getValue().toString().indexOf(" "))); // seçilen müşterinin id'sini alıyor.
            }
        
        if(Customer.getDb_customerId().equals("Yeni")){
                customerName.clear();
                place.clear();
                jobOrderNo.clear();
                offerNo.clear();
        }else{
            try {
                db.doInBackground("findCustomer", Customer.getDb_customerId());
            } catch (SQLException ex) {
                Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
            }

            customerName.setText(Customer.getDb_cus_name());
            place.setText(Customer.getDb_cus_place());
            jobOrderNo.setText(Customer.getDb_cus_job());
            offerNo.setText(Customer.getDb_cus_offer());
            }
        });
        
        
        save.setOnAction(b -> {
            if(Customer.getDb_customerId()==null){
                addCustomer();
            }else if(SelectCustomer.getValue().toString().equals("Yeni Müşteri")){                
                addCustomer();
            }else{
                if(Customer.getDb_customerId()!=null){
                    try {
                        result=db.doInBackground("updateCustomer", customerName.getText().toString() , place.getText().toString(),
                                jobOrderNo.getText().toString(), offerNo.getText().toString());
                        if(result==false){
                            resultTxt.setStyle("-fx-text-fill: red;");
                            resultTxt.setText("Hatalı ya da Eksik Bilgi");
                        }else{
                            resultTxt.setStyle("-fx-text-fill: black;");
                            resultTxt.setText("Müşteri Bilgileri Başarıyla Güncellendi");
                            refreshSelectCustomer();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
            
        });
        
        customerDelete.setOnAction(n ->{                         //silme tuşu fonk.
            if(Customer.getDb_customerId().equals("Yeni")){
                resultTxt.setStyle("-fx-text-fill: red;");
                resultTxt.setText("Hatalı İşlem");
            }else{
                try {
                    db.doInBackground("customerDelete", Customer.getDb_customerId());
                    String customer = SelectCustomer.getValue().toString().substring(SelectCustomer.getValue().toString().indexOf("|"));
                    customer = customer.substring(customer.indexOf(" "));
                    resultTxt.setStyle("-fx-text-fill: black;");
                    resultTxt.setText(customer + " Adlı Müşteri Silindi");
                    refreshSelectCustomer();
                } catch (SQLException ex) {
                    Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
     public void addCustomer(){
        try {
            result=db.doInBackground("addNewCustomer", customerName.getText().toString() , place.getText().toString(),
                    jobOrderNo.getText().toString(), offerNo.getText().toString());
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
            resultTxt.setText("Müşteri Başarıyla Eklendi");
            refreshSelectCustomer();
        }
    }

    private void refreshSelectCustomer() {    
        try {
            db.doInBackground("getCustomer");
        } catch (SQLException ex) {
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
        }
        SelectCustomer.getItems().setAll(Customer.getCustomers());
        
    }
}
