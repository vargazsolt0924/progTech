package hu.nye.progTech.wumpus.service.hero;

import hu.nye.progTech.wumpus.model.MapVO;

public interface HeroActionsInterface {

    public void move();

    public void turnRight();

    public void turnLeft();

    public void shoot(MapVO mapVO);

    public boolean pickupGold();
}
