package hu.nye.progTech.wumpus.service.Menu;

import java.util.Scanner;

public class Menu {

    private static Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public int getUserChoice() {
        System.out.print("Válassz menüpontot: ");
        return scanner.nextInt();
    }

    public void showMainMenu() {
        System.out.println(" === Főmenü === ");
        System.out.println("1. Pályaszerkesztés");
        System.out.println("2. Pálya beolvasása");
        System.out.println("3. Adatbázisból betöltés");
        System.out.println("4. Adatbázisba mentés");
        System.out.println("5. Játék indítása");
        System.out.println("6. Kilépés");
    }

    public void showGameEditorMenu() {
        System.out.println(" === Pályaszerkesztő menü === ");
        System.out.println("1. Pálya szerkesztése");
        System.out.println("2. Mentes");
        System.out.println("3. Betöltés");
        System.out.println("4. Vissza a főmenübe");
    }

    public void showGameMenu() {
        System.out.println(" === Játékmenü === ");
        System.out.println("1. Lépés");
        System.out.println("2. Fordulás jobbra");
        System.out.println("3. Fordulás balra");
        System.out.println("4. Nyíllövés");
        System.out.println("5. Arany felszedése");
        System.out.println("6. Feladás");
    }
}

