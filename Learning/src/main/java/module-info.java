module a.learning {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens a.learning to javafx.fxml;
    exports a.learning;
}
