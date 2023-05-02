module com.example.fxmyself {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fxmyself to javafx.fxml;
    exports com.example.fxmyself;
}