package hu.nye.progTech.wumpus.service.Menu;

import hu.nye.progTech.wumpus.model.HeroVO;

public class GameMenuEngine {

    Menu menu = new Menu();

    HeroVO heroVO;

    public GameMenuEngine() {

    }

    public void gameMenu() {
        boolean isGameReady = false;
        if (!isGameReady) {
            System.out.println("Először hajtsa végre a pályaszerkesztést, fájlból beolvasást vagy adatbázisból betöltést, de még most csak a fájlból beolvasás elérhető.");
            return;
        }

        boolean inGameMenu = true;
        while (inGameMenu) {
            int gameChoice = menu.getUserChoice();

            switch (gameChoice) {
                case 1:
                    heroVO.move();
                    break;
                case 2:
                    heroVO.turnRight();
                    break;
                case 3:
                    heroVO.turnLeft();
                    break;
                case 4:
                    heroVO.shoot();
                    break;
                case 5:
                    heroVO.pickupGold();
                    break;
                case 6:
                    inGameMenu = false;
                    menu.showMainMenu();
                    break;
                default:
                    System.out.println("Nem létező menüpontot választottál. Kérlek, válassz egy újat.");
                    break;
            }
        }
    }
}

