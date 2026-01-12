package es.ifoundthatx.models;

public class HeroSummary {
    private final int id;
    private final String name, type;
    private final double maxHp, currentHp;

    public HeroSummary(int id, String name, String type, double currentHp, double maxHp) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.currentHp = currentHp;
        this.maxHp = maxHp;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public double getCurrentHp() { return currentHp; }
    public double getMaxHp() { return maxHp; }
}

