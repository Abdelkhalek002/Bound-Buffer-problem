module com.playJava {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.playJava to javafx.fxml;
    exports com.playJava;
}