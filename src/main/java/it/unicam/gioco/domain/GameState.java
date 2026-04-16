package it.unicam.gioco.domain;

public class GameState {

    private boolean gameStarted;
    private String currentSceneName;
    private Player player;
    private Enemy enemy;

    public GameState(){

        this.gameStarted = false;
        this.currentSceneName = "Main";
        this.player = null;
        this.enemy = null;
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

    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player){
        this.player = player;
    }
    public Enemy getEnemy(){
        return enemy;
    }
    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
}