
package fxmlController;

import com.BIN.Config;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;



public class magneticParticleReportListController extends AnchorPane {

    @FXML
    private Accordion list;

    @FXML
    private TitledPane title1;

    @FXML
    private ListView<String> pane1;

    @FXML
    private ImageView imaP1;

    @FXML
    private TitledPane title2;

    @FXML
    private ListView<String> pane2;

    @FXML
    private ImageView imaP2;

    @FXML
    private TitledPane title3;

    @FXML
    private ListView<String> pane3;

    @FXML
    private ImageView imaP3;

    @FXML
    private TitledPane title4;

    @FXML
    private ListView<String> pane4;

    @FXML
    private ImageView imaP4;

    @FXML
    private TitledPane title5;

    @FXML
    private ListView<String> pane5;

    @FXML
    private ImageView imaP5;

    @FXML
    private Button home;

    @FXML
    private Button back;

    //butonların get fonksiyonları
    
    public Button getBack() {
        return back;
    }
    
    public Button getHome() {
        return home;
    }
    
    
    
    public magneticParticleReportListController(){
        Config.Loader(this, "/fxmlFiles/magneticParticleReportList.fxml");
        Image imageV = new Image("/images/icons/gCheck.png");
        
        imaP1.setImage(imageV);
        imaP1.setCache(true);

        imaP2.setImage(imageV);
        imaP2.setCache(true);

        imaP3.setImage(imageV);
        imaP3.setCache(true);
        
        imaP4.setImage(imageV);
        imaP4.setCache(true);
        
        imaP5.setImage(imageV);
        imaP5.setCache(true);
        
        ObservableList<String> items1 =FXCollections.observableArrayList (
        "Müşteri", "Proje Adı", "Test Yeri", "Muayene Standardı", "Değerlen. Standardı","Muayene Prosedürü",
        "Muayene Kapsamı","Resim No","Yüzey Durumu","Muayene Aşaması","Sayfa No","Rapor No","Rapor Tarihi",
        "İş Emri No","Teklif No");
        
        ObservableList<String> items2 =FXCollections.observableArrayList (
        "Kutup Mesafesi","Cihaz","MP Taşıyıcı Ortam","Mıknatıslama Tekniği","UV Işık Şiddeti","Işık Mesafesi",
        "Muayene Bölgesi","Akım Tipi","Luxmetre/Işık Şiddeti","Muayene Ortamı","Mıknatıs Giderimi","Isıl İşlem",
        "Yüzey Sıcaklığı","Muayene Bölgesindeki Alan Şiddeti","Yüzey","Işık Cihazı Tanımı","Kaldırma Testi Tarih/No");
        
        pane1.setItems(items1);
        pane2.setItems(items2);
    }
    
    
    @FXML
    public void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0); 
        
    }    
    
}
