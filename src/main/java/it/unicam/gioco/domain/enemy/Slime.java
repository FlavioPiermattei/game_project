package it.unicam.gioco.domain.enemy;

import it.unicam.gioco.domain.Enemy;

public class Slime  extends Enemy {
    public Slime(int level) {
        super(
                "Slime",
                "Ooze",
                1 + level,
                40 + (level * 10),
                4 + (level * 2),
                20 + (level * 10)
        );

    }
}
