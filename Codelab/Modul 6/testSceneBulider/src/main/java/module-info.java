module org.example.testscenebulider {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens org.example.testscenebulider to javafx.fxml;
    exports org.example.testscenebulider;
}