package es.ifoundthatx.cli;

import es.ifoundthatx.models.Character;
import es.ifoundthatx.models.Combat;

public class CombatMenu extends Menu {
    private final Character player, enemy;
    private final Combat combat;
    public boolean isBattleOver, hasWon;

    public CombatMenu(Character player, Character enemy) {
        this.player = player;
        this.enemy = enemy;
        this.combat = new Combat(player, enemy);
    }

    @Override
    protected void showOptions() {
        System.out.println("[1]: Attack");
        System.out.println("[2]: Defend");
        System.out.println("[3]: Statistics");
        System.out.println("[4]: End battle");
    }

    @Override
    protected void userChoice() {
        int option = InputReader.readInt(1, 3, "/battle/");

        switch (option) {
            case 1 -> {
                combat.playerAttack(0);
                if (!enemy.isAlive()) { this.hasWon = combat.hasWon(); }

                combat.monsterAttack(0);
                if (!player.isAlive()) { this.hasWon = combat.hasWon(); }
            }
            case 2 -> combat.playerDefend(0);
            case 3 -> {
                System.out.println(player.getCurrentHp());
                System.out.println(enemy.getCurrentHp());
            }
            case 4 -> System.exit(0);
        }
        this.isBattleOver = combat.isBattleOver();
    }
}
