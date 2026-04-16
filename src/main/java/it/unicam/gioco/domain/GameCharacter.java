package it.unicam.gioco.domain;

public abstract class GameCharacter {

    private String name;
    private int healthPoints;
    private int attackPoints;

    public GameCharacter(String nome, int healthPoints, int attackPoints) {
        this.name = nome;
        this.attackPoints = attackPoints;
        this.healthPoints = healthPoints;
    }

    public String getName() {
        return name;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public boolean isAlive() {
        return healthPoints > 0;
    }

    public void receiveDamgage(int damage) {
        this.healthPoints -= damage;

        if (this.healthPoints < 0) {
            this.healthPoints = 0;
        }
    }
}
