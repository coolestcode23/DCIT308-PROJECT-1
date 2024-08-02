module org.school.pharmacymanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires kernel;
    requires layout;


    opens org.school.pharmacymanagementsystem to javafx.fxml;
    exports org.school.pharmacymanagementsystem;
}