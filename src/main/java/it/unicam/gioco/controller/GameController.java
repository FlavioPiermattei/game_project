package it.unicam.gioco.controller;

import it.unicam.gioco.domain.Enemy;
import it.unicam.gioco.domain.Player;
import it.unicam.gioco.service.GameService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

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

    @FXML
    private Label battleMessageLabel;

    @FXML
    private Button attackButton;

    @FXML
    private ProgressBar playerHealthBar;

    @FXML
    private ProgressBar enemyHealthBar;

    @FXML
    private Button healButton;

    public void initialize() {
        System.out.println("GameController initialized");
    }

    public void setGameService(GameService gameService) {
        this.gameService = gameService;
        updateView("Battle ready.");
    }

    @FXML
    public void handleAttack() {
        String battleMessage = gameService.attackEnemy();
        updateView(battleMessage);
    }

    @FXML
    public void handleHeal(){
        String battleMessage = gameService.healPlayer();
        updateView(battleMessage);
    }

    private void updateView(String battleMessage) {
        gameStatusLabel.setText("Game started: " + gameService.getGameState().isGameStarted());
        sceneNameLabel.setText("Current scene: " + gameService.getGameState().getCurrentSceneName());

        Player player = gameService.getGameState().getPlayer();
        Enemy enemy = gameService.getGameState().getEnemy();

        if (player != null) {
            playerNameLabel.setText("Player name: " + player.getName());
            playerHealthLabel.setText("Player health: " + player.getHealthPoints());
            playerLevelLabel.setText("Player level: " + player.getLevel());
            playerHealthBar.setProgress((double) player.getHealthPoints() / player.getMaxHealthPoints());
        } else {
            playerNameLabel.setText("Player name: not available");
            playerHealthLabel.setText("Player health: not available");
            playerLevelLabel.setText("Player level: not available");
            playerHealthBar.setProgress(0);
        }

        if (enemy != null) {
            enemyNameLabel.setText("Enemy name: " + enemy.getName());
            enemyHealthLabel.setText("Enemy health: " + enemy.getHealthPoints());
           enemyHealthBar.setProgress((double) enemy.getHealthPoints() / enemy.getMaxHealthPoints());
        } else {
            enemyNameLabel.setText("Enemy name: not available");
            enemyHealthLabel.setText("Enemy health: not available");
            enemyHealthBar.setProgress(0);
        }

        battleMessageLabel.setText(battleMessage);

        if (player == null || !player.isAlive()) {
            attackButton.setDisable(true);
            healButton.setDisable(true);
        } else if (enemy == null || !enemy.isAlive()) {
            attackButton.setDisable(true);
            healButton.setDisable(true);
        } else {
            attackButton.setDisable(false);
            healButton.setDisable(false);
        }
    }
}