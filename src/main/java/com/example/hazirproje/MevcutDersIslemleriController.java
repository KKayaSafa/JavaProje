package com.example.hazirproje;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MevcutDersIslemleriController implements Initializable {

    // Butonlar
    @FXML
    private Button btnGeri;
    @FXML
    private Button btnDersSil;
    @FXML
    private Button btnDersEkle;


    //TextField
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
    private TextField txtOgretimUyesi;

    //Listview
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


        for (MevcutDers m : ogrenci.getDersListesi().getMevcutDersler()) {
            dersIsimleri.add(m.getDersAdi());
            dersKodlari.add(m.getDersKodu());
            dersKredileri.add(String.valueOf(m.getDersKredisi()));
            dersIcerikleri.add(m.getDersIcerigi());

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
            String ogretimUyesi = txtOgretimUyesi.getText();

            // Boş alan kontrolü
            if (dersAdi.isEmpty() || dersIcerigi.isEmpty() || dersKodu.isEmpty() || dersKredisiText.isEmpty()
                    || donemText.isEmpty() || ogretimUyesi.isEmpty()) {
                // Eğer herhangi bir alan boşsa, showAlert metodunu çağır
                throw new IllegalArgumentException("Tüm alanları doldurunuz.");
            }

            // Boş alan yoksa, değerleri dönüştür ve MevcutDers nesnesini oluştur
            int dersKredisi = Integer.parseInt(dersKredisiText);
            int donemi = Integer.parseInt(donemText);

            MevcutDers yeniDers = new MevcutDers(dersAdi, dersIcerigi, dersKodu, dersKredisi, donemi, ogretimUyesi);

            Ogrenci.getInstance().getDersListesi().mevcutDersEkle(yeniDers);

            updateListView(); // ListView'ı güncelle

            // TextField temizleme
            txtDersAdi.clear();
            txtDersIcerigi.clear();
            txtDersKodu.clear();
            txtDersKredisi.clear();
            txtDonem.clear();
            txtOgretimUyesi.clear();

        } catch (NumberFormatException e) {
            // Sayısal değerlere dönüştürme hatası
            throw new IllegalArgumentException("Ders kredisi ve dönem sayısı sayı olmalıdır.");
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
            MevcutDers secilenDers = dersBul(secilenDersAdi);

            if (secilenDers == null) {
                throw new IllegalArgumentException("Seçilen ders bulunamadı");
            }

            Ogrenci.getInstance().getDersListesi().mevcutDersCikar(secilenDers.getDersAdi());

            updateListView();

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
            MevcutDers secilenDers = dersBul(secilenDersAdi);

            if (secilenDers == null) {
                throw new IllegalArgumentException("Seçilen ders bulunamadı");
            }

            // Silme işlemi için onay al
            boolean silOnay = onayMesajiGoster("Dersi Sil", "Silmek istediğinize emin misiniz?");

            if (silOnay) {
                Ogrenci.getInstance().getDersListesi().mevcutDersCikar(secilenDers.getDersAdi());

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
    private MevcutDers dersBul(String dersAdi) {
        for (MevcutDers m : Ogrenci.getInstance().getDersListesi().getMevcutDersler()) {
            if (m.getDersAdi().equals(dersAdi)) {
                return m;
            }
        }
        return null;
    }

    // showAlert metodu
    private void uyarıGoster(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void geriDon(ActionEvent event) {
        // Bu metotu, "Geri" butonuna tıklandığında çağır
        Stage stage = (Stage) btnGeri.getScene().getWindow();
        stage.close(); // Mevcut pencereyi kapat

    }
}


