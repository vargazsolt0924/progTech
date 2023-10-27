package hu.nye.progTech.wumpus.model;

import java.util.Arrays;
import java.util.Objects;


public class MapVO {

    private int size;
    private char[][] map;
    private HeroVO heroVO;

    public MapVO(int size, char[][] map, HeroVO heroVo) {
        this.size = size;
        this.map = map;
        this.heroVO = heroVo;
    }

    public MapVO() {
    }

    public HeroVO getHeroVO() {
        return heroVO;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public char[][] getMap() {
        return map;
    }

    public void setMap(char[][] map) {
        this.map = map;
    }

    public void setHeroVO(HeroVO heroVO) {
        this.heroVO = heroVO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapVO mapVo = (MapVO) o;

        if (size != mapVo.size) return false;
        if (!Arrays.deepEquals(map, mapVo.map)) return false;
        return Objects.equals(heroVO, mapVo.heroVO);
    }

    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + Arrays.deepHashCode(map);
        result = 31 * result + (heroVO != null ? heroVO.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MapVo{");
        sb.append("size=").append(size);
        sb.append(", map=").append(map == null ? "null" : Arrays.asList(map).toString());
        sb.append(", heroVo=").append(heroVO);
        sb.append('}');
        return sb.toString();
    }
}