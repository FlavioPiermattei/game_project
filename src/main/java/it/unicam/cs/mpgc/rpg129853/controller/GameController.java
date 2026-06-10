package it.unicam.cs.mpgc.rpg129853.controller;

import it.unicam.cs.mpgc.rpg129853.service.NavigationService;
import it.unicam.cs.mpgc.rpg129853.service.GameService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class GameController {
    private NavigationService navigationService;
    private GameService gameService;


    @FXML
    private BorderPane rootPane;

    @FXML
    private Button battleSceneButton;


    @FXML
    private Label gameStatusLabel;

    public void initialize() {

        this.navigationService = new NavigationService();


        navigationService.setRootPane(rootPane);

        System.out.println("GameController initialize");
    }

    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    @FXML
    public void handleBattleScene() {

        Object controller = navigationService.navigateTo("/fxml/battle-view.fxml");
        if (controller instanceof BattleController battleController) {
            battleController.setGameService(gameService);
        }
        gameStatusLabel.setText("Battle started");
    }

}

