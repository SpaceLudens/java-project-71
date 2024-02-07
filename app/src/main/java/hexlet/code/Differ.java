package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Differ {
    public static String generate (String filePath1, String filePath2) throws Exception {

        Path path1 = Paths.get(filePath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(filePath2).toAbsolutePath().normalize();

        if (!Files.exists(path1)) {
            throw new Exception("File '" + path1 + " does not exist");
        }
        if (!Files.exists(path2)) {
            throw new Exception("File '" + path2 + " does not exist");
        }

        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> fileMap1 = objectMapper.readValue(content1, new TypeReference<>() {});
        Map<String, Object> fileMap2 = objectMapper.readValue(content2, new TypeReference<>() {});

        Map<String, Object> sortedMap = new TreeMap<>(fileMap1);

        StringBuilder result = new StringBuilder();

        String res = "{\n";

        for(var entry : sortedMap.entrySet()) {
            if(fileMap2.containsKey(entry.getKey())) {
                if(fileMap2.containsValue(entry.getValue())) {
                    result
                            .append("  ")
                            .append(entry.getKey())
                            .append(": ").append(entry.getValue())
                            .append("\n");
                } else {
                    result
                            .append("- ")
                            .append(entry.getKey())
                            .append(": ")
                            .append(entry.getValue())
                            .append("\n");
                    result
                            .append("+ ")
                            .append(entry.getKey())
                            .append(": ")
                            .append(fileMap2.getOrDefault(entry.getKey(), ""))
                            .append("\n");
                }
            } else {
                result
                        .append("- ")
                        .append(entry.getKey())
                        .append(": ")
                        .append(entry.getValue())
                        .append("\n");
            }
        }

        for (var entry : fileMap2.entrySet()) {
            if(!sortedMap.containsKey(entry.getKey())) {
                result
                        .append("+ ")
                        .append(entry.getKey())
                        .append(": ")
                        .append(entry.getValue())
                        .append("\n");
            }
        }

        res = res + result + "}";

        return res;
    }

}
