package hu.nye.progTech.wumpus.service.menu;

import java.util.Scanner;

public class Menu {

    private final Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public void showMainMenu() {
        System.out.println("\n==== Wumpusz Labyrinth Game ====");
        System.out.println("1. JSON");
        System.out.println("2. Reading in from file");
        System.out.println("3. Loading from database");
        System.out.println("4. Save to database");
        System.out.println("5. Start game");
        System.out.println("6. Exit");
    }

    public void showGameMenu() {
        System.out.println("\n==== Game Menu ====");
        System.out.println("1. Step");
        System.out.println("2. Turn right");
        System.out.println("3. Turn left");
        System.out.println("4. Shoot");
        System.out.println("5. Give up");
    }

    public void showGameEditorMenu() {
        System.out.println("\n==== JSON menu ====");
        System.out.println("1. Load from JSON");
        System.out.println("2. Save to JSON");
        System.out.println("3. Back to main menu");
    }

    public int getUserChoice() {
        System.out.print("Choose a menu option: ");
        return scanner.nextInt();
    }

}