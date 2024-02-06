package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class Differ {
    public static String generate (File file1, File file2) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> fileMap1 = objectMapper.readValue(file1, new TypeReference<>() {});
        Map<String, Object> fileMap2 = objectMapper.readValue(file2, new TypeReference<>() {});

        Map<String, Object> sortedMap = new TreeMap<>(fileMap1);
        StringBuilder result = new StringBuilder();
        String res = "{\n";

        for(var entry : sortedMap.entrySet()) {
            if(fileMap2.containsKey(entry.getKey())) {
                if(fileMap2.containsValue(entry.getValue())) {
                    result.append("  ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
                } else {
                    result.append("- ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
                    result.append("+ ").append(entry.getKey()).append(": ").append(fileMap2.getOrDefault(entry.getKey(), "")).append("\n");
                }
            } else {
                result.append("- ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }
        }

        for (var entry : fileMap2.entrySet()) {
            if(!sortedMap.containsKey(entry.getKey())) {
                result.append("+ ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }
        }

        res = res + result + "}";

        return res;
    }

}
