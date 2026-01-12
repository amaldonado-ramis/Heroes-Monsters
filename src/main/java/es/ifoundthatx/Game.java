package es.ifoundthatx;

import es.ifoundthatx.cli.MainMenu;

public class Game {
    public void start() {
        showTitle();
        mainLoop();
    }

    private void showTitle() {
        System.out.println("=".repeat(30));
        System.out.println(" ".repeat(5) + "HEROES & MONSTERS" + " ".repeat(5));
        System.out.println("=".repeat(30));
    }

    private void mainLoop() {
        while (true) {
            MainMenu menu = new MainMenu();
            menu.show();
        }
    }
}
