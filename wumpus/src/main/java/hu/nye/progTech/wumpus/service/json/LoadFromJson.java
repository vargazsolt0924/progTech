package hu.nye.progTech.wumpus.service.json;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import hu.nye.progTech.wumpus.model.HeroVO;
import hu.nye.progTech.wumpus.model.MapVO;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoadFromJson {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoadFromJson.class);

    public MapVO loadMapFromJson(String username) {
        MapVO mapVO = new MapVO();
        try {
            JSONObject jsonObject = new JSONObject(new FileReader("C:\\Users\\Varga Zsolt\\IdeaProjects\\progTech\\wumpus\\wumpus.json"));
            Map<String, String> gameStates = new HashMap<>();
            for (String key : jsonObject.keySet()) {
                gameStates.put(key, jsonObject.getString(key));
            }

            String gameState = gameStates.get(username);

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

        } catch (IOException | JSONException exception) {
            LOGGER.error("Unexpected exception: " + exception);
        }
        return mapVO;
    }
}

