package hu.nye.progTech.wumpus.service.Menu;


import java.util.Scanner;

public class Menu {

    private final Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public void showMainMenu() {
        System.out.println("\n==== Wumpusz Labirintus Játék ====");
        System.out.println("1. Pályaszerkesztés");
        System.out.println("2. Fájlból beolvasás");
        System.out.println("3. Adatbázisból betöltés");
        System.out.println("4. Adatbázisba mentés");
        System.out.println("5. Játék indítása");
        System.out.println("6. Kilépés");
    }

    public void showGameMenu() {
        System.out.println("\n==== Játék Menü ====");
        System.out.println("1. Lépés");
        System.out.println("2. Fordulás jobbra");
        System.out.println("3. Fordulás balra");
        System.out.println("4. Nyíl lövés");
        System.out.println("5. Arany felszedése");
        System.out.println("6. Feladás");
    }

    public void showGameEditorMenu() {
        System.out.println("\n==== Pályaszerkeztés menü ====");
        System.out.println("1. Pálya létrehozás");
        System.out.println("2. Pálya részletek hozzáadása");
        System.out.println("3. Az elkészített pálya lementése");
        System.out.println("4. Vissza a főmenübe");
    }

    public int getUserChoice() {
        System.out.print("Válassz egy menüpontot: ");
        return scanner.nextInt();
    }

}