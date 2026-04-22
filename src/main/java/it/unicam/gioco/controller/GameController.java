package it.unicam.gioco.controller;

import it.unicam.gioco.domain.BattleResult;
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

    @FXML
    private Button nextEnemyButton;

    @FXML
    private Label enemyLevelLabel;

    @FXML
    private Label playerXpLabel;

    public void initialize() {
        System.out.println("GameController initialized");
    }

    public void setGameService(GameService gameService) {
        this.gameService = gameService;
        updateView("Battle ready.");
    }

    @FXML
    public void handleAttack() {
        BattleResult battleResult = gameService.attackEnemy();
        String battleMessage = buildBattleMessage(battleResult);
        updateView(battleMessage);
    }

    @FXML
    public void handleHeal(){
        BattleResult battleResult = gameService.healPlayer();
        String battleMessage = buildBattleMessage(battleResult);
        updateView(battleMessage);
    }
    @FXML
    public void handleNextEnemy(){
        BattleResult battleResult = gameService.spawnNewEnemy();
        String battleMessage = buildBattleMessage(battleResult);
        updateView(battleMessage);

    }


    private String buildBattleMessage(BattleResult battleResult) {
        if (battleResult.isHealUsed()) {
            if (battleResult.isPlayerDefeated()) {
                return "Hero healed 15 HP. Slime dealt " + battleResult.getEnemyDamageDealt() + " damage. Player defeated.";
            }

            if (battleResult.getEnemyDamageDealt() > 0) {
                return "Hero healed 15 HP. Slime dealt " + battleResult.getEnemyDamageDealt() + " damage.";
            }

            return "Hero healed 15 HP.";
        }

        if (battleResult.isEnemyDefeated()) {
            if(battleResult.isLvlUp()){
                return "Hero dealt " + battleResult.getPlayerDamageDealt()
                        + " damage. Enemy Lv" + gameService.getGameState().getEnemy().getLevel() + " defeated. Hero earn "
                        + battleResult.getXpGained() + " XP. Hero Level up!";
            }
            return "Hero dealt " + battleResult.getPlayerDamageDealt()
                    + " damage. Enemy Lv" + gameService.getGameState().getEnemy().getLevel() + " defeated. Hero earn "
                    + battleResult.getXpGained() + " XP.";
        }

        if (battleResult.isPlayerDefeated()) {
            return "Hero dealt " + battleResult.getPlayerDamageDealt() + " damage. "
                    + gameService.getGameState().getEnemy().getName() + " dealt "+ battleResult.getEnemyDamageDealt() + " damage. Player defeated.";
        }

        if (battleResult.getPlayerDamageDealt() > 0 || battleResult.getEnemyDamageDealt() > 0) {
            return "Hero dealt " + battleResult.getPlayerDamageDealt() + " damage. "
                    + gameService.getGameState().getEnemy().getName() + " dealt " + battleResult.getEnemyDamageDealt() + " damage.";
        }
        if(battleResult.isEnemyGenerated()){
            return "A enemy as be generated";
        }

        return "No action performed.";
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
            playerXpLabel.setText("Player XP = " + player.getExperiencePoints());
            playerHealthBar.setProgress((double) player.getHealthPoints() / player.getMaxHealthPoints());
        } else {
            playerNameLabel.setText("Player name: not available");
            playerHealthLabel.setText("Player health: not available");
            playerLevelLabel.setText("Player level: not available");
            playerHealthBar.setProgress(0);
        }

        if (enemy != null) {
            enemyNameLabel.setText("Enemy name: " + enemy.getName());
            enemyLevelLabel.setText(enemy.getName() + " Lvl" + enemy.getLevel());
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
            nextEnemyButton.setDisable(true);

        } else if (enemy == null || !enemy.isAlive()) {
            attackButton.setDisable(true);
            healButton.setDisable(true);
            nextEnemyButton.setDisable(false);
        } else {
            attackButton.setDisable(false);
            healButton.setDisable(false);
            nextEnemyButton.setDisable(true);

        }
    }
}