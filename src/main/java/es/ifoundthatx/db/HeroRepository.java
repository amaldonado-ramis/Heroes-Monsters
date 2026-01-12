package es.ifoundthatx.db;

import es.ifoundthatx.models.Attack;
import es.ifoundthatx.models.Character;
import es.ifoundthatx.models.Defense;
import es.ifoundthatx.models.HeroSummary;
import es.ifoundthatx.utils.AttackLoader;
import es.ifoundthatx.utils.DefenseLoader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroRepository {
    public void save(Character hero) {
        String sql = """
            INSERT INTO heroes (name, type, max_hp, current_hp)
            VALUES (?, ?, ?, ?)
        """;

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, hero.getName());
            stmt.setString(2, hero.getType());
            stmt.setDouble(3, hero.getMaxHp());
            stmt.setDouble(4, hero.getCurrentHp());

            stmt.executeUpdate();

        } catch (Exception e) { e.printStackTrace(); }
    }

    public List<HeroSummary> findAll() {
        List<HeroSummary> heroes = new ArrayList<>();
        String sql = "SELECT id, name, type, current_hp, max_hp FROM heroes";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                heroes.add(new HeroSummary(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getDouble("current_hp"),
                        rs.getDouble("max_hp")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }

        return heroes;
    }

    public Character loadById(int heroId) {
        String sql = "SELECT * FROM heroes WHERE id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, heroId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                List<Attack> attacks = AttackLoader.load("data/heroes_attacks.json", rs.getString("type"));
                List<Defense> defenses = DefenseLoader.load("data/heroes_defenses.json", rs.getString("type"));
                Character hero = new Character(
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getDouble("max_hp"),
                        rs.getDouble("current_hp")
                );

                hero.setAttacks(attacks);
                hero.setDefenses(defenses);

                return hero;
            }

        } catch (SQLException e) { e.fillInStackTrace(); } catch (Exception e) { throw new RuntimeException(e); }

        return null;
    }
}
