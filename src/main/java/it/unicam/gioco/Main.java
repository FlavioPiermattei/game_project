package it.unicam.gioco;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application{

    @Override
    //Stage is the game window,javaFx gives it to you and it needs to be configured
    public void start(Stage stage){
        // It is the surface on which the game is drawn
        Canvas canvas = new Canvas(800, 600);

        // It is the container of graphical elements (contains the canvas)
        Pane root = new Pane();
        root.getChildren().add(canvas);

        //
        Scene scene = new Scene(root,800,600);


          /*
        Creo il contenitore principale della schermata
        Pane root = new Pane();
        Metto il canvas dentro il contenitore
        root.getChildren().add(canvas);
        QUINDI:
        -il Pane contiene il Canvas
        -il Canvas contiene il disegno del gioco
        Creo la scena del gioco usando quel contenitore
        Scene scene = new Scene(root, 800, 600)
         */

        stage.setTitle("Unknown");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
}