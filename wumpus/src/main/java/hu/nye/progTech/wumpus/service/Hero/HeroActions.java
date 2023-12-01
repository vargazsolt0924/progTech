package hu.nye.progTech.wumpus.service.Hero;

import hu.nye.progTech.wumpus.model.HeroVO;
import hu.nye.progTech.wumpus.model.MapVO;
import hu.nye.progTech.wumpus.service.Menu.Menu;

public class HeroActions implements HeroActionsInterface {

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
            System.out.println("There's a wall over there, you can't step here.");
            heroVO.setColumn((char) oldColumn);
            heroVO.setRow(oldRow);
            heroVO.setSteps(heroVO.getSteps() + 1);
        } else if (newPosition == 'U') {
            System.out.println("Wumpus killed you, so the game is ended.");
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
        celebrateVictory();

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
        HeroVO heroVO = mapVO.getHeroVO();
        char[][] map = mapVO.getMap();
        int wumpusRow = -1, wumpusColumn = -1;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 'U') {
                    wumpusRow = i;
                    wumpusColumn = j;
                    break;
                }
            }
        }

        if (heroVO.getArrows() > 0) {
            switch (heroVO.getDirection()) {
                case 'N':
                    if (wumpusRow < heroVO.getRow()) {
                        map[wumpusRow][wumpusColumn] = '_';
                        System.out.println("You shot out the wumpus!");
                        heroVO.setArrows(heroVO.getArrows() - 1);
                    }
                    break;
                case 'S':
                    if (wumpusRow > heroVO.getRow()) {
                        map[wumpusRow][wumpusColumn] = '_';
                        System.out.println("You shot out the wumpus!");
                        heroVO.setArrows(heroVO.getArrows() - 1);
                    }
                    break;
                case 'E':
                    if (wumpusColumn > heroVO.getColumn()) {
                        map[wumpusRow][wumpusColumn] = '_';
                        System.out.println("You shot out the wumpus!");
                        heroVO.setArrows(heroVO.getArrows() - 1);
                    }
                    break;
                case 'W':
                    if (wumpusColumn < heroVO.getColumn()) {
                        map[wumpusRow][wumpusColumn] = '_';
                        System.out.println("You shot out the wumpus!");
                        heroVO.setArrows(heroVO.getArrows() - 1);
                    }
                    break;
            }
        } else {
            System.out.println("You don't have any arrows to shoot!");
        }
    }

    @Override
    public boolean pickupGold() {
        HeroVO heroVO = mapVO.getHeroVO();
        heroVO.setGold(true);
        return heroVO.pickupGold();
    }

    public void celebrateVictory() {
        HeroVO heroVO = mapVO.getHeroVO();
        System.out.println("Congratulations! You won with " + heroVO.getSteps() + " steps!");
    }
}
