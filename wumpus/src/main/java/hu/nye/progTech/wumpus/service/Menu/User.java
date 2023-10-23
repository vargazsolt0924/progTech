package hu.nye.progTech.wumpus.service.Menu;

public class User {

    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "Felhasználó neve: " + username;
    }
}
