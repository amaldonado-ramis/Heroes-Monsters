package es.ifoundthatx.utils;

import es.ifoundthatx.models.Attack;
import es.ifoundthatx.models.Character;
import es.ifoundthatx.models.Defense;

import java.util.List;

public class CharacterFactory {
    public static Character createHero(String name, String type) {
        List<Attack> attacks = AttackLoader.load("data/heroes_attacks.json", type);
        List<Defense> defenses = DefenseLoader.load("data/heroes_defenses.json", type);

        double maxHp = switch (type) {
            case "Warrior" -> 150;
            default -> 100;
        };

        return new Character(name, type, maxHp, attacks, defenses);
    }

    public static Character createMonster(String name, String type) {
        List<Attack> attacks = AttackLoader.load("data/heroes_attacks.json", "Warrior");
        List<Defense> defenses = DefenseLoader.load("data/heroes_defenses.json", "Warrior");

        double maxHp = switch (type) {
            case "Warrior" -> 150;
            default -> 100;
        };

        return new Character(name, type, maxHp, attacks, defenses);
    }
}

