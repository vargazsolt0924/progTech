package hu.nye.progTech.wumpus.service.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hu.nye.progTech.wumpus.model.HeroVO;
import hu.nye.progTech.wumpus.model.MapVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoadFromDatabase {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoadFromDatabase.class);

    private Connection connection;
    private final String findQuery = "SELECT game_state FROM PLAYER WHERE username = ?";

    public LoadFromDatabase(Connection connection) {
        this.connection = connection;
    }

    public MapVO loadMapFromDb(String username) {
        String gameState = getGameState(username);
        MapVO mapVO = new MapVO();
        try {
            String[] parts = gameState.split(" ");

            char[] firstLine = parts[0].toCharArray();
            int size = Integer.parseInt(String.valueOf(firstLine[0]));
            char heroColumn = firstLine[2];
            int heroColumnIndex = heroColumn - 'A';
            int heroRow = Integer.parseInt(String.valueOf(firstLine[4]));
            final char heroDirection = firstLine[6];
            int wumpusCounter = 0;

            char[][] map = new char[size][size];

            for (int i = 1; i < parts.length; i++) {
                String row = parts[i];
                for (int j = 0; j < size; j++) {
                    map[i - 1][j] = row.charAt(j);
                    if (row.charAt(j) == 'U') {
                        wumpusCounter++;
                    }
                }
            }
            map[heroRow - 1][heroColumnIndex] = 'H';

            mapVO = new MapVO(size, map, null);
            HeroVO hero = new HeroVO(heroColumn, heroRow, heroDirection, wumpusCounter, false, heroRow, heroColumn);
            hero.setMapVO(mapVO);

        } catch (Exception exception) {
           LOGGER.error("Unexpected exception: "  + exception);
        }
        return mapVO;
    }

    public String getGameState(String username) {
        String gameState = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(findQuery)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                gameState = resultSet.getString("game_state");
            }
           resultSet.close();
        } catch (SQLException exception) {
            LOGGER.error("Unexpected problem happened: " + exception);
        }
        return gameState;
    }


}
