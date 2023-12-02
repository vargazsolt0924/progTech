package hu.nye.progTech.wumpus;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import hu.nye.progTech.wumpus.model.MapVO;
import hu.nye.progTech.wumpus.service.database.LoadFromDatabase;
import hu.nye.progTech.wumpus.service.database.SaveToDatabase;
import hu.nye.progTech.wumpus.service.json.LoadFromJson;
import hu.nye.progTech.wumpus.service.json.SaveToJson;
import hu.nye.progTech.wumpus.service.map.MapManager;
import hu.nye.progTech.wumpus.service.map.MapWriter;
import hu.nye.progTech.wumpus.service.menu.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a username: ");
        String username = scanner.nextLine();
        System.out.println("Hi " + username + "!");

        Menu menu = new Menu();
        MapVO mapVO = new MapVO();
        LoadFromJson loadFromJson = new LoadFromJson();
        SaveToJson saveToJson = new SaveToJson();


        boolean isGameReady = false;

        boolean quit = false;

        menu.showMainMenu();
        while (!quit) {
            int choice = menu.getUserChoice();

            switch (choice) {
                case 1:
                    boolean inJsonMenu = true;
                    int gameChoiceAtEditorMenu;
                    menu.showGameEditorMenu();

                    while (inJsonMenu) {
                        gameChoiceAtEditorMenu = menu.getUserChoice();
                        switch (gameChoiceAtEditorMenu) {
                            case 1:
                                mapVO = loadFromJson.loadMapFromJson(username);
                                break;
                            case 2:
                                saveToJson.saveMapToJson(mapVO, username);
                                break;
                            case 3:
                                inJsonMenu = false;
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
                    File file = new File(
                            "C:\\Users\\Varga Zsolt\\IdeaProjects\\progTech\\wumpus\\src\\main\\resources\\map\\wumpuszinput.txt");
                    InputStream inputStream = new FileInputStream(file);
                    mapVO = mapManager.readMap(inputStream);
                    MapWriter.printMapAndHeroDetails(mapVO);
                    System.out.println("The map is read in is done. Now select the game menu option(5) and the game can begin.");
                    isGameReady = true;
                    break;
                case 3:
                        try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/progTech", "sa", "password")) {
                            LoadFromDatabase loadFromDatabase = new LoadFromDatabase(connection);
                            loadFromDatabase.loadMapFromDb(username);
                        } catch (SQLException exception) {
                            LOGGER.error("Unexpected exception: "  + exception);
                        }
                    MapWriter.printMapAndHeroDetails(mapVO);
                    isGameReady = true;
                    break;
                case 4:
                    try (Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/progTech", "sa", "password")) {
                        SaveToDatabase saveToDatabase = new SaveToDatabase(connection);
                        saveToDatabase.saveMapToDb(mapVO, username);
                    } catch (SQLException exception) {
                        LOGGER.error("Unexpected exception: "  + exception);
                    }
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
                        System.out.println("First do read from file or load from database!");
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