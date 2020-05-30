package fxmlController;

import com.BIN.Config;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class magneticParticleReportScene3Controller extends AnchorPane {

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private CheckBox c1;

    @FXML
    private CheckBox c2;

    @FXML
    private TextField standart;

    @FXML
    private TextField muaTarih;

    @FXML
    private TextField Aciklama;

    @FXML
    private Button next;

    public Button getNext() {
        return next;
    }

    public TextField getAciklama() {
        return Aciklama;
    }

    public CheckBox getC1() {
        return c1;
    }

    public CheckBox getC2() {
        return c2;
    }

    public TextField getMuaTarih() {
        return muaTarih;
    }

    public TextField getStandart() {
        return standart;
    }
    
    public magneticParticleReportScene3Controller(){
        Date today = new Date();
        today.getTime();
        String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(today);
        
        Config.Loader(this, "/fxmlFiles/magneticParticleReportScene3.fxml");
        
        Image sekil = new Image("/images/sekil1.png");
        Image sekil2 = new Image("/images/sekil2.png");
        image1.setImage(sekil);
        image2.setImage(sekil2);
        image1.setCache(true);
        image2.setCache(true);
        standart.setText("Standarttan sapma yoktur.");
        muaTarih.setText(modifiedDate);
    }
    
    @FXML
    public void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
        c1.setOnAction(e->{
            if(c1.isSelected()){
                c2.setSelected(false);
            }
        });

        c2.setOnAction(e->{
            if(c2.isSelected()){
                c1.setSelected(false);
            }
        });
        
        image1.setOnMouseClicked(e->{
            c1.setSelected(true);
            c2.setSelected(false);
        });
        
        image2.setOnMouseClicked(e->{
            c2.setSelected(true);
            c1.setSelected(false);
        });
        
    }

    
}
    
