package it.unicam.gioco.domain.enemy;

import it.unicam.gioco.domain.Enemy;

public class Wolf extends Enemy {
    public Wolf(int level) {
        super(
                "Wolf",
                "Beast",
                3 + level,
                60 + (level * 15),
                8 + (level * 2),
                40 + (level * 15)
        );
    }

}
