package it.unicam.gioco.domain;

public class Enemy extends GameCharacter {

    private String type;

    public Enemy(String type,String name,int healthPoints,int attackPoints){
        super(name,healthPoints,attackPoints);
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
