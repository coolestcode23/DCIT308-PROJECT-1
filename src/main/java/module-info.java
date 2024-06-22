module org.school.pharmacyui {
    requires java.naming;
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.jshell;
    requires java.sql;
    requires java.persistence;
    requires org.hibernate.orm.core;

    opens org.school.pharmacyui.models to org.hibernate.orm.core;
    opens org.school.pharmacyui to javafx.fxml;
    exports org.school.pharmacyui;
}