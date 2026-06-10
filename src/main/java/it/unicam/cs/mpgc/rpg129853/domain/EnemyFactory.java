package it.unicam.cs.mpgc.rpg129853.domain;

import it.unicam.cs.mpgc.rpg129853.domain.enemy.Goblin;
import it.unicam.cs.mpgc.rpg129853.domain.enemy.Slime;
import it.unicam.cs.mpgc.rpg129853.domain.enemy.Wolf;

public class EnemyFactory {


    public Enemy createEnemy(int level){
        int enemyType = level % 3;

        if(enemyType == 1){
            return new Slime(level);
        }
        if(enemyType == 2){
            return new Goblin(level);
        }
        return new Wolf(level);
    }
}

