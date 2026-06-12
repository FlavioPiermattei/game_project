package it.unicam.cs.mpgc.rpg129853.domain;

public class Player extends GameCharacter {

    private int experiencePoints;
    private int experienceToNextLevel;

    public Player(String name,int level,int healthPoints,int attackPoints) {
        super(name,level,healthPoints,attackPoints);
        this.experiencePoints = 0;
        this.experienceToNextLevel = 100;
    }

    public Player(String name, int level, int healthPoints, int maxHealthPoints, int attackPoints, int experiencePoints) {
        super(name, level, healthPoints, maxHealthPoints, attackPoints);
        this.experiencePoints = experiencePoints;
        this.experienceToNextLevel = 100 + (level - 1) * 50;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }


    public boolean gainExperience(int amount){

        boolean  levelUpHappened  = false;

        this.experiencePoints += amount;

        while( this.experiencePoints >= this.experienceToNextLevel) {
            this.experiencePoints -= this.experienceToNextLevel;
            levelUp();
            levelUpHappened = true;
    }
        return  levelUpHappened;
    }

    public void levelUp(){
        increaseLevel();
        this.experienceToNextLevel += 50;
        increaseMaxHealthPoints(20);
        increaseAttackPoints(5);
        heal(20);

    }
}
