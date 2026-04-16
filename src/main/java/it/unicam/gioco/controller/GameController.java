package it.unicam.gioco.controller;

import it.unicam.gioco.domain.Enemy;
import it.unicam.gioco.domain.Player;
import it.unicam.gioco.service.GameService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameController {
    private GameService gameService;

    @FXML
    private Label gameStatusLabel;

    @FXML
    private Label sceneNameLabel;

    @FXML
    private Label playerNameLabel;

    @FXML
    private Label playerHealthLabel;

    @FXML
    private Label playerLevelLabel;

    @FXML
    private Label enemyNameLabel;

    @FXML
    private Label enemyHealthLabel;


    public void initialize() {
        System.out.println("Game Controller Initialized");
    }

    public void setGameService(GameService gameService) {
        this.gameService = gameService;
        updateView();
    }
    @FXML
    public void handleAttack(){
        gameService.attackEnemy();
        updateView();
    }
    private void updateView() {
        gameStatusLabel.setText("Game started: " + gameService.getGameState().isGameStarted());
        sceneNameLabel.setText("Current scene: " + gameService.getGameState().getCurrentSceneName());

        Player player = gameService.getGameState().getPlayer();
        Enemy enemy = gameService.getGameState().getEnemy();

        if (player != null) {

            playerNameLabel.setText("Player name: " + player.getName());
            playerHealthLabel.setText("Player Health: " + player.getHealthPoints());
            playerLevelLabel.setText("Player level: " + player.getLevel());
        } else {
            playerNameLabel.setText("Player name: not available");
            playerNameLabel.setText("Player health: not available");
            playerLevelLabel.setText("Player level: not available");
        }

        if(enemy != null){
            enemyNameLabel.setText("Enemy name: " + enemy.getName());
            enemyHealthLabel.setText("Enemy health: " + enemy.getHealthPoints());
        }else{
            enemyNameLabel.setText("Enemy name: not available");
            enemyHealthLabel.setText("Enemy health: not available");
        }

    }
}
