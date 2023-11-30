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

        System.out.print("Please enter a username: ");
        String username = scanner.nextLine();
        System.out.println("Hi " + username + "!");


        Menu menu = new Menu();
        MapVO mapVO = new MapVO();

        boolean isGameReady = false;

        boolean quit = false;

        menu.showMainMenu();
        while (!quit) {
            int choice = menu.getUserChoice();

            switch (choice) {
                case 1:
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
                                System.out.println("You have selected a menu option that doesn't exist. Please choose a new one!");
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
                    System.out.println("The map is read in is done. Now select the game menu option(5) and the game can begin.");
                    isGameReady = true;
                    break;
                case 3:
                    isGameReady = true;
                    break;
                case 4:
                    isGameReady = true;
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
                                    mapVO.getHeroVO().shoot(mapVO);
                                    MapWriter.printMapAndHeroDetails(mapVO);
                                    break;
                                case 5:
                                    inGameMenu = false;
                                    menu.showMainMenu();
                                    System.out.println("Unfortunately, you give up the game");
                                    break;
                                default:
                                    System.out.println("You have selected a menu option that doesn't exist. Please choose a new one!");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("First do map editing, read from file or load from database, but only read fromm file is available for now.");
                    }
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("You have selected a menu option that doesn't exist. Please choose a new one!");
                    break;
            }
        }
        System.out.println("Quit the game.");
    }
}