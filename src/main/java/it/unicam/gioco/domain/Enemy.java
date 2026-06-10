package it.unicam.gioco.domain;

public abstract class Enemy extends GameCharacter {

    private String type;
    private int experienceReward;

    public Enemy(String name,String type,int level, int healthPoints, int attackPoints,int experienceReward){
        super(name,level,healthPoints,attackPoints);
        this.type = type;
        this.experienceReward = experienceReward;
    }

    public String getType(){
        return type;
    }
    public int getExperienceReward() {
        return experienceReward;
    }
}
