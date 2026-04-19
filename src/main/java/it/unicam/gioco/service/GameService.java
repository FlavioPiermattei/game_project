package it.unicam.gioco.service;

import it.unicam.gioco.domain.Enemy;
import it.unicam.gioco.domain.GameState;
import it.unicam.gioco.domain.Player;

public class GameService {

    private final GameState gameState;

    public GameService() {
        this.gameState = new GameState();
    }

    public void startNewGame() {
        gameState.setGameStarted(true);
        gameState.setCurrentSceneName("Scene1");
        gameState.setPlayer(new Player("Hero", 100, 20, 1));
        gameState.setEnemy(new Enemy("Monster", "Slime", 50, 5));
    }

    public String attackEnemy() {
        Player player = gameState.getPlayer();
        Enemy enemy = gameState.getEnemy();

        if (player == null) {
            return "Player not available.";
        }

        if (enemy == null) {
            return "No enemy available.";
        }

        if (!player.isAlive()) {
            return "Player defeated.";
        }

        if (!enemy.isAlive()) {
            return "Enemy defeated.";
        }

        enemy.receiveDamage(player.getAttackPoints());

        if (!enemy.isAlive()) {
            return player.getName() + " dealt " + player.getAttackPoints() + " damage. Enemy defeated.";
        }

        player.receiveDamage(enemy.getAttackPoints());

        if (!player.isAlive()) {
            return player.getName() + " dealt " + player.getAttackPoints() + " damage. "
                    + enemy.getName() + " dealt " + enemy.getAttackPoints() + " damage. Player defeated.";
        }

        return player.getName() + " dealt " + player.getAttackPoints() + " damage. "
                + enemy.getName() + " dealt " + enemy.getAttackPoints() + " damage.";
    }

    public GameState getGameState() {
        return gameState;
    }

    public String healPlayer(){

        Player player = getGameState().getPlayer();
        Enemy enemy = getGameState().getEnemy();

        if(player == null){
            return "Player not available";
        }
        if(!player.isAlive()){
            return "Player defeated";
        }
        if(enemy == null || !enemy.isAlive()){
            return "Healing is only available during the battle";
        }

        player.heal(15);
        player.receiveDamage(enemy.getAttackPoints());


        if(!player.isAlive()){
            return player.getName() + " healed 15 Hp. " + enemy.getName() + " dealt " + enemy.getAttackPoints() + " damage.Player defeated";
        }

        return  player.getName()  + " healed 15 Hp. " + enemy.getName() + " dealt " + enemy.getAttackPoints() + " damage";
        }
    }
