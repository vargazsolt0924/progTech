package hu.nye.progTech.wumpus.model;

import java.util.Arrays;

public class MapVo {

    private final int numberOfRows;
    private final int getNumberOfColumns;
    private final String[][] map;
    private final boolean[][] fixed;

    public MapVo(int numberOfRows, int getNumberOfColumns, String[][] map, boolean[][] fixed) {
        this.numberOfRows = numberOfRows;
        this.getNumberOfColumns = getNumberOfColumns;
        this.map = deepCopy(map);
        this.fixed = deepCopy(fixed);
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getGetNumberOfColumns() {
        return getNumberOfColumns;
    }

    public String[][] getMap() {
        return deepCopy(map);
    }

    public boolean[][] getFixed() {
        return deepCopy(fixed);
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

    private boolean[][] deepCopy(boolean[][] fixed) {
        boolean[][] result = new boolean[fixed.length][];

        for (int i = 0; i < fixed.length; i++) {
            result[i] = new boolean[fixed[i].length];
            for (int j = 0; j < fixed[i].length; j++) {
                result[i][j] = fixed[i][j];
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
        if (getNumberOfColumns != mapVo.getNumberOfColumns) return false;
        if (!Arrays.deepEquals(map, mapVo.map)) return false;
        return Arrays.deepEquals(fixed, mapVo.fixed);
    }

    @Override
    public int hashCode() {
        int result = numberOfRows;
        result = 31 * result + getNumberOfColumns;
        result = 31 * result + Arrays.deepHashCode(map);
        result = 31 * result + Arrays.deepHashCode(fixed);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MapVo{");
        sb.append("numberOfRows=").append(numberOfRows);
        sb.append(", getNumberOfColumns=").append(getNumberOfColumns);
        sb.append(", map=").append(map == null ? "null" : Arrays.asList(map).toString());
        sb.append(", fixed=").append(fixed == null ? "null" : Arrays.asList(fixed).toString());
        sb.append('}');
        return sb.toString();
    }
}

