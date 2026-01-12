package es.ifoundthatx.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import es.ifoundthatx.data.DefenseData;
import es.ifoundthatx.models.Defense;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DefenseLoader {
    public static List<Defense> load(String path, String characterType) {
        Map<String, List<DefenseData>> map = JsonLoader.load(path, new TypeReference<Map<String, List<DefenseData>>>() {});

        List<DefenseData> dataList = map.get(characterType);
        if (dataList == null) return List.of();

        return dataList.stream()
                .map(Defense::new)
                .collect(Collectors.toList());
    }
}