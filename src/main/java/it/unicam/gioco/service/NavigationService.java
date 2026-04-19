package it.unicam.gioco.service; 

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class NavigationService {

    private BorderPane rootPane;

    public void setRootPane(BorderPane rootPane){
        this.rootPane = rootPane;
    }

    public Object navigateTo(String fxmlPath){
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(fxmlPath)
        );
        Node view = loader.load();
        rootPane.setCenter(view);

        return loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}