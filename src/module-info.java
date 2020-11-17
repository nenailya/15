module untitled {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    opens sample to javafx.fxml;
    exports sample;
}