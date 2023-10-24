package hu.nye.progTech.wumpus.service.Map;

import hu.nye.progTech.wumpus.model.HeroVo;
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
    public List<String> readMap() throws MapReaderException {
        String line;
        List<String> result = new ArrayList<>();
        String firstLine;
        int wumpusCounter = 0;
        try {
            firstLine = bufferedReader.readLine();
            String[] firstLineParts = firstLine.split(" ");
            int size = Integer.parseInt(firstLineParts[0]);
            hero.setColumn(firstLineParts[1]);
            hero.setRow(Integer.parseInt(firstLineParts[2]));
            hero.setDirection(firstLineParts[3]);

            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
                wumpusCounter += countWumpusInLine(line);
            }

            hero.setArrows(wumpusCounter);
            hero.setGold(0);
        } catch (IOException e) {
            throw new MapReaderException("Sikertelen térkép beolvasás");
        }
        return result;
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
