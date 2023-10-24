package hu.nye.progTech.wumpus.model;

import java.util.Objects;

public class HeroVo implements HeroInterface {
    private String column;
    private int row;
    private String direction;
    private int arrows;
    private int gold;

    public HeroVo(String column, int row, String direction, int arrows, int gold) {
        this.column = column;
        this.row = row;
        this.direction = direction;
        this.arrows = arrows;
        this.gold = gold;
    }

    public int getRow() {
        return row;
    }

    public String getColumn() {
        return column;
    }

    public String getDirection() {
        return direction;
    }

    public int getArrows() {
        return arrows;
    }

    public int getGold() {
        return gold;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setArrows(int arrows) {
        this.arrows = arrows;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public void move() {

    }

    @Override
    public void turnRight() {

    }

    @Override
    public void turnLeft() {

    }

    @Override
    public void shoot() {

    }

    @Override
    public void pickupGold() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HeroVo heroVo = (HeroVo) o;

        if (row != heroVo.row) return false;
        if (arrows != heroVo.arrows) return false;
        if (gold != heroVo.gold) return false;
        if (!Objects.equals(column, heroVo.column)) return false;
        return Objects.equals(direction, heroVo.direction);
    }

    @Override
    public int hashCode() {
        int result = column != null ? column.hashCode() : 0;
        result = 31 * result + row;
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        result = 31 * result + arrows;
        result = 31 * result + gold;
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("HeroVo{");
        sb.append("column='").append(column).append('\'');
        sb.append(", row=").append(row);
        sb.append(", direction='").append(direction).append('\'');
        sb.append(", arrows=").append(arrows);
        sb.append(", gold=").append(gold);
        sb.append('}');
        return sb.toString();
    }
}
