package es.ifoundthatx.models;

import java.util.List;

public class Character {
    private final String name, type;
    private final double maxHp;
    private double currentHp, strength;

    private List<Attack> attacks;
    private List<Defense> defenses;

    public Character(String name, String type, double maxHp, List<Attack> attacks, List<Defense> defenses) {
        this.name = name;
        this.type = type;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.strength = 1;
        this.attacks = attacks;
        this.defenses = defenses;
    }

    public Character(String name, String type, double maxHp, double currentHp) {
        this.name = name;
        this.type = type;
        this.maxHp = maxHp;
        this.currentHp = currentHp;
    }

    public void setAttacks(List<Attack> attacks) { this.attacks = attacks; }
    public void setDefenses(List<Defense> defenses) { this.defenses = defenses; }

    public boolean isAlive() { return currentHp > 0; }
    public void receiveDamage(double damage) {
        currentHp -= damage;
        if (currentHp < 0) { currentHp = 0; }
    }

    public void heal(double amount) {
        currentHp += amount;
        if (currentHp > maxHp) { currentHp = maxHp; }
    }
    public void strengthen(double amount) { strength += amount; }

    public Attack getAttack(int index) { return attacks.get(index); }
    public Defense getDefense(int index) { return defenses.get(index); }

    public String getName() { return this.name; }
    public String getType() { return this.type; }
    public double getCurrentHp() { return this.currentHp; }
    public double getMaxHp() { return this.maxHp; }
}
