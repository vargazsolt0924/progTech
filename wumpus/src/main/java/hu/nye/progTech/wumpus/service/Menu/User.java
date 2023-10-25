package hu.nye.progTech.wumpus.service.Menu;

import java.util.Scanner;

public class User {

    public static String getUsername() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kérem, adjon meg egy felhasználónevet: ");
        return scanner.nextLine();
    }

    public static void greetUser(String username) {
        System.out.println("Szia " + username + "!");
    }
}
