module com.example.semester1assign1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires xstream;
    opens com.example.semester1assign1.Models to xstream, javafx.fxml;
    opens com.example.semester1assign1 to javafx.fxml;
    exports com.example.semester1assign1;
    exports com.example.semester1assign1.Controllers;
    opens com.example.semester1assign1.Controllers to javafx.fxml;
    exports com.example.semester1assign1.Models;
}