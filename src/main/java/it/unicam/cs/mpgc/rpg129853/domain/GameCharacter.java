package it.unicam.cs.mpgc.rpg129853.domain;

public abstract class GameCharacter {

    private String name;
    private int healthPoints;
    private int attackPoints;
    private int maxHealthPoints;
    protected int level;

    public GameCharacter(String nome,int level, int healthPoints, int attackPoints) {
        this(nome, level, healthPoints, healthPoints, attackPoints);
    }

    protected GameCharacter(String nome, int level, int healthPoints, int maxHealthPoints, int attackPoints) {
        this.name = nome;
        this.attackPoints = attackPoints;
        this.healthPoints = healthPoints;
        this.maxHealthPoints = maxHealthPoints;
        this.level = level;
    }

    public int getLevel() {
        return level;
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

    protected void increaseMaxHealthPoints(int amount){
        this.maxHealthPoints += amount;
    }

    protected void increaseAttackPoints(int amount) {
        this.attackPoints += amount;
    }

    public void increaseLevel(){
        this.level++;
    }
}
