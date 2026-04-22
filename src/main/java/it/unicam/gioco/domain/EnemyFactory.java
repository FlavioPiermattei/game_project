package it.unicam.gioco.domain;

import it.unicam.gioco.domain.enemy.Goblin;
import it.unicam.gioco.domain.enemy.Slime;
import it.unicam.gioco.domain.enemy.Wolf;

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

