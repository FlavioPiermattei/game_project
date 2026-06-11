package it.unicam.cs.mpgc.rpg129853.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class JsonGameSaveRepository implements GameSaveRepository {

    private static final String SAVE_FILE_NAME = "savegame.json";

    private final Gson gson;
    private final Path saveFilePath;

    public JsonGameSaveRepository() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.saveFilePath = Path.of(SAVE_FILE_NAME);
    }

    @Override
    public void save(GameSaveData data) throws IOException {
        Files.writeString(saveFilePath, gson.toJson(data));
    }

    @Override
    public Optional<GameSaveData> load() throws IOException {
        if (!Files.exists(saveFilePath)) {
            return Optional.empty();
        }
        String json = Files.readString(saveFilePath);
        return Optional.of(gson.fromJson(json, GameSaveData.class));
    }
}
