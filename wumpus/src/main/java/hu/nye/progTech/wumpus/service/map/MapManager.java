package hu.nye.progTech.wumpus.service.map;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import hu.nye.progTech.wumpus.model.MapVO;
import hu.nye.progTech.wumpus.service.exception.MapReaderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(MapManager.class);

    public MapVO readMap(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedMapReader mapReader = new BufferedMapReader(bufferedReader);

        try {
            return mapReader.readMap();
        } catch (MapReaderException exception) {
            LOGGER.error("Something went wrong while reading the map!", exception);
            return null;
        }
    }

    public void printMap(MapVO mapVO) {
        if (mapVO != null) {
            MapWriter.mapPrinter(mapVO);
        } else {
            System.out.println("An error occurred while reading the map.");
        }
    }


}
