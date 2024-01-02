package com.example.hazirproje;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class OgrenciGirisController {

    // Arayüzde gerekli buton ve textfield'lar
    @FXML
    private Button btnGeri;
    @FXML
    private TextField txtAdiYerli;

    @FXML
    private TextField txtSoyadiYerli;

    @FXML
    private TextField txtNumaraYerli;

    @FXML
    private TextField txtBolumYerli;

    @FXML
    private TextField txtTCYerli;

    @FXML
    private TextField txtAdiYabanci;

    @FXML
    private TextField txtSoyadiYabanci;

    @FXML
    private TextField txtNumaraYabanci;

    @FXML
    private TextField txtBolumYabanci;

    public static final Ogrenci o = new Ogrenci();

    // Öğrenci girişi fonksiyonu
    @FXML
    private void yerliOgrenciGirisi(ActionEvent event) {
        try {
            // Girişleri al
            String adi = txtAdiYerli.getText();
            String soyadi = txtSoyadiYerli.getText();
            String numara = txtNumaraYerli.getText();
            String bolum = txtBolumYerli.getText();
            String tc = txtTCYerli.getText();

            // Gerekli kontrol işlemleri
            if (adi.isEmpty() || soyadi.isEmpty() || numara.isEmpty() || bolum.isEmpty() || tc.isEmpty()) {
                throw new IllegalArgumentException("Lütfen tüm alanları doldurun.");
            }

            if (!adi.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("Ad sadece harf içermelidir.");
            }

            if (!soyadi.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("Soyad sadece harf içermelidir.");
            }

            if (!bolum.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("Bölüm sadece harf içermelidir.");
            }

            if (!tc.matches("\\d+")) {
                throw new IllegalArgumentException("TC kimlik numarası sadece sayı içermelidir.");
            }

            if (!numara.matches("\\d+")) {
                throw new IllegalArgumentException("Öğrenci numarası sadece sayı içermelidir.");
            }

            if (tc.length() != 11) {
                throw new IllegalArgumentException("TC kimlik numarası 11 haneli olmalıdır.");
            }

            if (numara.length() != 9) {
                throw new IllegalArgumentException("Öğrenci numarası 9 haneli olmalıdır.");
            }

            // Yerli öğrenci nesnesini oluştur
            Ogrenci yerliOgrenci = new Ogrenci(adi, soyadi, numara, bolum, tc);


            // Başarıyla eklenmişse bilgi mesajı göster
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Bilgi");
            alert.setHeaderText(null);
            alert.setContentText("Öğrenci başarıyla eklendi.");
            alert.showAndWait();

            // Giriş yapıldıktan sonra TextBox'ları temizle
            txtAdiYerli.clear();
            txtSoyadiYerli.clear();
            txtNumaraYerli.clear();
            txtBolumYerli.clear();
            txtTCYerli.clear();

            // Giriş yaptıktan sonra ana ekrana dön
            Stage stage = (Stage) btnGeri.getScene().getWindow();
            stage.close();

        } catch (IllegalArgumentException e) {
            // Hata durumunda uyarı mesajı göster
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hata");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }



    // Yabancı öğrenci giriş fonksiyonu
    @FXML
    private void yabanciOgrenciGirisi(ActionEvent event) {
        try {
            // Girişleri al
            String adi = txtAdiYabanci.getText();
            String soyadi = txtSoyadiYabanci.getText();
            String numara = txtNumaraYabanci.getText();
            String bolum = txtBolumYabanci.getText();

            // Gerekli kontrol işlemleri
            if (adi.isEmpty() || soyadi.isEmpty() || numara.isEmpty() || bolum.isEmpty()) {
                throw new IllegalArgumentException("Lütfen tüm alanları doldurun.");
            }

            if (!adi.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("Ad sadece harf içermelidir.");
            }

            if (!soyadi.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("Soyad sadece harf içermelidir.");
            }

            if (!bolum.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("Bölüm sadece harf içermelidir.");
            }

            if (!numara.matches("\\d+")) {
                throw new IllegalArgumentException("Öğrenci numarası sadece sayı içermelidir.");
            }

            if (numara.length() != 9) {
                throw new IllegalArgumentException("Öğrenci numarası 9 haneli olmalıdır.");
            }


            // Yabancı öğrenci nesnesini oluştur
            Ogrenci yabanciOgrenci = new Ogrenci(adi, soyadi, numara, bolum);



            // Başarıyla eklenmişse bilgi mesajı göster
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Bilgi");
            alert.setHeaderText(null);
            alert.setContentText("Öğrenci başarıyla eklendi.");
            alert.showAndWait();

            // Giriş yapıldıktan sonra TextBox'ları temizle
            txtAdiYabanci.clear();
            txtSoyadiYabanci.clear();
            txtNumaraYabanci.clear();
            txtBolumYabanci.clear();

            // Giriş yapıldıktan sonra TextBox'ları temizle
            txtAdiYerli.clear();
            txtSoyadiYerli.clear();
            txtNumaraYerli.clear();
            txtBolumYerli.clear();

            // Giriş yaptıktan sonra ana ekrana dön
            Stage stage = (Stage) btnGeri.getScene().getWindow();
            stage.close();

        } catch (IllegalArgumentException e) {
            // Hata durumunda uyarı mesajı göster
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hata");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void anaEkranDon(ActionEvent event) {
        // Bu metotu, "Geri" butonuna tıklandığında çağır
        Stage stage = (Stage) btnGeri.getScene().getWindow();
        stage.close(); // Mevcut pencereyi kapat
    }

}

