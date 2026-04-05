package it.unicam.gioco.controller;

import it.unicam.gioco.service.GameService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MainController {

    private GameService gameService;

    @FXML
    private Label statusLabel;

    @FXML
    private VBox mainContainer;

    @FXML
    private BorderPane rootPane;

    /**
     * Initializes the controller when the FXML view is loaded.
     *
     * This method is automatically called by JavaFX after all UI components
     * are created and linked.
     *
     * Responsibilities:
     * - Creates the GameService (logic layer)
     * - Sets the initial UI state
     * - Prints debug information to verify correct initialization
     */
    public void initialize() {
        this.gameService = new GameService();

        statusLabel.setText("Game not started");

        System.out.println("MainController initialized");
        System.out.println("Game started: " + gameService.getGameState().isGameStarted());
        System.out.println("Current scene: " + gameService.getGameState().getCurrentSceneName());
    }

    /**
     * Handles the "Start Game" button click.
     *
     * This method is triggered by the UI when the user presses the button.
     *
     * Responsibilities:
     * - Updates the game state through the service layer
     * - Updates the UI to reflect the new state
     * - Loads and displays the game screen (new FXML view)
     * - Prints debug information to verify the transition
     */
    @FXML
    public void handleStartGame() {
        gameService.startNewGame();

        statusLabel.setText("Game Started");

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/fxml/game-view.fxml")
            );

            Node gameView = loader.load();
            rootPane.setCenter(gameView);

        }catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Start Game button clicked");
        System.out.println("Game started: " + gameService.getGameState().isGameStarted());
        System.out.println("Current scene: " + gameService.getGameState().getCurrentSceneName());
    }
    }