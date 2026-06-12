package it.unicam.cs.mpgc.rpg129853.controller;

import it.unicam.cs.mpgc.rpg129853.service.NavigationService;
import it.unicam.cs.mpgc.rpg129853.service.GameService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class GameController {
    private NavigationService navigationService;
    private GameService gameService;


    @FXML
    private Button battleSceneButton;

    @FXML
    private Button saveGameButton;

    @FXML
    private Label gameStatusLabel;

    public void initialize() {
        System.out.println("GameController initialize");
    }

    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    public void setNavigationService(NavigationService navigationService) {
        this.navigationService = navigationService;
    }

    @FXML
    public void handleBattleScene() {

        Object controller = navigationService.navigateTo("/fxml/battle-view.fxml");
        if (controller instanceof BattleController battleController) {
            battleController.setGameService(gameService);
            battleController.setNavigationService(navigationService);
        }
        gameStatusLabel.setText("Battle started");
    }

    @FXML
    public void handleSaveGame() {
        try {
            gameService.saveGame();
            gameStatusLabel.setText("Game saved");
        } catch (IOException e) {
            gameStatusLabel.setText("Failed to save game");
            e.printStackTrace();
        }
    }

}

