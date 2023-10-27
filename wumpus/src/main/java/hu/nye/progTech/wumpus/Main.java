package hu.nye.progTech.wumpus;

import hu.nye.progTech.wumpus.model.MapVO;
import hu.nye.progTech.wumpus.service.Map.MapManager;
import hu.nye.progTech.wumpus.service.Menu.Menu;
import hu.nye.progTech.wumpus.service.Map.MapWriter;

import java.io.*;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kérem, adjon meg egy felhasználónevet: ");
        String username = scanner.nextLine();
        System.out.println("Szia " + username + "!");

        Menu menu = new Menu();
        MapVO mapVO = new MapVO();

        boolean isGameReady = false;

        boolean quit = false;

        menu.showMainMenu();
        while (!quit) {
            int choice = menu.getUserChoice();

            switch (choice) {
                case 1:
                    // Pályaszerkesztés
                    boolean inGameEditorMenu = true;
                    int gameChoiceAtEditorMenu;
                    menu.showGameEditorMenu();

                    while (inGameEditorMenu) {
                        gameChoiceAtEditorMenu = menu.getUserChoice();
                        switch (gameChoiceAtEditorMenu) {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                inGameEditorMenu = false;
                                menu.showMainMenu();
                                break;
                            default:
                                System.out.println("Nem létező menüponot választottál. Kérlek, válassz egy újat.");
                                break;
                        }
                    }
                    isGameReady = true;
                    break;
                case 2:
                    MapManager mapManager = new MapManager();
                    File file = new File("C:\\Users\\Varga Zsolt\\IdeaProjects\\progTech\\wumpus\\src\\main\\resources\\map\\wumpuszinput.txt");
                    InputStream inputStream = new FileInputStream(file);
                    mapVO = mapManager.readMap(inputStream);
                    MapWriter.printMapAndHeroDetails(mapVO);
                    System.out.println("Kész a páyla beolvasás, ezután válazd ki a játék menüpontot(5) és kezdődhet is a játék.");
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
                        int gameChoice;
                        boolean inGameMenu = true;
                        menu.showGameMenu();

                        while (inGameMenu) {
                            gameChoice = menu.getUserChoice();
                            switch (gameChoice) {
                                case 1:
                                    mapVO.getHeroVO().move();
                                    MapWriter.printMapAndHeroDetails(mapVO);
                                    break;
                                case 2:
                                    mapVO.getHeroVO().turnRight();
                                    MapWriter.printMapAndHeroDetails(mapVO);
                                    break;
                                case 3:
                                    mapVO.getHeroVO().turnLeft();
                                    MapWriter.printMapAndHeroDetails(mapVO);
                                    break;
                                case 4:
                                    mapVO.getHeroVO().shoot();
                                    MapWriter.printMapAndHeroDetails(mapVO);
                                    break;
                                case 5:
                                    mapVO.getHeroVO().pickupGold();
                                    MapWriter.printMapAndHeroDetails(mapVO);
                                    break;
                                case 6:
                                    // Feladás
                                    inGameMenu = false;
                                    menu.showMainMenu();
                                    break;
                                default:
                                    System.out.println("Nem létező menüponot választottál. Kérlek, válassz egy újat.");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Először hajtsa végre a pályaszerkesztést, fájlból beolvasást vagy adatbázisból betöltést, de még most csak a fájlból beolvasás elérhető.");
                    }
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Nem létező menüponot választottál. Kérlek, válassz egy újat.");
                    break;
            }
        }
        System.out.println("Kilépés a játékból.");
    }


}