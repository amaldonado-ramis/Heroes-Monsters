package es.ifoundthatx.models;

import es.ifoundthatx.data.DefenseData;
import es.ifoundthatx.data.DefenseOutcomeData;

import java.util.Random;

public class Defense {
    private final DefenseData data;
    private static final Random random = new Random();

    public Defense(DefenseData data) { this.data = data; }

    public DefenseResult execute(int maxHp) {
        double roll = random.nextDouble();
        double accumulated = 0.0;

        for (DefenseOutcomeData outcome : data.outcomes) {
            accumulated += outcome.chance;
            if (roll <= accumulated) { return new DefenseResult(data.name, data.type, outcome.value); }
        }

        DefenseOutcomeData last = data.outcomes.get(data.outcomes.size() - 1);
        return new DefenseResult(data.name, data.type, last.value);
    }
}
