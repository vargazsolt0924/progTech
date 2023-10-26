package hu.nye.progTech.wumpus.service.Map;

import hu.nye.progTech.wumpus.Main;
import hu.nye.progTech.wumpus.model.HeroVo;
import hu.nye.progTech.wumpus.model.MapVo;
import hu.nye.progTech.wumpus.service.exception.MapReaderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MapManager{
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public MapVo readMap() throws IOException {
        HeroVo hero = new HeroVo();
        InputStream inputStream = Main.class.getClassLoader().getResource("Map/wumpuszinput.txt").openStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedMapReader mapReader = new BufferedMapReader(bufferedReader, hero);

        try {
            MapVo mapData = mapReader.readMap();
            return mapData;
        } catch (MapReaderException e) {
            logger.error("Valami hiba történt a pálya beolvasás közben!");
            return null;
        }
    }

    public void printMap(MapVo mapData) {
        if (mapData != null) {
            MapWriter mapWriter = new MapWriter();
            mapWriter.mapPrinter(mapData);
        } else {
            System.out.println("Hiba történt a pálya beolvasása közben.");
        }
    }
}
