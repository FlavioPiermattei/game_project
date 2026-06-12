package it.unicam.cs.mpgc.rpg129853.service;

import it.unicam.cs.mpgc.rpg129853.domain.EnemyFactory;
import it.unicam.cs.mpgc.rpg129853.domain.GameState;
import it.unicam.cs.mpgc.rpg129853.domain.Player;
import it.unicam.cs.mpgc.rpg129853.persistence.GameSaveData;
import it.unicam.cs.mpgc.rpg129853.persistence.GameSaveRepository;
import it.unicam.cs.mpgc.rpg129853.persistence.JsonGameSaveRepository;

import java.io.IOException;
import java.util.Optional;

public class GameService {

    private final GameState gameState;
    private final EnemyFactory enemyFactory;
    private final BattleService battleService;
    private final GameSaveRepository saveRepository;

    public GameService() {
        this(new JsonGameSaveRepository());
    }

    public GameService(GameSaveRepository saveRepository) {
        this.gameState = new GameState();
        this.enemyFactory = new EnemyFactory();
        this.battleService = new BattleService(gameState, enemyFactory);
        this.saveRepository = saveRepository;
    }

    public void startNewGame() {
        gameState.setGameStarted(true);
        gameState.setCurrentSceneName("Scene1");
        gameState.setPlayer(new Player("Hero", 1,100,15));
        gameState.setEnemy(enemyFactory.createEnemy(1));
    }

    public void saveGame() throws IOException {
        GameSaveData data = new GameSaveData();
        data.setCurrentSceneName(gameState.getCurrentSceneName());
        data.setVictoryAchieved(gameState.isVictoryAchieved());

        Player player = gameState.getPlayer();
        if (player != null) {
            data.setPlayerName(player.getName());
            data.setPlayerLevel(player.getLevel());
            data.setPlayerHealthPoints(player.getHealthPoints());
            data.setPlayerMaxHealthPoints(player.getMaxHealthPoints());
            data.setPlayerAttackPoints(player.getAttackPoints());
            data.setPlayerExperiencePoints(player.getExperiencePoints());
        }

        data.setEnemyCounter(battleService.getEnemyCounter());
        saveRepository.save(data);
    }

    public boolean loadGame() throws IOException {
        Optional<GameSaveData> savedData = saveRepository.load();
        if (savedData.isEmpty()) {
            return false;
        }

        GameSaveData data = savedData.get();
        gameState.setGameStarted(true);
        gameState.setCurrentSceneName(data.getCurrentSceneName());
        gameState.setVictoryAchieved(data.isVictoryAchieved());

        Player player = new Player(data.getPlayerName(), data.getPlayerLevel(),
                data.getPlayerHealthPoints(), data.getPlayerMaxHealthPoints(),
                data.getPlayerAttackPoints(), data.getPlayerExperiencePoints());
        gameState.setPlayer(player);

        battleService.setEnemyCounter(data.getEnemyCounter());
        gameState.setEnemy(enemyFactory.createEnemy(data.getEnemyCounter()));

        return true;
    }

    public GameState getGameState() {
        return gameState;
    }

    public BattleService getBattleService() {
        return battleService;
    }

}
