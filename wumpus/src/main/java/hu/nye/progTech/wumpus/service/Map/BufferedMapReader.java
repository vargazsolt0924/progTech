package hu.nye.progTech.wumpus.service.Map;

import hu.nye.progTech.wumpus.model.HeroVO;
import hu.nye.progTech.wumpus.model.MapVO;
import hu.nye.progTech.wumpus.service.exception.MapReaderException;

import java.io.BufferedReader;
import java.io.IOException;


public class BufferedMapReader implements MapReaderInterface {

    private final BufferedReader bufferedReader;

    public BufferedMapReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    @Override
    public MapVO readMap() throws MapReaderException {
        MapVO mapVo;
        try {
            String firstLine = bufferedReader.readLine();
            String[] firstLineParts = firstLine.split(" ");

            if (firstLineParts.length != 4) {
                throw new MapReaderException("Hibás első sor formátum: " + firstLine);
            }

            int size = Integer.parseInt(firstLineParts[0]);
            char heroColumn = (char) (firstLineParts[1].charAt(0) - 'A');
            int heroRow = Integer.parseInt(firstLineParts[2]);
            char direction = firstLineParts[3].charAt(0);
            int gold = 0;
            int wumpusCounter = 0;
            char[][] map = new char[size][size];
            for (int i = 0; i < size; i++) {
                String row = bufferedReader.readLine();
                for (int j = 0; j < size; j++) {
                    map[i][j] = row.charAt(j);
                    if(row.charAt(j) == 'U'){
                        wumpusCounter++;
                    }
                }
            }
            map[heroRow-1][heroColumn] = 'H';


            HeroVO hero = new HeroVO(heroColumn, heroRow, direction, wumpusCounter, gold);
            mapVo = new MapVO(size, map, hero);
        } catch (IOException e) {
            throw new MapReaderException("Sikertelen térkép beolvasás");
        }
        return mapVo;
    }
}
