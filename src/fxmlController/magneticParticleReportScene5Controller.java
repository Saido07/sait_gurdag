package fxmlController;

import com.BIN.Config;
import com.excel.Excel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class magneticParticleReportScene5Controller extends AnchorPane {
    
@FXML
    private ComboBox<String> opeName;

    @FXML
    private TextField opLevel;

    @FXML
    private ComboBox<String> degerName;

    @FXML
    private Button savePDF;

    @FXML
    private ComboBox<String> OnayName;

    @FXML
    private TextField opTarih;

    @FXML
    private TextField dLevel;

    @FXML
    private TextField dTarih;

    @FXML
    private TextField oLevel;

    @FXML
    private TextField oTarih;

    @FXML
    private TextField Customer;

    @FXML
    private TextField CusTarih;

    @FXML
    private Button saveExcel;
    
    public magneticParticleReportScene5Controller(){
        Config.Loader(this, "/fxmlFiles/magneticParticleReportScene5.fxml");
    }
    
    @FXML
    public void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
        
        saveExcel.setOnAction(b->{
            save();
        });
    }
    
    
    public void save(){
        Excel e = new Excel(); 
        try {
            e.doInBackground(2, 3,"ssssssssssssss");
        } catch (IOException ex) {
            Logger.getLogger(magneticParticleReportScene5Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}