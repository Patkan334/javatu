module com.example.demo468_1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.demo468_1 to javafx.fxml;
    exports com.example.demo468_1;
}