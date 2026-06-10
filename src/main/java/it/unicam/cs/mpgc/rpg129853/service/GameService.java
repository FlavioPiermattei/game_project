package it.unicam.cs.mpgc.rpg129853.service;

import it.unicam.cs.mpgc.rpg129853.domain.EnemyFactory;
import it.unicam.cs.mpgc.rpg129853.domain.GameState;
import it.unicam.cs.mpgc.rpg129853.domain.Player;

public class GameService {

    private final GameState gameState;
    private final EnemyFactory enemyFactory;
    private final BattleService battleService;

    public GameService() {
        this.gameState = new GameState();
        this.enemyFactory = new EnemyFactory();
        this.battleService = new BattleService(gameState, enemyFactory);
    }

    public void startNewGame() {
        gameState.setGameStarted(true);
        gameState.setCurrentSceneName("Scene1");
        gameState.setPlayer(new Player("Hero", 1,100,15));
        gameState.setEnemy(enemyFactory.createEnemy(1));
    }

    public GameState getGameState() {
        return gameState;
    }

    public BattleService getBattleService() {
        return battleService;
    }

}
