
package fxmlController;

/////////////////////Sait Gürdağ-160501132


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

    public ImageView getImaP1() {
        return imaP1;
    }

    public ImageView getImaP2() {
        return imaP2;
    }

    public ImageView getImaP3() {
        return imaP3;
    }

    public ImageView getImaP4() {
        return imaP4;
    }

    public ImageView getImaP5() {
        return imaP5;
    }
    
    //butonların get fonksiyonları
    
    public Button getBack() {
        return back;
    }
    
    public Button getHome() {
        return home;
    }

    public TitledPane getTitle1() {
        return title1;
    }

    public TitledPane getTitle2() {
        return title2;
    }

    public TitledPane getTitle3() {
        return title3;
    }

    public TitledPane getTitle4() {
        return title4;
    }

    public TitledPane getTitle5() {
        return title5;
    }

    public Accordion getList() {
        return list;
    }
    
    public magneticParticleReportListController(){
        Config.Loader(this, "/fxmlFiles/magneticParticleReportList.fxml");
        Image imageV = new Image("/images/icons/gCheck.png");
        
        imaP1.setImage(imageV);                 //title'lardeki görseller
        imaP1.setCache(true);

        imaP2.setImage(imageV);
        imaP2.setCache(true);

        imaP3.setImage(imageV);
        imaP3.setCache(true);
        
        imaP4.setImage(imageV);
        imaP4.setCache(true);
        
        imaP5.setImage(imageV);
        imaP5.setCache(true);
        
        ObservableList<String> items1 =FXCollections.observableArrayList (      //genel bilgiler
        "Müşteri", "Proje Adı", "Test Yeri", "Muayene Standardı", "Değerlen. Standardı","Muayene Prosedürü",
        "Muayene Kapsamı","Resim No","Yüzey Durumu","Muayene Aşaması","Sayfa No","Rapor No","Rapor Tarihi",
        "İş Emri No","Teklif No");
        
        ObservableList<String> items2 =FXCollections.observableArrayList (      //cihaz bilgileri
        "Kutup Mesafesi","Cihaz","MP Taşıyıcı Ortam","Mıknatıslama Tekniği","UV Işık Şiddeti","Işık Mesafesi",
        "Muayene Bölgesi","Akım Tipi","Luxmetre/Işık Şiddeti","Muayene Ortamı","Mıknatıs Giderimi","Isıl İşlem",
        "Yüzey Sıcaklığı","Muayene Bölg. Alan Şid.","Yüzey","Işık Cihazı Tanımı","Kaldırma Testi Tarih/No");
        
        ObservableList<String> items3 =FXCollections.observableArrayList (      //muayene bilgileri
        "Kaynak Yeri","Standarttan Sapmalar","Muayene Tarihleri","Açıklamalar ve Ekler");
        
        ObservableList<String> items4 =FXCollections.observableArrayList (      //muayene sonuçları
        "Kaynak Tipi","Kaynak Yeri","Sonuç");
        
        ObservableList<String> items5 =FXCollections.observableArrayList (      //personel bilgileri
        "Operatör","Değerlendiren","Onay","Müşteri");
        
        pane1.setItems(items1);
        pane2.setItems(items2);
        pane3.setItems(items3);
        pane4.setItems(items4);
        pane5.setItems(items5);
    }
    
    
    @FXML
    public void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0); 
        
    }    
    
}
