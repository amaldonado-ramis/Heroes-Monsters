package es.ifoundthatx.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.ifoundthatx.data.AttackData;
import es.ifoundthatx.models.Attack;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class AttackLoader {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static List<Attack> load(String path, String characterType) {
        try (InputStream is = AttackLoader.class.getClassLoader().getResourceAsStream(path)) {
            if (is == null) throw new RuntimeException("[ERROR]: File not found: " + path);

            Map<String, List<Map<String, Object>>> data = mapper.readValue(is, new TypeReference<>() {});
            if (!data.containsKey(characterType)) {
                throw new RuntimeException("[ERROR]: No attacks found for character type: " + characterType);
            }
            List<Map<String, Object>> attacksData = data.get(characterType);

            return attacksData.stream().map(AttackLoader::mapToAttack).toList();
        } catch (Exception e) { throw new RuntimeException("[ERROR]: Error reading " + path, e); }
    }

    private static Attack mapToAttack(Map<String, Object> map) {
        String name = (String) map.get("name");

        int normalMin = (Integer) map.get("normalMin");
        int normalMax = (Integer) map.get("normalMax");
        int criticalMin = (Integer) map.get("criticalMin");
        int criticalMax = (Integer) map.get("criticalMax");

        double criticalChance = ((Number) map.get("criticalChance")).doubleValue();
        double effectChance = ((Number) map.get("effectChance")).doubleValue();

        AttackData data = new AttackData(
                name,
                normalMin, normalMax,
                criticalMin, criticalMax,
                criticalChance, effectChance
        );

        return new Attack(data);
    }
}
