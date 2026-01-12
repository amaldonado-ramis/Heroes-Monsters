package es.ifoundthatx.cli;

import es.ifoundthatx.models.Character;
import es.ifoundthatx.utils.CharacterFactory;

public class CreateHeroMenu {
    private final String[] heroTypes = {"Warrior", "Wizard", "Archer"};

    public Character show() {
        System.out.print("[1]: Choose your hero name: ");
        String name = InputReader.readLine();

        System.out.println("[2]: Which type of hero do you want?");
        for (int i = 0; i < heroTypes.length; i++) { System.out.printf("\t[%d]: %s", i + 1, heroTypes[i]); }

        int typeChoice = InputReader.readInt(1, heroTypes.length, "/new/");
        String heroType = heroTypes[typeChoice - 1];

        return CharacterFactory.createHero(name, heroType);
    }
}
