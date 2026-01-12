package es.ifoundthatx.cli;

import es.ifoundthatx.Game;
import es.ifoundthatx.models.AttackResult;
import es.ifoundthatx.models.Character;

public class MainMenu extends Menu {
    @Override
    protected void showOptions() {
        System.out.println("[1]: New Game");
        System.out.println("[2]: Continue");
        System.out.println("[3]: Exit");
    }

    @Override
    protected void userChoice() {
        int option = InputReader.readInt(1, 3, "/");

        switch (option) {
            case 1 -> {
                Character hero = new CreateHeroMenu().show();
                if (hero != null) { this.startGame(hero); }
            }
            case 2 -> {
                Character hero = new ChooseHeroMenu().show();
                if (hero != null) { this.startGame(hero); }
            }
            case 3 -> System.exit(0);
        }
    }

    private void startGame(Character hero) {
        while (hero.isAlive()) { new GameMenu(hero).show(); }
        System.out.println("[GAME OVER]: You died!");
    }
}
