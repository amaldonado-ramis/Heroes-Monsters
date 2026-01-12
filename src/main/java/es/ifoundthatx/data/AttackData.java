package es.ifoundthatx.data;

public class AttackData {
    public String name;
    public int normalMin, normalMax;
    public int criticalMin, criticalMax;
    public double criticalChance, effectChance;

    public AttackData(
            String name,
            int normalMin, int normalMax,
            int criticalMin, int criticalMax,
            double criticalChance, double effectChance
    ) {
        this.name = name;
        this.normalMin = normalMin;
        this.normalMax = normalMax;
        this.criticalMin = criticalMin;
        this.criticalMax = criticalMax;
        this.criticalChance = criticalChance;
        this.effectChance = effectChance;
    }
}
