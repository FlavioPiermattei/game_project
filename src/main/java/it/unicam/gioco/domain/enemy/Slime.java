package it.unicam.gioco.domain.enemy;

import it.unicam.gioco.domain.Enemy;

public class Slime  extends Enemy {
    public Slime(int level) {
        super(
                "Goblin",
                "Humanoid",
                2 + level,
                50 + (level * 12),
                6 + (level * 2),
                30 + (level * 12)
        );

    }
}
