package hu.nye.progTech.wumpus.service.Menu;

public class GameMenuEngine {

    Menu menu = new Menu();

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
                    // Lépés
                    break;
                case 2:
                    // Fordulás jobbra
                    break;
                case 3:
                    // Fordulás balra
                    break;
                case 4:
                    // Nyíllövés
                    break;
                case 5:
                    // Arany felszedése
                    break;
                case 6:
                    // Feladás
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

