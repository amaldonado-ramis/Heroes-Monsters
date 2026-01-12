package es.ifoundthatx.models;

import es.ifoundthatx.data.AttackData;

public class Combat {
    private final Character player, enemy;

    public Combat(Character player, Character enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void playerAttack(int attackIndex) {
        Attack attack = player.getAttack(attackIndex);
        AttackResult attackResult = attack.execute();

        enemy.receiveDamage(attackResult.getDamage());
        System.out.printf("%s hits %s for %d damage!\n", player.getName(), enemy.getName(), attackResult.getDamage());
    }

    public void monsterAttack(int attackIndex) {
        Attack attack = enemy.getAttack(attackIndex);
        AttackResult attackResult = attack.execute();

        player.receiveDamage(attackResult.getDamage());
        System.out.printf("%s responds with %s making you %d damage!\n", enemy.getName(), attackResult.getAttackName(), attackResult.getDamage());
    }

    public void playerDefend(int defenseIndex) {
        Defense defense = player.getDefense(defenseIndex);
        defense.execute(defenseIndex);
    }

    public boolean isBattleOver() { return !player.isAlive() || !enemy.isAlive(); }
    public boolean hasWon() { return player.isAlive(); }
}
