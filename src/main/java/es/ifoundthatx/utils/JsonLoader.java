package es.ifoundthatx.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.Map;
import java.util.List;

public class JsonLoader {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> Map<String, List<T>> load(String path, TypeReference<Map<String, List<T>>> type) {
        try (InputStream is = JsonLoader.class.getClassLoader().getResourceAsStream(path)) {
            if (is == null) { throw new RuntimeException("File not found: " + path); }
            return mapper.readValue(is, type);

        } catch (Exception e) { throw new RuntimeException("Error reading " + path, e); }
    }
}