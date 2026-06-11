package it.unicam.cs.mpgc.rpg129853.persistence;

import java.io.IOException;
import java.util.Optional;

public interface GameSaveRepository {

    void save(GameSaveData data) throws IOException;

    Optional<GameSaveData> load() throws IOException;
}
