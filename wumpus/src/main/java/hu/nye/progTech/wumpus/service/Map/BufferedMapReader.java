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
    private HeroVo hero;

    public BufferedMapReader(BufferedReader bufferedReader, HeroVo hero) {
        this.bufferedReader = bufferedReader;
        this.hero = hero;
    }

    @Override
    public MapVo readMap() throws MapReaderException {
        String line;
        List<String> result = new ArrayList<>();
        String firstLine;
        int wumpusCounter = 0;
        try {
            firstLine = bufferedReader.readLine();
            String[] firstLineParts = firstLine.split(" ");
            int size = Integer.parseInt(firstLineParts[0]);
            String heroColumn = (firstLineParts[1]);
            int heroRow = (Integer.parseInt(firstLineParts[2]));
            String direction = (firstLineParts[3]);


            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
                wumpusCounter += countWumpusInLine(line);
            }


            // Helyesen hozz létre egy MapVo objektumot
            String[][] mapData = new String[result.size()][];
            for (int i = 0; i < result.size(); i++) {
                mapData[i] = result.get(i).split(" ");
            }

            hero = new HeroVo(heroColumn,heroRow,direction,wumpusCounter,0);
            return new MapVo(size, size, mapData, hero);
        } catch (IOException e) {
            throw new MapReaderException("Sikertelen térkép beolvasás");
        }
    }

    private int countWumpusInLine(String line) {
        int count = 0;
        for (char c : line.toCharArray()) {
            if (c == 'U') {
                count++;
            }
        }
        return count;
    }
}
