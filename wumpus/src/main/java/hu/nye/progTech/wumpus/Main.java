package hu.nye.progTech.wumpus;

import hu.nye.progTech.wumpus.model.HeroVo;
import hu.nye.progTech.wumpus.model.MapVo;
import hu.nye.progTech.wumpus.service.Map.MapManager;
import hu.nye.progTech.wumpus.service.Menu.GameMenuEngine;
import hu.nye.progTech.wumpus.service.Menu.MapEditorMenuEngine;
import hu.nye.progTech.wumpus.service.Menu.Menu;
import hu.nye.progTech.wumpus.service.Menu.User;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        String username = User.getUsername();
        User.greetUser(username);

        Menu menu = new Menu();
        HeroVo hero = new HeroVo();

        boolean isGameReady = false;
        boolean quit = false;

        menu.showMainMenu();
        while (!quit) {
            int choice = menu.getUserChoice();

            switch (choice) {
                case 1:
                    menu.showGameEditorMenu();
                    MapEditorMenuEngine mapEditorMenuEngine = new MapEditorMenuEngine();
                    mapEditorMenuEngine.mapEditorMenu();
                    isGameReady = true;
                    break;
                case 2:
                    MapManager mapManager = new MapManager();
                    MapVo mapData = mapManager.readMap();
                    mapManager.printMap(mapData);
                    System.out.println("A beolvasás megtörtént, most válaszd ki a játékmenüpontot(5) aztán már kezdődhet is a játék.");
                    System.out.println("Ennyi nyíllal rendelkezik a hős jelnleg: " + hero.getArrows());
                    isGameReady = true;
                    break;
                case 3:
                    // Adatbázisból betöltés
                    isGameReady = true;
                    break;
                case 4:
                    // Adatbázisba mentés
                    break;
                case 5:
                    if (isGameReady) {
                        menu.showGameMenu();
                    } else {
                        GameMenuEngine gameEngine = new GameMenuEngine();
                        gameEngine.gameMenu();
                        menu.showMainMenu();
                    }
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Nem létező menüpontot választottál. Kérlek, válassz egy újat.");
                    break;
            }
        }

        System.out.println("Kilépés a játékból.");
    }

}


