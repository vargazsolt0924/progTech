package hu.nye.progTech.wumpus.model;

import java.util.Objects;

import hu.nye.progTech.wumpus.service.hero.HeroActions;
import hu.nye.progTech.wumpus.service.hero.HeroActionsInterface;

public class HeroVO implements HeroActionsInterface {
    private char column;
    private int row;
    private char direction;
    private int arrows;
    private boolean gold = false;
    private int startingRow;
    private char startingColumn;
    private int steps;
    private MapVO mapVO;
    private HeroActions heroActions;

    public HeroVO(char column, int row, char direction, int arrows, boolean gold, int startingRow, char startingColumn, MapVO mapVO) {
        this.column = column;
        this.row = row;
        this.direction = direction;
        this.arrows = arrows;
        this.gold = gold;
        this.startingRow = startingRow;
        this.startingColumn = startingColumn;
        this.steps = 0;
        if (mapVO != null) {
            this.mapVO = mapVO;
            this.heroActions = new HeroActions(mapVO);
            setHeroData();
        } else {
            throw new IllegalArgumentException("MapVO cannot be null");
        }
    }

    public HeroVO(char column, int row, char direction, int arrows, boolean gold, int startingRow, char startingColumn) {
        this.column = column;
        this.row = row;
        this.direction = direction;
        this.arrows = arrows;
        this.gold = gold;
        this.startingRow = startingRow;
        this.startingColumn = startingColumn;
    }

    public HeroVO(char column, int row, char direction, int arrows, boolean gold) {
        this.column = column;
        this.row = row;
        this.direction = direction;
        this.arrows = arrows;
        this.gold = gold;
    }

    public HeroVO() {
    }

    private void setHeroData() {
        if (mapVO != null) {
            mapVO.setHeroVO(this);
        }
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

    public boolean isGold() {
        return gold;
    }

    public void setGold(boolean gold) {
        this.gold = gold;
    }

    public int getStartingRow() {
        return startingRow;
    }

    public void setStartingRow(int startingRow) {
        this.startingRow = startingRow;
    }

    public char getStartingColumn() {
        return startingColumn;
    }

    public void setStartingColumn(char startingColumn) {
        this.startingColumn = startingColumn;
    }

    public MapVO getMapVO() {
        return mapVO;
    }

    public void setMapVO(MapVO mapVO) {
        this.mapVO = mapVO;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }


    @Override
    public void move() {
        heroActions.move();
    }

    @Override
    public void turnRight() {
        heroActions.turnRight();
    }

    @Override
    public void turnLeft() {
        heroActions.turnLeft();
    }

    @Override
    public void shoot(MapVO mapVO) {
        heroActions.shoot(mapVO);
    }

    @Override
    public boolean pickupGold() {
        return heroActions.pickupGold();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        HeroVO heroVO = (HeroVO) o;

        if (column != heroVO.column) {
            return false;
        }
        if (row != heroVO.row) {
            return false;
        }
        if (direction != heroVO.direction) {
            return false;
        }
        if (arrows != heroVO.arrows) {
            return false;
        }
        if (gold != heroVO.gold) {
            return false;
        }
        if (startingRow != heroVO.startingRow) {
            return false;
        }
        if (startingColumn != heroVO.startingColumn) {
            return false;
        }
        if (steps != heroVO.steps) {
            return false;
        }
        if (!Objects.equals(mapVO, heroVO.mapVO)) {
            return false;
        }
        return Objects.equals(heroActions, heroVO.heroActions);
    }

    @Override
    public int hashCode() {
        int result = column;
        result = 31 * result + row;
        result = 31 * result + (int) direction;
        result = 31 * result + arrows;
        result = 31 * result + (gold ? 1 : 0);
        result = 31 * result + startingRow;
        result = 31 * result + (int) startingColumn;
        result = 31 * result + steps;
        result = 31 * result + (mapVO != null ? mapVO.hashCode() : 0);
        result = 31 * result + (heroActions != null ? heroActions.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("HeroVO{");
        sb.append("column=").append(column);
        sb.append(", row=").append(row);
        sb.append(", direction=").append(direction);
        sb.append(", arrows=").append(arrows);
        sb.append(", gold=").append(gold);
        sb.append(", startingRow=").append(startingRow);
        sb.append(", startingColumn=").append(startingColumn);
        sb.append(", steps=").append(steps);
        sb.append(", mapVO=").append(mapVO);
        sb.append(", heroActions=").append(heroActions);
        sb.append('}');
        return sb.toString();
    }
}