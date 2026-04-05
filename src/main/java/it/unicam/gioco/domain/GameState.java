package it.unicam.gioco.domain;

public class GameState {

    private boolean gameStarted;
    private String currentSceneName;

    public GameState(){

        this.gameStarted = true;
        this.currentSceneName = "Main";
    }

    public boolean isGameStarted(){
        return gameStarted;
    }
    public void setGameStarted(boolean gameStarted){
        this.gameStarted = gameStarted;
    }
    public String getCurrentSceneName(){
        return currentSceneName;
    }
    public void setCurrentSceneName(String currentSceneName){
        this.currentSceneName = currentSceneName;
    }
}