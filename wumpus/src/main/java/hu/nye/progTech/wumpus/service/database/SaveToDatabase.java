package hu.nye.progTech.wumpus.service.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hu.nye.progTech.wumpus.model.MapVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SaveToDatabase {
    private static final Logger LOGGER = LoggerFactory.getLogger(SaveToDatabase.class);

    private Connection connection;

    public SaveToDatabase(Connection connection) {
        this.connection = connection;
    }

    public void saveMapToDb(MapVO mapVO, String username) {
        StringBuilder gameState = getStringBuilder(mapVO);

        String checkQuery = "SELECT username FROM PLAYER WHERE username = ?";
        String updateQuery = "UPDATE PLAYER SET game_state = ? WHERE username = ?";
        String insertQuery = "INSERT INTO PLAYER (username, game_state) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(checkQuery)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // User exists, update the user's game state
                try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                    updateStatement.setString(1, gameState.toString());
                    updateStatement.setString(2, username);
                    updateStatement.executeUpdate();
                }
            } else {
                // User does not exist, insert a new user
                try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                    insertStatement.setString(1, username);
                    insertStatement.setString(2, gameState.toString());
                    insertStatement.executeUpdate();
                }
            }
        } catch (SQLException exception) {
            LOGGER.error("Unexpected exception: " + exception);
        }
    }


    private static StringBuilder getStringBuilder(MapVO mapVO) {
        StringBuilder gameState = new StringBuilder();

        gameState.append(mapVO.getSize());
        gameState.append(",");
        gameState.append(mapVO.getHeroVO().getColumn());
        gameState.append(",");
        gameState.append(mapVO.getHeroVO().getRow());
        gameState.append(",");
        gameState.append(mapVO.getHeroVO().getDirection());
        gameState.append(" ");


        for (int i = 0; i < mapVO.getSize(); i++) {
            for (int j = 0; j < mapVO.getSize(); j++) {
                gameState.append(mapVO.getMap()[i][j]);
            }
            if (i < mapVO.getSize() - 1) {
                gameState.append(" ");
            }
        }
        return gameState;
    }


}
