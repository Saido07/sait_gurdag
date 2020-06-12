package fxmlController;

import com.BIN.Config;
import com.BIN.Strings;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class magneticParticleReportScene4Controller extends AnchorPane {
    
    int i=2;

    public int getI() {
        return i;
    }

    @FXML
    private Button newS;

    @FXML
    private TextField sira1;

    @FXML
    private TextField kaynak1;

    @FXML
    private TextField kontrolU1;

    @FXML
    private TextField kaynakY1;

    @FXML
    private TextField kalinlik1;

    @FXML
    private TextField cap1;

    @FXML
    private TextField hata1;

    @FXML
    private TextField hataY1;

    @FXML
    private TextField Sonuc1;

    @FXML
    private TextField sira2;

    @FXML
    private TextField kaynak2;

    @FXML
    private TextField kontrolU2;

    @FXML
    private TextField kaynakY2;

    @FXML
    private TextField kalinlik2;

    @FXML
    private TextField cap2;

    @FXML
    private TextField hata2;

    @FXML
    private TextField hataY2;

    @FXML
    private TextField Sonuc2;

    @FXML
    private TextField sira3;

    @FXML
    private TextField kaynak3;

    @FXML
    private TextField kontrolU3;

    @FXML
    private TextField kaynakY3;

    @FXML
    private TextField kalinlik3;

    @FXML
    private TextField cap3;

    @FXML
    private TextField hata3;

    @FXML
    private TextField hataY3;

    @FXML
    private TextField Sonuc3;

    @FXML
    private TextField sira4;

    @FXML
    private TextField kaynak4;

    @FXML
    private TextField kontrolU4;

    @FXML
    private TextField kaynakY4;

    @FXML
    private TextField kalinlik4;

    @FXML
    private TextField cap4;

    @FXML
    private TextField hata4;

    @FXML
    private TextField hataY4;

    @FXML
    private TextField Sonuc4;

    @FXML
    private TextField sira5;

    @FXML
    private TextField kaynak5;

    @FXML
    private TextField kontrolU5;

    @FXML
    private TextField kaynakY5;

    @FXML
    private TextField kalinlik5;

    @FXML
    private TextField cap5;

    @FXML
    private TextField hata5;

    @FXML
    private TextField hataY5;

    @FXML
    private TextField Sonuc5;

    @FXML
    private Button next;

    public Button getNext() {
        return next;
    }

    public TextField getCap1() {
        return cap1;
    }

    public TextField getCap2() {
        return cap2;
    }

    public TextField getCap3() {
        return cap3;
    }

    public TextField getCap4() {
        return cap4;
    }

    public TextField getCap5() {
        return cap5;
    }

    public TextField getHata1() {
        return hata1;
    }

    public TextField getHata2() {
        return hata2;
    }

    public TextField getHata3() {
        return hata3;
    }

    public TextField getHata4() {
        return hata4;
    }

    public TextField getHata5() {
        return hata5;
    }

    public TextField getHataY1() {
        return hataY1;
    }

    public TextField getHataY2() {
        return hataY2;
    }

    public TextField getHataY3() {
        return hataY3;
    }

    public TextField getHataY4() {
        return hataY4;
    }

    public TextField getHataY5() {
        return hataY5;
    }

    public TextField getKaynak1() {
        return kaynak1;
    }

    public TextField getKaynak2() {
        return kaynak2;
    }

    public TextField getKaynak3() {
        return kaynak3;
    }

    public TextField getKaynak4() {
        return kaynak4;
    }

    public TextField getKaynak5() {
        return kaynak5;
    }

    public TextField getKaynakY1() {
        return kaynakY1;
    }

    public TextField getKaynakY2() {
        return kaynakY2;
    }

    public TextField getKaynakY3() {
        return kaynakY3;
    }

    public TextField getKaynakY4() {
        return kaynakY4;
    }

    public TextField getKaynakY5() {
        return kaynakY5;
    }

    public TextField getKalinlik1() {
        return kalinlik1;
    }

    public TextField getKalinlik2() {
        return kalinlik2;
    }

    public TextField getKalinlik3() {
        return kalinlik3;
    }

    public TextField getKalinlik4() {
        return kalinlik4;
    }

    public TextField getKalinlik5() {
        return kalinlik5;
    }

    public TextField getKontrolU1() {
        return kontrolU1;
    }

    public TextField getKontrolU2() {
        return kontrolU2;
    }

    public TextField getKontrolU3() {
        return kontrolU3;
    }

    public TextField getKontrolU4() {
        return kontrolU4;
    }

    public TextField getKontrolU5() {
        return kontrolU5;
    }

    public TextField getSira1() {
        return sira1;
    }

    public TextField getSira2() {
        return sira2;
    }

    public TextField getSira3() {
        return sira3;
    }

    public TextField getSira4() {
        return sira4;
    }

    public TextField getSira5() {
        return sira5;
    }

    public TextField getSonuc1() {
        return Sonuc1;
    }

    public TextField getSonuc2() {
        return Sonuc2;
    }

    public TextField getSonuc3() {
        return Sonuc3;
    }

    public TextField getSonuc4() {
        return Sonuc4;
    }

    public TextField getSonuc5() {
        return Sonuc5;
    }
    
    public magneticParticleReportScene4Controller(){
        Config.Loader(this, "/fxmlFiles/magneticParticleReportScene4.fxml");
        
        Strings.setList(4);
        sira1.setText("1");
    }
    
    @FXML
    public void initialize() {
        Config.AnchorPaneConst(this, 0.0, 0.0, 0.0, 0.0);
        newS.setOnAction(a->{
            if(i==2){
                sira2.setVisible(true);
                sira2.setText("2");
                kaynak2.setVisible(true);
                kontrolU2.setVisible(true);
                kaynakY2.setVisible(true);
                kalinlik2.setVisible(true);
                cap2.setVisible(true);
                hata2.setVisible(true);
                hataY2.setVisible(true);
                Sonuc2.setVisible(true);
            }else if(i==3){
                sira3.setVisible(true);
                sira3.setText("3");
                kaynak3.setVisible(true);
                kontrolU3.setVisible(true);
                kaynakY3.setVisible(true);
                kalinlik3.setVisible(true);
                cap3.setVisible(true);
                hata3.setVisible(true);
                hataY3.setVisible(true);
                Sonuc3.setVisible(true);
            }else if(i==4){
                sira4.setVisible(true);
                sira4.setText("4");
                kaynak4.setVisible(true);
                kontrolU4.setVisible(true);
                kaynakY4.setVisible(true);
                kalinlik4.setVisible(true);
                cap4.setVisible(true);
                hata4.setVisible(true);
                hataY4.setVisible(true);
                Sonuc4.setVisible(true);
            }else{
                sira5.setVisible(true);
                sira5.setText("5");
                kaynak5.setVisible(true);
                kontrolU5.setVisible(true);
                kaynakY5.setVisible(true);
                kalinlik5.setVisible(true);
                cap5.setVisible(true);
                hata5.setVisible(true);
                hataY5.setVisible(true);
                Sonuc5.setVisible(true);
            }
            i++;
        });
        
        
    }

}
