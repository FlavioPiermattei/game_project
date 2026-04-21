package it.unicam.gioco.domain;

public class BattleResult {

    private int playerDamageDealt;
    private int enemyDamageDealt;
    private boolean playerDefeated;
    private boolean enemyDefeated;
    private boolean healUsed;
    private boolean enemyGenerated;
    private int xpGained;
    private boolean lvlUp;

    public BattleResult() {
        this.playerDamageDealt = 0;
        this.enemyDamageDealt = 0;
        this.playerDefeated = false;
        this.enemyDefeated = false;
        this.healUsed = false;
        this.enemyGenerated = false;
        this.xpGained = 0;
        this.lvlUp = false;
    }

    public int getPlayerDamageDealt() {
        return playerDamageDealt;
    }

    public void setPlayerDamageDealt(int playerDamageDealt) {
        this.playerDamageDealt = playerDamageDealt;
    }

    public int getEnemyDamageDealt() {
        return enemyDamageDealt;
    }

    public void setEnemyDamageDealt(int enemyDamageDealt) {
        this.enemyDamageDealt = enemyDamageDealt;
    }

    public boolean isPlayerDefeated() {
        return playerDefeated;
    }

    public void setPlayerDefeated(boolean playerDefeated) {
        this.playerDefeated = playerDefeated;
    }

    public boolean isEnemyDefeated() {
        return enemyDefeated;
    }

    public void setEnemyDefeated(boolean enemyDefeated) {
        this.enemyDefeated = enemyDefeated;
    }

    public boolean isHealUsed() {
        return healUsed;
    }

    public void setHealUsed(boolean healUsed) {
        this.healUsed = healUsed;
    }

    public boolean isEnemyGenerated() {
        return enemyGenerated;
    }

    public void setEnemyGenerated(boolean enemyGenerated) {
        this.enemyGenerated = enemyGenerated;
    }

    public int getXpGained() {
        return xpGained;
    }

    public void setXpGained(int xpGained) {
        this.xpGained = xpGained;
    }

    public boolean isLvlUp() {
        return lvlUp;
    }

    public void setLvlUp(boolean lvlUp) {
        this.lvlUp = lvlUp;
    }
}

