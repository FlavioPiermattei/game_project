package it.unicam.gioco.domain;

public abstract class GameCharacter {

    private String name;
    private int healthPoints;
    private int attackPoints;
    private int maxHealthPoints;

    public GameCharacter(String nome, int healthPoints, int attackPoints) {
        this.name = nome;
        this.attackPoints = attackPoints;
        this.healthPoints = healthPoints;
        this.maxHealthPoints = healthPoints;
    }

    public String getName() {
        return name;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getMaxHealthPoints(){
        return maxHealthPoints;
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

    public void receiveDamage(int damage) {
        this.healthPoints -= damage;

        if (this.healthPoints < 0) {
            this.healthPoints = 0;
        }
    }

    public void heal(int amount){
        this.healthPoints += amount;

        if(this.healthPoints > maxHealthPoints){
            this.healthPoints = this.maxHealthPoints;
        }
    }
}
