module a.learning {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    requires org.apache.commons.codec;

    opens a.learning to javafx.fxml;
    exports a.learning;
}
