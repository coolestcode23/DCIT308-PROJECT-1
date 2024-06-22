package org.school.pharmacyui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.school.pharmacyui.models.Drug;

import java.io.IOException;
import java.util.List;

public class MainApplication extends Application {
    private StackPane stackPane;

    @Override
    public void start(Stage stage) throws IOException {
        stackPane = new StackPane();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        stackPane.getChildren().add(fxmlLoader.load());
        Scene scene = new Scene(stackPane, 1100, 800);

        MainController mainController = fxmlLoader.getController();
        mainController.setMainApp(this);

        stage.setTitle("Pharmacy App");
        stage.setScene(scene);
        stage.show();

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
//            Drug drug = new Drug(1, "Aspirin", "A common pain reliever and anti-inflammatory drug", 10.00, 100, 200, 500);
//            session.save(drug);
//            transaction.commit();
            List<Drug> drugs = session.createQuery("from Drug", Drug.class).getResultList();
            System.out.println(drugs);

        }
    }

    public void navigate(Utils.Page page) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Utils.getPageViewName(page)));
        Parent root = loader.load();
        MainController controller = loader.getController();
        controller.setMainApp(this);
        stackPane.getChildren().add(root);
    }


    public static void main(String[] args) {
        launch();
    }
}