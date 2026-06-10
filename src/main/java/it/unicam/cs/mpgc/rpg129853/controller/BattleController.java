package it.unicam.cs.mpgc.rpg129853.controller;

import it.unicam.cs.mpgc.rpg129853.domain.BattleResult;
import it.unicam.cs.mpgc.rpg129853.domain.Enemy;
import it.unicam.cs.mpgc.rpg129853.domain.Player;
import it.unicam.cs.mpgc.rpg129853.service.BattleService;
import it.unicam.cs.mpgc.rpg129853.service.GameService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class BattleController {

    private GameService gameService;
    private BattleService battleService;

    @FXML private Label battleStatusLabel;
    @FXML private Label sceneNameLabel;
    @FXML private Label playerNameLabel;
    @FXML private Label playerHealthLabel;
    @FXML private Label playerLevelLabel;
    @FXML private Label playerXpLabel;
    @FXML private Label enemyNameLabel;
    @FXML private Label enemyLevelLabel;
    @FXML private Label enemyHealthLabel;
    @FXML private Label battleMessageLabel;
    @FXML private ProgressBar playerHealthBar;
    @FXML private ProgressBar enemyHealthBar;
    @FXML private Button attackButton;
    @FXML private Button healButton;
    @FXML private Button nextEnemyButton;

    public void initialize() {
        System.out.println("BattleController initialized");
    }

    public void setGameService(GameService gameService) {
        this.gameService = gameService;
        this.battleService = gameService.getBattleService();
        updateView("Battle ready.");
    }

    @FXML
    public void handleAttack() {
        BattleResult battleResult = battleService.attackEnemy();
        updateView(buildBattleMessage(battleResult));
    }

    @FXML
    public void handleHeal() {
        BattleResult battleResult = battleService.healPlayer();
        updateView(buildBattleMessage(battleResult));
    }

    @FXML
    public void handleNextEnemy() {
        BattleResult battleResult = battleService.spawnNewEnemy();
        updateView(buildBattleMessage(battleResult));
    }

    private String buildBattleMessage(BattleResult battleResult) {
        Player player = gameService.getGameState().getPlayer();
        Enemy enemy = gameService.getGameState().getEnemy();

        String playerName = player != null ? player.getName() : "Player";
        String enemyName = enemy != null ? enemy.getName() : "Enemy";

        if (battleResult.isHealUsed()) {
            if (battleResult.isPlayerDefeated()) {
                return playerName + " healed " + BattleService.HEAL_AMOUNT + " HP. " + enemyName + " dealt "
                        + battleResult.getEnemyDamageDealt() + " damage. Player defeated.";
            }
            if (battleResult.getEnemyDamageDealt() > 0) {
                return playerName + " healed " + BattleService.HEAL_AMOUNT + " HP. " + enemyName + " dealt "
                        + battleResult.getEnemyDamageDealt() + " damage.";
            }
            return playerName + " healed " + BattleService.HEAL_AMOUNT + " HP.";
        }

        if (battleResult.isEnemyDefeated()) {
            String message = playerName + " dealt " + battleResult.getPlayerDamageDealt()
                    + " damage. " + enemyName + " Lv." + enemy.getLevel() + " defeated. "
                    + playerName + " earned " + battleResult.getXpGained() + " XP.";
            if (battleResult.isLvlUp()) {
                message += " Level up!";
            }
            return message;
        }

        if (battleResult.isPlayerDefeated()) {
            return playerName + " dealt " + battleResult.getPlayerDamageDealt()
                    + " damage. " + enemyName + " dealt "
                    + battleResult.getEnemyDamageDealt() + " damage. Player defeated.";
        }

        if (battleResult.getPlayerDamageDealt() > 0 || battleResult.getEnemyDamageDealt() > 0) {
            return playerName + " dealt " + battleResult.getPlayerDamageDealt()
                    + " damage. " + enemyName + " dealt "
                    + battleResult.getEnemyDamageDealt() + " damage.";
        }

        if (battleResult.isEnemyGenerated()) {
            return "A new " + enemyName + " (Lv." + enemy.getLevel() + ") appeared.";
        }

        return "No action performed.";
    }

    public void updateView(String battleMessage) {
        battleStatusLabel.setText("Game started: " + gameService.getGameState().isGameStarted());
        sceneNameLabel.setText("Current scene: " + gameService.getGameState().getCurrentSceneName());

        Player player = gameService.getGameState().getPlayer();
        Enemy enemy = gameService.getGameState().getEnemy();

        if (player != null) {
            playerNameLabel.setText("Player name: " + player.getName());
            playerHealthLabel.setText("Player health: " + player.getHealthPoints() + "/" + player.getMaxHealthPoints());
            playerLevelLabel.setText("Player level: " + player.getLevel());
            playerXpLabel.setText("Player XP = " + player.getExperiencePoints());
            playerHealthBar.setProgress((double) player.getHealthPoints() / player.getMaxHealthPoints());
        } else {
            playerNameLabel.setText("Player name: not available");
            playerHealthLabel.setText("Player health: not available");
            playerLevelLabel.setText("Player level: not available");
            playerXpLabel.setText("Player XP = not available");
            playerHealthBar.setProgress(0);
        }

        if (enemy != null) {
            enemyNameLabel.setText("Enemy name: " + enemy.getName());
            enemyLevelLabel.setText(enemy.getName() + " Lv." + enemy.getLevel());
            enemyHealthLabel.setText("Enemy health: " + enemy.getHealthPoints() + "/" + enemy.getMaxHealthPoints());
            enemyHealthBar.setProgress((double) enemy.getHealthPoints() / enemy.getMaxHealthPoints());
        } else {
            enemyNameLabel.setText("Enemy name: not available");
            enemyLevelLabel.setText("Enemy level: not available");
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