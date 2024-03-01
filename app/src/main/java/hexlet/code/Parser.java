package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parser(String filePath) throws Exception {
        Map<String, Object> map = new HashMap<>();
        ObjectMapper objectMapper;
        Path path = Paths.get(filePath).toAbsolutePath().normalize();

        if (Files.notExists(path)) {
            throw new Exception("File '" + path + " does not exist");
        }

        String content = Files.readString(path);
        boolean endsWithsJson = filePath.contains("json");
        boolean endsWithsYaml = filePath.contains("yaml") || filePath.contains("yml");

        if (endsWithsJson) {
            objectMapper = new ObjectMapper();
            map = objectMapper.readValue(content, new TypeReference<>() { });
        } else if (endsWithsYaml) {
            objectMapper = new YAMLMapper();
            map = objectMapper.readValue(content, new TypeReference<>() { });
        }
        return map;
    }
}
