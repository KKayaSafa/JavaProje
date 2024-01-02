package com.example.hazirproje;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.collections.ObservableList;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


public class GecilenDersIslemleriController implements Initializable {

    // Butonlar
    @FXML
    private Button btnGeri;
    @FXML
    private Button btnDersSil;

    // TextField
    @FXML
    private TextField txtDersAdi;
    @FXML
    private TextField txtDersIcerigi;
    @FXML
    private TextField txtDersKodu;
    @FXML
    private TextField txtDersKredisi;
    @FXML
    private TextField txtDonem;
    @FXML
    private TextField txtVize;
    @FXML
    private TextField txtFinal;
    @FXML
    private Button btnDersEkle;

    // Listview
    @FXML
    private ListView<String> lstViewDersAdları;
    @FXML
    private ListView<String> lstViewDersKodları;
    @FXML
    private ListView<String> lstViewDersKredileri;
    @FXML
    private ListView<String> lstViewDersIcerikleri;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateListView();
    }


    public void updateListView() {
        Ogrenci ogrenci = Ogrenci.getInstance();


        ObservableList<String> dersIsimleri = FXCollections.observableArrayList();
        ObservableList<String> dersKodlari = FXCollections.observableArrayList();
        ObservableList<String> dersKredileri = FXCollections.observableArrayList();
        ObservableList<String> dersIcerikleri = FXCollections.observableArrayList();


        for (GecilmisDers g : ogrenci.getDersListesi().getGecilmisDersler()) {
            dersIsimleri.add(g.getDersAdi());
            dersKodlari.add(g.getDersKodu());
            dersKredileri.add(String.valueOf(g.getDersKredisi()));
            dersIcerikleri.add(g.getDersIcerigi());

        }
        lstViewDersAdları.setItems(dersIsimleri);
        lstViewDersKodları.setItems(dersKodlari);
        lstViewDersKredileri.setItems(dersKredileri);
        lstViewDersIcerikleri.setItems(dersIcerikleri);
    }


    @FXML
    private void dersEkle(ActionEvent event) {
        try {
            // TextBox'lardan değerleri al
            String dersAdi = txtDersAdi.getText();
            String dersIcerigi = txtDersIcerigi.getText();
            String dersKodu = txtDersKodu.getText();
            String dersKredisiText = txtDersKredisi.getText();
            String donemText = txtDonem.getText();
            String vizeText = txtVize.getText();
            String finallText = txtFinal.getText();

            // Boş alan kontrolü
            if (dersAdi.isEmpty() || dersIcerigi.isEmpty() || dersKodu.isEmpty() || dersKredisiText.isEmpty()
                    || donemText.isEmpty() || vizeText.isEmpty() || finallText.isEmpty()) {
                // Eğer herhangi bir alan boşsa, showAlert metodunu çağır
                throw new IllegalArgumentException("Tüm alanları doldurunuz.");
            }

            // Boş alan yoksa, değerleri parçala ve MevcutDers nesnesini oluştur
            int dersKredisi = Integer.parseInt(dersKredisiText);
            int donemi = Integer.parseInt(donemText);
            int vize = Integer.parseInt(vizeText);
            int finall = Integer.parseInt(finallText);

            GecilmisDers yeniDers = new GecilmisDers(dersAdi, dersIcerigi, dersKodu, dersKredisi, donemi, vize, finall);

            Ogrenci.getInstance().getDersListesi().gecilmisDersEkle(yeniDers);
            //DersListesi.getInstance().gecilmisDersEkle(yeniDers);

            updateListView(); // ListView'ı güncelle

            // Başarıyla eklenmişse bilgi mesajı göster
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Bilgi");
            alert.setHeaderText(null);
            alert.setContentText("Ders başarıyla eklendi.");
            alert.showAndWait();

            // TextField temizleme
            txtDersAdi.clear();
            txtDersIcerigi.clear();
            txtDersKodu.clear();
            txtDersKredisi.clear();
            txtDonem.clear();
            txtVize.clear();
            txtFinal.clear();


        } catch (NumberFormatException e) {
            // Sayısal değerlere dönüştürme hatası
            throw new IllegalArgumentException("Ders kredisi, dönem, vize ve final sayı olmalıdır.");
        } catch (IllegalArgumentException e) {
            // Diğer hatalar
            uyarıGoster("Hata", e.getMessage());
        } catch (Exception e) {
            // Genel hata durumu
            uyarıGoster("Hata", "Bir hata oluştu");
            e.printStackTrace(); // Hatanın detaylarını yazdır, geliştirme aşamasında kullanışlı olabilir
        }
    }


    /*
    @FXML
    private void dersSil(ActionEvent event) {
        try {
            // Seçilen dersi hem ListView'dan hem de DersListesi'nden silme işlemi
            String secilenDersAdi = lstViewDersAdları.getSelectionModel().getSelectedItem();

            if (secilenDersAdi == null) {
                throw new IllegalArgumentException("Lütfen bir ders seçin");
            }

            // Listede seçilen dersi öğrencinin ders listesi içinde bul
            GecilmisDers secilenDers = dersBul(secilenDersAdi);

            if (secilenDers == null) {
                throw new IllegalArgumentException("Seçilen ders bulunamadı");
            }

            Ogrenci.getInstance().getDersListesi().gecilmisDersCikar(secilenDers.getDersAdi());

            updateListView();

            // Başarıyla eklenmişse bilgi mesajı göster
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Bilgi");
            alert.setHeaderText(null);
            alert.setContentText("Ders başarıyla silindi.");
            alert.showAndWait();

        } catch (IllegalArgumentException e) {
            uyarıGoster("Hata!", e.getMessage());
        } catch (Exception e) {
            uyarıGoster("Hata!", "Bir hata oluştu");
            e.printStackTrace(); // Hatanın detaylarını yazdır, geliştirme aşamasında kullanışlı olabilir
        }
    }

     */

    @FXML
    private void dersSil(ActionEvent event) {
        try {
            // Seçilen dersi hem ListView'dan hem de DersListesi'nden silme işlemi
            String secilenDersAdi = lstViewDersAdları.getSelectionModel().getSelectedItem();

            if (secilenDersAdi == null) {
                throw new IllegalArgumentException("Lütfen bir ders seçin");
            }

            // Listede seçilen dersi öğrencinin ders listesi içinde bul
            GecilmisDers secilenDers = dersBul(secilenDersAdi);

            if (secilenDers == null) {
                throw new IllegalArgumentException("Seçilen ders bulunamadı");
            }

            // Silme işlemi için onay al
            boolean silOnay = onayMesajiGoster("Dersi Sil", "Silmek istediğinize emin misiniz?");

            if (silOnay) {
                Ogrenci.getInstance().getDersListesi().gecilmisDersCikar(secilenDers.getDersAdi());

                updateListView();

                // Başarıyla eklenmişse bilgi mesajı göster
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Bilgi");
                alert.setHeaderText(null);
                alert.setContentText("Ders başarıyla silindi.");
                alert.showAndWait();
            }

        } catch (IllegalArgumentException e) {
            uyarıGoster("Hata!", e.getMessage());
        } catch (Exception e) {
            uyarıGoster("Hata!", "Bir hata oluştu");
            e.printStackTrace(); // Hatanın detaylarını yazdır, geliştirme aşamasında kullanışlı olabilir
        }
    }

    // Ekrana onay mesaji fırlatan metot
    private boolean onayMesajiGoster(String baslik, String icerik) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(baslik);
        alert.setHeaderText(null);
        alert.setContentText(icerik);

        ButtonType evetButonu = new ButtonType("Evet", ButtonBar.ButtonData.OK_DONE);
        ButtonType hayirButonu = new ButtonType("Hayır", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(evetButonu, hayirButonu);

        Optional<ButtonType> sonuc = alert.showAndWait();

        return sonuc.isPresent() && sonuc.get() == evetButonu;
    }





    // Listede seçilen dersi öğrencinin ders listesi içinde bulan fonksiyon
    private GecilmisDers dersBul(String dersAdi) {
        for (GecilmisDers g : Ogrenci.getInstance().getDersListesi().getGecilmisDersler()) {
            if (g.getDersAdi().equals(dersAdi)) {
                return g;
            }
        }
        return null;
    }


    // Ekrana uyarı çıkarma metodu
    private void uyarıGoster(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Ana ekrana dönme metodu
    @FXML
    private void geriDon(ActionEvent event) {
        // Bu metot, "Geri" butonuna tıklandığında çağrılacak
        Stage stage = (Stage) btnGeri.getScene().getWindow();
        stage.close(); // Mevcut pencereyi kapat

    }


}
