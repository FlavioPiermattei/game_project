package it.unicam.gioco.service;

import it.unicam.gioco.domain.BattleResult;
import it.unicam.gioco.domain.Enemy;
import it.unicam.gioco.domain.GameState;
import it.unicam.gioco.domain.Player;
import it.unicam.gioco.domain.enemy.Goblin;
import it.unicam.gioco.domain.enemy.Slime;
import it.unicam.gioco.domain.enemy.Wolf;
import it.unicam.gioco.domain.EnemyFactory;

public class GameService {

    private final GameState gameState;
    private final EnemyFactory enemyFactory;

    private int enemyCounter;
    public GameService() {
        this.enemyFactory = new EnemyFactory();
        this.gameState = new GameState();
        this.enemyCounter = 1;
    }

    public void startNewGame() {
        gameState.setGameStarted(true);
        gameState.setCurrentSceneName("Scene1");
        gameState.setPlayer(new Player("Hero", 1,100,15));
        gameState.setEnemy(new Enemy("Slime", "Monster", 1, 50,5,15));
    }

    public BattleResult attackEnemy() {
        Player player = gameState.getPlayer();
        Enemy enemy = gameState.getEnemy();


        BattleResult battleResult = new BattleResult();

        if (player == null || enemy == null) {
            return battleResult;
        }
        if (!player.isAlive() || !enemy.isAlive()) {
            return battleResult;
        }

        enemy.receiveDamage(player.getAttackPoints());
        battleResult.setPlayerDamageDealt(player.getAttackPoints());

        if (!enemy.isAlive()) {
            battleResult.setEnemyDefeated(true);
            battleResult.setXpGained(enemy.getExperienceReward());

            boolean levelUpHappened = player.gainExperience(enemy.getExperienceReward());
            battleResult.setLvlUp(levelUpHappened);

            return battleResult;
        }

        player.receiveDamage(enemy.getAttackPoints());
        battleResult.setEnemyDamageDealt(enemy.getAttackPoints());

        if (!player.isAlive()) {
            battleResult.setPlayerDefeated(true);

        }

        return battleResult;
    }

    public GameState getGameState() {
        return gameState;
    }

    public BattleResult healPlayer() {

        Player player = getGameState().getPlayer();
        Enemy enemy = getGameState().getEnemy();

        BattleResult battleResult = new BattleResult();

        if (player == null || enemy == null) {
            return battleResult;
        }
        if (!player.isAlive() || !enemy.isAlive()) {
            return battleResult;
        }

        player.heal(15);
        battleResult.setHealUsed(true);

        player.receiveDamage(enemy.getAttackPoints());
        battleResult.setEnemyDamageDealt(enemy.getAttackPoints());

        if (!player.isAlive()) {
            battleResult.setPlayerDefeated(true);
        }
        return battleResult;
    }

    public BattleResult spawnNewEnemy(){
        BattleResult battleResult = new BattleResult();

        enemyCounter++;
        int enemyLevel = enemyCounter;

        gameState.setEnemy(enemyFactory.createEnemy(enemyLevel));

        return battleResult;
    }


}
