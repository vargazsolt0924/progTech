package hu.nye.progTech.wumpus.model;

public class HeroVo {
    private int row;
    private int col;
    private char direction;
    private int arrows;
    private int gold;

    public HeroVo(int row, int col, char direction, int arrows) {
        this.row = row;
        this.col = col;
        this.direction = direction;
        this.arrows = arrows;
        this.gold = 0;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public char getDirection() {
        return direction;
    }

    public int getArrows() {
        return arrows;
    }

    public int getGold() {
        return gold;
    }

    public void move() {
        // Hős mozgatása a nézési irány felé
    }

    public void turnRight() {
        // Jobbra fordulás
    }

    public void turnLeft() {
        // Balra fordulás
    }

    public void shoot() {
        // Nyíl lövése
    }

    public void pickupGold() {
        // Arany felszedése
    }

}
