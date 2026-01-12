package es.ifoundthatx.models;

public class AttackResult {
    private final String attackName;
    private final int damage;
    private final boolean critical, effect;

    public AttackResult(String attackName, int damage, boolean critical, boolean effect) {
        this.attackName = attackName;
        this.damage = damage;
        this.critical = critical;
        this.effect = effect;
    }

    public String getAttackName() { return attackName; }
    public int getDamage() { return damage; }
    public boolean isCritical() { return critical; }
    public boolean hasEffect() { return effect; }
}
