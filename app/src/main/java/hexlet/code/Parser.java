package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;
import java.util.TreeMap;

public class Parser {
    public static Map<String, Object> parser(String data, String format) throws Exception {
        Map<String, Object> result = new TreeMap<>();
        ObjectMapper objectMapper;
        if (format.equalsIgnoreCase("json")) {
            objectMapper = new ObjectMapper();
            result = objectMapper.readValue(data, new TypeReference<>() { });
        } else if (format.equalsIgnoreCase("yaml") || format.equalsIgnoreCase("yml")) {
            objectMapper = new YAMLMapper();
            result = objectMapper.readValue(data, new TypeReference<>() { });
        }
        return result;
    }
}
