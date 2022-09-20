module com.exam.allslow {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.exam.allslow to javafx.fxml;
    exports com.exam.allslow;
}