package it.unicam.gioco.service;
import it.unicam.gioco.domain.GameState;

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
    }
}
