package hu.nye.progTech.wumpus.service.Hero;

import hu.nye.progTech.wumpus.model.HeroInterface;
import hu.nye.progTech.wumpus.model.HeroVO;
import hu.nye.progTech.wumpus.model.MapVO;
import hu.nye.progTech.wumpus.service.Menu.Menu;

public class HeroActions implements HeroInterface {

    private MapVO mapVO;
    private Menu menu;

    public HeroActions(MapVO mapVO) {
        if (mapVO == null) {
            throw new IllegalArgumentException("MapVO cannot be null");
        }
        this.mapVO = mapVO;
        this.menu = new Menu();
    }

    @Override
    public void move() {
        HeroVO heroVO = mapVO.getHeroVO();
        char[][] map = mapVO.getMap();
        int oldColumn = heroVO.getColumn();
        int oldRow = heroVO.getRow();

        switch (heroVO.getDirection()) {
            case 'E':
                heroVO.setColumn((char) (heroVO.getColumn() + 1));
                break;
            case 'S':
                heroVO.setRow(heroVO.getRow() + 1);
                break;
            case 'W':
                heroVO.setColumn((char) (heroVO.getColumn() - 1));
                break;
            case 'N':
                heroVO.setRow(heroVO.getRow() - 1);
                break;
            default:
                break;
        }

        char newPosition = map[heroVO.getRow() - 1][heroVO.getColumn()];
        char currentPosition = map[oldRow - 1][oldColumn];

        if (newPosition == 'W') {
            System.out.println("Itt fal van ide nem léphetsz.");
            heroVO.setColumn((char) oldColumn);
            heroVO.setRow(oldRow);
            heroVO.setSteps(heroVO.getSteps() + 1);
        } else if (newPosition == 'U') {
            System.out.println("Wumpus megölt így vége a játéknak.");
            System.exit(0);
        } else if (newPosition == 'P') {
            heroVO.setArrows(heroVO.getArrows() - 1);
            if (heroVO.getArrows() < 0) {
                heroVO.setArrows(0);
            }
            heroVO.setColumn((char) oldColumn);
            heroVO.setRow(oldRow);
            heroVO.setSteps(heroVO.getSteps() + 1);
        } else if (currentPosition == 'G') {
            pickupGold();
            map[oldRow - 1][oldColumn] = '_';
            map[heroVO.getRow() - 1][heroVO.getColumn()] = 'H';
            heroVO.setSteps(heroVO.getSteps() + 1);
        } else {
            map[oldRow - 1][oldColumn] = '_';
            map[heroVO.getRow() - 1][heroVO.getColumn()] = 'H';
            heroVO.setSteps(heroVO.getSteps() + 1);
        }
            if (isAtStartingPositionWithGold(heroVO)) {
                System.out.println("Gratulálunk! Felvetted a goldot és visszatértél a kezdőpozícióba.");
                System.out.println("Lépésszám: " + heroVO.getSteps());
                menu.showMainMenu();
            }
    }

    @Override
    public void turnRight() {
        HeroVO heroVO = mapVO.getHeroVO();
        heroVO.setSteps(heroVO.getSteps() + 1);
        switch (heroVO.getDirection()) {
            case 'E':
                heroVO.setDirection('S');
                break;
            case 'S':
                heroVO.setDirection('W');
                break;
            case 'W':
                heroVO.setDirection('N');
                break;
            default:
                heroVO.setDirection('E');
                break;
        }
    }

    @Override
    public void turnLeft() {
        HeroVO heroVO = mapVO.getHeroVO();
        heroVO.setSteps(heroVO.getSteps() + 1);
        switch (heroVO.getDirection()) {
            case 'S':
                heroVO.setDirection('E');
                break;
            case 'W':
                heroVO.setDirection('S');
                break;
            case 'N':
                heroVO.setDirection('W');
                break;
            default:
                heroVO.setDirection('N');
                break;
        }
    }

    @Override
    public void shoot(MapVO mapVO) {
        // Implement shoot logic here
    }

    @Override
    public boolean pickupGold() {
        HeroVO heroVO = mapVO.getHeroVO();
        heroVO.setGold(true);
        System.out.println("Gold picked up!");
        return heroVO.pickupGold();
    }


    private boolean isAtStartingPositionWithGold(HeroVO heroVO) {
        return heroVO.getRow() == heroVO.getStartingRow() &&
                heroVO.getColumn() == heroVO.getStartingColumn() &&
                heroVO.isGold();
    }


}
