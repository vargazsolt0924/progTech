package hu.nye.progTech.wumpus;

import hu.nye.progTech.wumpus.service.Map.BufferReaderMap;
import hu.nye.progTech.wumpus.service.Menu.Menu;
import hu.nye.progTech.wumpus.service.Menu.User;
import hu.nye.progTech.wumpus.service.controller.GameController;

import java.io.IOException;
import java.io.InputStream;
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
        GameController game = new GameController();

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
                    // Fájlból beolvasás
                    isGameReady = true;
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
                                    System.out.println("Biztos vagy benne, hogy feladod?");
                                    inGameMenu = false;
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

        System.out.println("Kilépés a programból.");
    }
}


