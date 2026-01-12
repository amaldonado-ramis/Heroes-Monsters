package es.ifoundthatx.cli;

import es.ifoundthatx.models.Attack;
import es.ifoundthatx.models.Character;

import java.util.List;

public class ChooseAttackMenu {
    public int chooseAttack(Character hero) {
        List<Attack> attacks = hero.getAttacks();
        for (int i = 0; i < attacks.size(); i++) {
            System.out.printf("[%d]: %s%n", i + 1, hero.getAttack(i).getAttackName());
        }

        int attackIndex = InputReader.readInt(1, attacks.size(), "/game/attack/");
        return attackIndex - 1;
    }
}
