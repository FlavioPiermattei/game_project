package it.unicam.cs.mpgc.rpg129853.controller;

import it.unicam.cs.mpgc.rpg129853.service.GameService;
import it.unicam.cs.mpgc.rpg129853.service.NavigationService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class MainController {

    private GameService gameService;
    private NavigationService navigationService;

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
        this.navigationService = new NavigationService();

        navigationService.setRootPane(rootPane);

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
        Object controller = navigationService.navigateTo("/fxml/game-view.fxml");

        if (controller instanceof GameController gameController) {
            gameController.setGameService(gameService);
            gameController.setNavigationService(navigationService);
        }


        System.out.println("Start Game button clicked");
        System.out.println("Game started: " + gameService.getGameState().isGameStarted());
        System.out.println("Current scene: " + gameService.getGameState().getCurrentSceneName());
    }

    /**
     * Handles the "Load Game" button click.
     *
     * Loads the saved game state through the service layer and, if a save
     * file is found, moves to the game screen. Otherwise the status label
     * informs the user that there is nothing to load.
     */
    @FXML
    public void handleLoadGame() {
        try {
            if (!gameService.loadGame()) {
                statusLabel.setText("No saved game found");
                return;
            }
        } catch (IOException e) {
            statusLabel.setText("Failed to load game");
            e.printStackTrace();
            return;
        }

        statusLabel.setText("Game Loaded");
        Object controller = navigationService.navigateTo("/fxml/game-view.fxml");

        if (controller instanceof GameController gameController) {
            gameController.setGameService(gameService);
            gameController.setNavigationService(navigationService);
        }
    }
    }