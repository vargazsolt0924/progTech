package hu.nye.progTech.wumpus.service.Map;

import hu.nye.progTech.wumpus.model.MapVO;
import hu.nye.progTech.wumpus.service.exception.MapReaderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MapManager {
    private static final Logger logger = LoggerFactory.getLogger(MapManager.class);

    private MapVO mapVO;

    public MapVO readMap(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedMapReader mapReader = new BufferedMapReader(bufferedReader);

        try {
            return mapReader.readMap();
        } catch (MapReaderException e) {
            logger.error("Valami hiba történt a pálya beolvasás közben!", e);
            return null;
        }
    }

    public void printMap(MapVO mapVO) {
        if (mapVO != null) {
            MapWriter.mapPrinter(mapVO);
        } else {
            System.out.println("Hiba történt a pálya beolvasása közben.");
        }
    }


}
