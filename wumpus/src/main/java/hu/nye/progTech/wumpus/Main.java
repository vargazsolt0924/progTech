package hu.nye.progTech.wumpus;

import hu.nye.progTech.wumpus.model.HeroVo;
import hu.nye.progTech.wumpus.service.Map.BufferedMapReader;
import hu.nye.progTech.wumpus.service.Menu.Menu;
import hu.nye.progTech.wumpus.service.Menu.User;
import hu.nye.progTech.wumpus.service.Map.MapWriter;
import hu.nye.progTech.wumpus.service.exception.MapReaderException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        // Felhasználó létrehozása
        System.out.print("Kérem, adjon meg egy felhasználónevet: ");
        String username = scanner.nextLine();
        User user = new User(username);
        System.out.println("Szia " + username + "!");

        Menu menu = new Menu();
        MapWriter game = new MapWriter();
        HeroVo hero = new HeroVo("",0 ,"",0,0);

        boolean isGameReady = false;

        boolean quit = false;

        menu.showMainMenu();
        while (!quit) {
            int choice = menu.getUserChoice();

            switch (choice) {
                case 1:
                    // Pályaszerkesztés
                    // Implementáld a pályaszerkesztés funkciót
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
                                System.out.println("Nem érvényes választás a játékmenüben. Kérem, válasszon újra.");
                                break;
                        }
                    }
                    isGameReady = true;
                    break;
                case 2:
                    InputStream inputStream = Main.class.getClassLoader().getResource("map/wumpuszinput.txt").openStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    BufferedMapReader mapReader = new BufferedMapReader(bufferedReader, hero);

                    try {
                        List<String> mapData = mapReader.readMap();

                        game.mapPrinter(mapData);
                    } catch (MapReaderException e) {
                        System.out.println("Hiba történt a pálya beolvasása közben: " + e.getMessage());
                    }
                    System.out.println("Ennyi íjjal rendelkezik jelenleg: " + hero.getArrows());
                    isGameReady = true;
                    System.out.println("Kész a páyla beolvasás, ezután válazd ki a játék menüpontot és kezdődhet is a játék.");
                    break;
                case 3:
                    // Adatbázisból betöltés
                    // Implementáld az adatbázisból betöltés funkciót
                    isGameReady = true;
                    break;
                case 4:
                    // Adatbázisba mentés
                    // Implementáld az adatbázisba mentés funkciót
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
                                    // Lépés
                                    // Implementáld a lépés funkciót
                                    break;
                                case 2:
                                    // Fordulás jobbra
                                    // Implementáld a fordulás jobbra funkciót
                                    break;
                                case 3:
                                    // Fordulás balra
                                    // Implementáld a fordulás balra funkciót
                                    break;
                                case 4:
                                    // Nyíl lövés
                                    // Implementáld a nyíl lövés funkciót
                                    break;
                                case 5:
                                    // Arany felszedése
                                    // Implementáld az arany felszedés funkciót
                                    break;
                                case 6:
                                    // Feladás
                                    // Implementáld a feladás funkciót
                                    inGameMenu = false;
                                    menu.showMainMenu();
                                    break;
                                default:
                                    System.out.println("Nem érvényes választás a játékmenüben. Kérem, válasszon újra.");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Először hajtsa végre a pályaszerkesztést, fájlból beolvasást vagy adatbázisból betöltést.");
                    }
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Nem érvényes választás. Kérem, válasszon újra.");
                    break;
            }
        }

        System.out.println("Kilépés a játékból.");
    }
}

