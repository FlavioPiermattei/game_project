package it.unicam.cs.mpgc.rpg129853.domain.enemy;

import it.unicam.cs.mpgc.rpg129853.domain.Enemy;

public class Goblin extends Enemy {
    public Goblin(int level) {
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
