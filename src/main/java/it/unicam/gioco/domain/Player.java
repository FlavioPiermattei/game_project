package it.unicam.gioco.domain;

public class Player extends GameCharacter {

    private int level;

    public Player(String name,int healthPoints,int attackPoints,int level) {
        super(name,healthPoints,attackPoints);
        this.level = level;
    }

    public int getLevel(){
        return level;
    }
}
