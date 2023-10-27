package hu.nye.progTech.wumpus.model;

public class HeroVO implements HeroInterface {
    private char column;
    private int row;
    private char direction;
    private int arrows;
    private int gold;

    public HeroVO(char column, int row, char direction, int arrows, int gold) {
        this.column = column;
        this.row = row;
        this.direction = direction;
        this.arrows = arrows;
        this.gold = gold;
    }

    public HeroVO() {
    }


    public char getColumn() {
        return column;
    }

    public void setColumn(char column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public int getArrows() {
        return arrows;
    }

    public void setArrows(int arrows) {
        this.arrows = arrows;
    }

    public int getGold() {
        return gold;
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

        HeroVO heroVo = (HeroVO) o;

        if (column != heroVo.column) return false;
        if (row != heroVo.row) return false;
        if (direction != heroVo.direction) return false;
        if (arrows != heroVo.arrows) return false;
        return gold == heroVo.gold;
    }

    @Override
    public int hashCode() {
        int result = column;
        result = 31 * result + row;
        result = 31 * result + (int) direction;
        result = 31 * result + arrows;
        result = 31 * result + gold;
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("HeroVo{");
        sb.append("column=").append(column);
        sb.append(", row=").append(row);
        sb.append(", direction=").append(direction);
        sb.append(", arrows=").append(arrows);
        sb.append(", gold=").append(gold);
        sb.append('}');
        return sb.toString();
    }
}