package es.ifoundthatx.cli;

import es.ifoundthatx.db.HeroRepository;
import es.ifoundthatx.models.Character;
import es.ifoundthatx.models.HeroSummary;

import java.util.List;

public class ChooseHeroMenu {
    protected Character show() {
        final HeroRepository repository = new HeroRepository();
        final List<HeroSummary> heroes = repository.findAll();

        if (heroes.isEmpty()) { System.out.println("[ERROR]: You did not create or save any heroes!"); return null; }

        for (int i = 0; i < heroes.size(); i++) {
            HeroSummary hero = heroes.get(i);
            System.out.printf("[%d]: %s", i + 1, hero.getName());
        }

        int option = InputReader.readInt(1, heroes.size(), "/continue/");
        int heroId = heroes.get(option - 1).getId();

        return repository.loadById(heroId);
    }
}
