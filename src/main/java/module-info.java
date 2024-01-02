module com.example.hazirproje {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hazirproje to javafx.fxml;
    exports com.example.hazirproje;
}