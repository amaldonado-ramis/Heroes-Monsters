package es.ifoundthatx.cli;

import es.ifoundthatx.db.HeroRepository;
import es.ifoundthatx.models.Character;
import es.ifoundthatx.utils.CharacterFactory;

import java.util.Random;

public class GameMenu extends Menu {
    private final Character hero;
    private final HeroRepository heroRepository = new HeroRepository();

    public GameMenu(Character hero) { this.hero = hero; }

    @Override
    protected void showOptions() {
        System.out.println("[1]: Combat");
        System.out.println("[2]: Train");
        System.out.println("[3]: Rest");
        System.out.println("[4]: Chill");
        System.out.println("[5]: Show Statistics");
        System.out.println("[6]: Exit");
    }

    @Override
    protected void userChoice() {
        int option = InputReader.readInt(1, 6, "/game/");

        switch (option) {
            case 1 -> {
                Character enemy = CharacterFactory.createMonster("Enemy", "Monster");
                CombatMenu combatMenu = new CombatMenu(hero, enemy);

                while (!combatMenu.isBattleOver) { combatMenu.show(); }
                if (combatMenu.hasWon) { System.out.println("[\uD83C\uDF89]: You won!"); }
                else { System.out.println("[\uD83D\uDE2D]: You lost! Try harder next time. ;)"); }
            }
            case 2 -> hero.strengthen(new Random().nextDouble());  // This literally does nothing.
            case 3 -> {
                int maxHeal = (int) (hero.getMaxHp() - hero.getCurrentHp());
                int healAmount = new Random().nextInt(1, maxHeal);
                hero.heal(healAmount);

                System.out.printf("[❤]: You healed %d points!%n", healAmount);
            }
            case 4 -> System.out.println("[\uD83D\uDEAC]: Cigarette time!");
            case 5 -> System.out.println(hero.getCurrentHp());
            case 6 -> {
                heroRepository.save(hero);
                System.exit(0);
            }
        }
    }
}
