package fxmlController;

import com.BIN.Config;
import com.BIN.Customer;
import com.BIN.Strings;
import com.BIN.Surface;
import com.BIN.Test;
import com.BIN.User;
import com.database.database;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class magneticParticleReportSceneController extends AnchorPane {
    
    
    database db = new database();
    boolean result;

    @FXML
    private TextField testYeri;
    @FXML
    private ComboBox<String> musteriler;
    @FXML
    private ComboBox<String> projeler;
    @FXML
    private TextField degerStand;
    @FXML
    private TextField muaPro;
    @FXML
    private TextField resimNo;
    @FXML
    private TextField muaKap;
    @FXML
    private TextField sayfaNo;
    @FXML
    private TextField muayeneStandart;
    @FXML
    private Button next;
    @FXML
    private ComboBox<String> yuzeyDurum;
    @FXML
    private ComboBox<String> MuaAsa;
    @FXML
    private TextField raporNo;
    @FXML
    private TextField raporTarih;
    @FXML
    private TextField isEmriNo;
    @FXML
    private TextField teklifNo;

    public ComboBox<String> getYuzeyDurum() {
        return yuzeyDurum;
    }

    public TextField getIsEmriNo() {
        return isEmriNo;
    }

    public TextField getTeklifNo() {
        return teklifNo;
    }

    public TextField getTestYeri() {
        return testYeri;
    }

    public TextField getRaporNo() {
        return raporNo;
    }

    public TextField getRaporTarih() {
        return raporTarih;
    }

    public TextField getResimNo() {
        return resimNo;
    }

    public ComboBox<String> getMuaAsa() {
        return MuaAsa;
    }

    public TextField getMuaKap() {
        return muaKap;
    }

    public TextField getMuaPro() {
        return muaPro;
    }

    public TextField getSayfaNo() {
        return sayfaNo;
    }

    public ComboBox<String> getProjeler() {
        return projeler;
    }

    public TextField getMuayeneStandart() {
        return muayeneStandart;
    }

    public TextField getDegerStand() {
        return degerStand;
    }
    
    
    public Button getNext() {
        return next;
    }

    public ComboBox<String> getMusteriler() {
        return musteriler;
    }

    public magneticParticleReportSceneController(){
        Config.Loader(this, "/fxmlFiles/magneticParticleReportScene.fxml");
        
        Strings.setList(1);
        
        Date today = new Date();
        today.getTime();
        String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(today);
        

        try {
            db.doInBackground("getCustomer2");
            db.doInBackground("getTest2");
            db.doInBackground("getSurface2");
        } catch (SQLException ex) {
            Logger.getLogger(magneticParticleReportSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(magneticParticleReportSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        MuaAsa.getItems().setAll("Untreated");
        yuzeyDurum.getItems().setAll(Surface.getSurface2());
        musteriler.getItems().setAll(Customer.getCustomers2());  
        projeler.getItems().setAll(Test.getTest2());
        muayeneStandart.setText("TS EN ISO 17638");
        degerStand.setText("TS EN ISO 23278 Class B");
        muaPro.setText("P-101-004");
        muaKap.setText("%100");
        resimNo.setText(" - ");
        sayfaNo.setText("1");
        raporTarih.setText(modifiedDate);
        
        
    }
    
    
    @FXML
    public void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);                                                         
              
        musteriler.setOnAction(a ->{  
            if(musteriler.isShowing()==true){
                Customer.setDb_customer2Id(musteriler.getValue().toString().
                        substring(0, musteriler.getValue().toString().indexOf(" "))); // seçilen müşterinin id'sini alıyor.
            }

            if(musteriler.getValue()!=null){
               try {
                db.doInBackground("findCustomer", Customer.getDb_customer2Id());

                } catch (SQLException ex) {
                    Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UserAddController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Strings.setMusName(musteriler.getValue().toString().
                        substring(musteriler.getValue().toString().indexOf("| ")).substring(musteriler.getValue().toString().indexOf(" ")));
                testYeri.setText(Customer.getDb_cus_place());
                isEmriNo.setText(Customer.getDb_cus_job());
                teklifNo.setText(Customer.getDb_cus_offer()); 
            }
        });
        
    }    
    
}
