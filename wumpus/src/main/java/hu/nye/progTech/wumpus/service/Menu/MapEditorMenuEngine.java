package hu.nye.progTech.wumpus.service.Menu;

public class MapEditorMenuEngine {
    Menu menu = new Menu();

    public void mapEditorMenu() {
        boolean inEditorMenu = true;
        while (inEditorMenu) {
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
                    // Vissza főmenübe
                    inEditorMenu = false;
                    menu.showMainMenu();
                    break;
                default:
                    System.out.println("Nem létező menüpontot választottál. Kérlek, válassz egy újat.");
                    break;
            }
        }
    }
}
