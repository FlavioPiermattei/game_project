package it.unicam.gioco.service;

import it.unicam.gioco.domain.BattleResult;
import it.unicam.gioco.domain.Enemy;
import it.unicam.gioco.domain.EnemyFactory;
import it.unicam.gioco.domain.GameState;
import it.unicam.gioco.domain.Player;

public class BattleService {

    public static final int HEAL_AMOUNT = 15;

    private final GameState gameState;
    private final EnemyFactory enemyFactory;
    private int enemyCounter;

    public BattleService(GameState gameState, EnemyFactory enemyFactory) {
        this.gameState = gameState;
        this.enemyFactory = enemyFactory;
        this.enemyCounter = 1;
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

    public BattleResult healPlayer() {
        Player player = gameState.getPlayer();
        Enemy enemy = gameState.getEnemy();

        BattleResult battleResult = new BattleResult();

        if (player == null || enemy == null) {
            return battleResult;
        }
        if (!player.isAlive() || !enemy.isAlive()) {
            return battleResult;
        }

        player.heal(HEAL_AMOUNT);
        battleResult.setHealUsed(true);

        player.receiveDamage(enemy.getAttackPoints());
        battleResult.setEnemyDamageDealt(enemy.getAttackPoints());

        if (!player.isAlive()) {
            battleResult.setPlayerDefeated(true);
        }
        return battleResult;
    }

    public BattleResult spawnNewEnemy() {
        BattleResult battleResult = new BattleResult();
        enemyCounter++;
        gameState.setEnemy(enemyFactory.createEnemy(enemyCounter));
        battleResult.setEnemyGenerated(true);
        return battleResult;
    }
}
