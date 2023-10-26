package hu.nye.progTech.wumpus.service.Map;

import hu.nye.progTech.wumpus.model.HeroVo;
import hu.nye.progTech.wumpus.model.MapVo;
import hu.nye.progTech.wumpus.service.exception.MapReaderException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BufferedMapReader implements MapReaderInterface {

    private final BufferedReader bufferedReader;
    private final HeroVo hero;

    public BufferedMapReader(BufferedReader bufferedReader, HeroVo hero) {
        this.bufferedReader = bufferedReader;
        this.hero = hero;
    }

    @Override
    public MapVo readMap() throws MapReaderException {
        try {
            String firstLine = bufferedReader.readLine();
            String[] firstLineParts = firstLine.split(" ");

            if (firstLineParts.length != 4) {
                throw new MapReaderException("Hibás első sor formátum: " + firstLine);
            }

            int size = Integer.parseInt(firstLineParts[0]);
            hero.setColumn(firstLineParts[1]);
            hero.setRow(Integer.parseInt(firstLineParts[2]));
            hero.setDirection(firstLineParts[3]);
            hero.setGold(0);
            List<String> mapData = mapSizeVerifier(size);
            int wumpusCount = countWumpusInLine(mapData);
            hero.setArrows(wumpusCount);
            return createMap(size, mapData);
        } catch (IOException e) {
            throw new MapReaderException("Sikertelen térkép beolvasás");
        }
    }

    private List<String> mapSizeVerifier(int size) throws IOException, MapReaderException {
        List<String> mapData = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String line = bufferedReader.readLine();
            if (line == null || line.length() != size) {
                throw new MapReaderException("Hibás sor formátum a pályán.");
            }
            mapData.add(line);
        }
        return mapData;
    }

    private int countWumpusInLine(List<String> mapData) {
        int count = 0;
        for (String line : mapData) {
            for (char c : line.toCharArray()) {
                if (c == 'U') {
                    count++;
                }
            }
        }
        return count;
    }


    private MapVo createMap(int size, List<String> mapData) {
        String[][] mapDataArray = new String[size][size];
        for (int i = 0; i < size; i++) {
            mapDataArray[i] = mapData.get(i).split("");
        }
        return new MapVo(size, size, mapDataArray);
    }
}


