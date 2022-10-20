module com.exam.allslow {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.exam.allslow to javafx.fxml;
    exports com.exam.allslow;
}