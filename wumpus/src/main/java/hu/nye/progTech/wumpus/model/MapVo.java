package hu.nye.progTech.wumpus.model;

import java.util.Arrays;
import java.util.Objects;

public class MapVo {

    private final int numberOfRows;
    private final int numberOfColumns;
    private final String[][] map;

    public MapVo(int numberOfRows, int numberOfColumns, String[][] map) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.map = deepCopy(map);

    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public String[][] getMap() {
        return deepCopy(map);
    }


    private String[][] deepCopy(String[][] map) {
        String[][] result = new String[map.length][];
        for (int i = 0; i < map.length; i++) {
            result[i] = new String[map[i].length];
            for (int j = 0; j < map[i].length; j++) {
                result[i][j] = map[i][j];
            }
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapVo mapVo = (MapVo) o;

        if (numberOfRows != mapVo.numberOfRows) return false;
        if (numberOfColumns != mapVo.numberOfColumns) return false;
        return Arrays.deepEquals(map, mapVo.map);
    }

    @Override
    public int hashCode() {
        int result = numberOfRows;
        result = 31 * result + numberOfColumns;
        result = 31 * result + Arrays.deepHashCode(map);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MapVo{");
        sb.append("numberOfRows=").append(numberOfRows);
        sb.append(", numberOfColumns=").append(numberOfColumns);
        sb.append(", map=").append(map == null ? "null" : Arrays.asList(map).toString());
        sb.append('}');
        return sb.toString();
    }
}

