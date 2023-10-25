package hu.nye.progTech.wumpus.model;

import java.util.Arrays;
import java.util.Objects;

public class MapVo {

    private final int numberOfRows;
    private final int numberOfColumns;
    private final String[][] map;
    private String heroColumn;
    private int heroRow;

    public MapVo(int numberOfRows, int numberOfColumns, String[][] map, String heroColumn, int heroRow) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.map = deepCopy(map);
        this.heroColumn = heroColumn;
        this.heroRow = heroRow;
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

    public String getHeroColumn() {
        return heroColumn;
    }

    public int getHeroRow() {
        return heroRow;
    }

    public void setHeroColumn(String heroColumn) {
        this.heroColumn = heroColumn;
    }

    public void setHeroRow(int heroRow) {
        this.heroRow = heroRow;
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
        if (heroRow != mapVo.heroRow) return false;
        if (!Arrays.deepEquals(map, mapVo.map)) return false;
        return Objects.equals(heroColumn, mapVo.heroColumn);
    }

    @Override
    public int hashCode() {
        int result = numberOfRows;
        result = 31 * result + numberOfColumns;
        result = 31 * result + Arrays.deepHashCode(map);
        result = 31 * result + (heroColumn != null ? heroColumn.hashCode() : 0);
        result = 31 * result + heroRow;
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MapVo{");
        sb.append("numberOfRows=").append(numberOfRows);
        sb.append(", numberOfColumns=").append(numberOfColumns);
        sb.append(", map=").append(map == null ? "null" : Arrays.asList(map).toString());
        sb.append(", heroColumn='").append(heroColumn).append('\'');
        sb.append(", heroRow=").append(heroRow);
        sb.append('}');
        return sb.toString();
    }
}
