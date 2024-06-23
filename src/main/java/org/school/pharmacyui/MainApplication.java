package org.school.pharmacyui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.school.pharmacyui.models.Drug;

import java.io.IOException;

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
    }

    public void navigate(Utils.Page page) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Utils.getPageViewName(page)));
        Parent root = loader.load();
        MainController controller = loader.getController();
        controller.setMainApp(this);
        stackPane.getChildren().add(root);
    }

    public void navigate(Utils.Page page, int drugId) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Utils.getPageViewName(page)));
        Parent root = loader.load();
        MainController controller = loader.getController();
        controller.setMainApp(this);
        controller.setDrugId(drugId);
        stackPane.getChildren().add(root);
    }


    public static void main(String[] args) {
        launch();
    }
}