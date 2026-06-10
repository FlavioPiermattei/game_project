package it.unicam.cs.mpgc.rpg129853;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("start method called");
        // Creates an FXMLLoader to load the main JavaFX layout from the FXML file located in the resources/fxml folder.
        // Crea un FXMLLoader per caricare il layout principale di JavaFX dal file FXML situato nella cartella resources/fxml.
        FXMLLoader loader = new FXMLLoader(
                MainApplication.class.getResource("/fxml/main-view.fxml")
        );


        //Loads all the graphical content form the FXML file into a new Scene object
        Scene scene = new Scene(loader.load(),800,600);
        //Set the tile shown at the top of the application window
        stage.setTitle("Unkown");
        //Attaches the created scene to the main window (stage)
        stage.setScene(scene);
        //Prevents the user from resizing the application window
        stage.setResizable(false);
        //Make the window visible on the screen
        stage.show();
    }

    public static void main(String[] args) {
        //Launches the JavaFX runtime, which will then call the start() method.
        launch(args);
    }
}