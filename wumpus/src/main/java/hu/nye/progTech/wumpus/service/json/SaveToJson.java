package hu.nye.progTech.wumpus.service.json;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import hu.nye.progTech.wumpus.model.MapVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SaveToJson {
    private static final Logger LOGGER = LoggerFactory.getLogger(SaveToJson.class);

    public void saveMapToJson(MapVO mapVO, String username) {
        try {
            String filePath = "C:\\Users\\Varga Zsolt\\IdeaProjects\\progTech\\wumpus\\wumpus.json";

            Map<String, String> existingContent = loadExistingContent(filePath);

            StringBuilder gameState = getStringBuilder(mapVO);
            existingContent.put(username, gameState.toString());

            saveContentToFile(filePath, existingContent);

        } catch (IOException exception) {
            LOGGER.error("Unexpected exception: " + exception);
        }
    }

    private Map<String, String> loadExistingContent(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);

        if (!file.exists()) {
            return Map.of();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return objectMapper.readValue(reader, Map.class);
        }
    }

    private void saveContentToFile(String filePath, Map<String, String> content) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            objectMapper.writeValue(writer, content);
            writer.flush();
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
