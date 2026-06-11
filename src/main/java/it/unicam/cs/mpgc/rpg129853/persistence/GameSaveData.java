package it.unicam.cs.mpgc.rpg129853.persistence;

public class GameSaveData {

    private String currentSceneName;
    private boolean victoryAchieved;
    private String playerName;
    private int playerLevel;
    private int playerHealthPoints;
    private int playerMaxHealthPoints;
    private int playerAttackPoints;
    private int playerExperiencePoints;
    private int enemyCounter;

    public String getCurrentSceneName() {
        return currentSceneName;
    }

    public void setCurrentSceneName(String currentSceneName) {
        this.currentSceneName = currentSceneName;
    }

    public boolean isVictoryAchieved() {
        return victoryAchieved;
    }

    public void setVictoryAchieved(boolean victoryAchieved) {
        this.victoryAchieved = victoryAchieved;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public int getPlayerHealthPoints() {
        return playerHealthPoints;
    }

    public void setPlayerHealthPoints(int playerHealthPoints) {
        this.playerHealthPoints = playerHealthPoints;
    }

    public int getPlayerMaxHealthPoints() {
        return playerMaxHealthPoints;
    }

    public void setPlayerMaxHealthPoints(int playerMaxHealthPoints) {
        this.playerMaxHealthPoints = playerMaxHealthPoints;
    }

    public int getPlayerAttackPoints() {
        return playerAttackPoints;
    }

    public void setPlayerAttackPoints(int playerAttackPoints) {
        this.playerAttackPoints = playerAttackPoints;
    }

    public int getPlayerExperiencePoints() {
        return playerExperiencePoints;
    }

    public void setPlayerExperiencePoints(int playerExperiencePoints) {
        this.playerExperiencePoints = playerExperiencePoints;
    }

    public int getEnemyCounter() {
        return enemyCounter;
    }

    public void setEnemyCounter(int enemyCounter) {
        this.enemyCounter = enemyCounter;
    }
}
