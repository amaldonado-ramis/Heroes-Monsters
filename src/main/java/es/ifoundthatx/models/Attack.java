package es.ifoundthatx.models;

import es.ifoundthatx.data.AttackData;

import java.util.Random;

public class Attack {
    private final AttackData data;

    public Attack(AttackData data) { this.data = data; }

    public String getAttackName() { return this.data.name; }

    public AttackResult execute() {
        Random r = new Random();

        boolean critical = r.nextDouble() < data.criticalChance;
        boolean effect = r.nextDouble() < data.effectChance;
        int damage;

        if (critical) { damage = r.nextInt(data.criticalMax - data.criticalMin + 1) + data.normalMin; }
        else { damage = r.nextInt(data.normalMax - data.normalMin + 1) + data.normalMin; }

        return new AttackResult(data.name, damage, critical, effect);
    }
}
