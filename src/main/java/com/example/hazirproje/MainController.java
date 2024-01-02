package com.example.hazirproje;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;


public class MainController {


    @FXML
    private Button cikis;

    // Mevcut ders işlemleri sayfasını çağıran metot, ilgili butona basıldığında çalışır
    @FXML
    private void mevcutDersTiklandi(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MevcutDersIslemleri.fxml"));
            Parent root = loader.load();

            // Yeni sahneyi oluştur
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Mevcut Ders İşlemleri");
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Geçilmiş ders işlemleri sayfasını çağıran metot, ilgili butona basıldığında çalışır
    @FXML
    private void gecilmisDersTiklandi(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("GecilenDersIslemleri.fxml"));
            Parent root = loader.load();

            // Yeni sahneyi oluştur
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Geçilen Ders İşlemleri");
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Öğrenci giriş sayfasını çağıran metot, ilgili butona basıldığında çalışır
    @FXML
    private void ogrenciGirisTiklandi(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OgrenciGiris.fxml"));
            Parent root = loader.load();

            // Yeni sahneyi oluştur
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Öğrenci Giriş");
            stage.setScene(new Scene(root));
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Çıkış metodu
    @FXML
    private void cikis(ActionEvent event) {

        // Boolean onay değeri
        boolean cikOnay = onayMesajiGoster("Çıkış", "Çıkış yapmak istediğinize emin misiniz?");

        if (cikOnay){
            Stage stage = (Stage) cikis.getScene().getWindow();
            stage.close(); // Mevcut pencereyi kapat
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
}