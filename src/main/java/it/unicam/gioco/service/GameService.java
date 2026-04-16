package it.unicam.gioco.service;
import it.unicam.gioco.domain.Enemy;
import it.unicam.gioco.domain.GameState;
import it.unicam.gioco.domain.Player;

public class GameService {

    private final GameState gameState;

    public GameService(){

        this.gameState = new GameState();
    }

    public GameState getGameState() {
        return gameState;
    }
    public void startNewGame(){

        gameState.setGameStarted(true);
        gameState.setCurrentSceneName("Scene1");
        gameState.setPlayer(new Player("Hero",100,20,1));
        gameState.setEnemy(new Enemy("Monster","Slime",50,5));
    }
    public void attackEnemy(){
        Player player = gameState.getPlayer();
        Enemy enemy = gameState.getEnemy();

        if(player != null && enemy != null && enemy.isAlive()){
            enemy.receiveDamgage(player.getAttackPoints());
        }
    }
}
