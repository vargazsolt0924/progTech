package hu.nye.progTech.wumpus.model;

public interface HeroInterface {

    public void move();

    public void turnRight();

    public void turnLeft();

    public void shoot(MapVO mapVO);

    public boolean pickupGold();
}
