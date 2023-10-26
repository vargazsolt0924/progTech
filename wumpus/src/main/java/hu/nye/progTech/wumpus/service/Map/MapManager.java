package hu.nye.progTech.wumpus.service.Map;

import hu.nye.progTech.wumpus.Main;
import hu.nye.progTech.wumpus.model.MapVo;
import hu.nye.progTech.wumpus.service.exception.MapReaderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MapManager{
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public MapVo readMap(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedMapReader mapReader = new BufferedMapReader(bufferedReader);

        try {
            return mapReader.readMap(); // Most a MapVo objektumot adja vissza
        } catch (MapReaderException e) {
            logger.error("Valami hiba történt a pálya beolvasás közben!", e);
            return null;
        }
    }

    public void printMap(MapVo mapVo) {
        if (mapVo != null) {
            MapWriter mapWriter = new MapWriter();
            mapWriter.mapPrinter(mapVo);
        } else {
            System.out.println("Hiba történt a pálya beolvasása közben.");
        }
    }
}
