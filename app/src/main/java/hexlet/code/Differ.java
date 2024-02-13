package hexlet.code;

import java.util.Map;
import java.util.TreeMap;

import static hexlet.code.Parser.parser;


public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {
        Map<String, Object> fileMap1 = parser(filePath1);
        Map<String, Object> fileMap2 = parser(filePath2);
        Map<String, Object> sortedMap = new TreeMap<>(fileMap1);

        StringBuilder result = new StringBuilder();

        result.append("{\n");

        for (var entry : sortedMap.entrySet()) {
            if (fileMap2.containsKey(entry.getKey())) {
                if (fileMap2.containsValue(entry.getValue())) {
                    result
                            .append("    ")
                            .append(entry.getKey())
                            .append(": ").append(entry.getValue())
                            .append("\n");
                } else {
                    result
                            .append("  - ")
                            .append(entry.getKey())
                            .append(": ")
                            .append(entry.getValue())
                            .append("\n");
                    result
                            .append("  + ")
                            .append(entry.getKey())
                            .append(": ")
                            .append(fileMap2.getOrDefault(entry.getKey(), ""))
                            .append("\n");
                }
            } else {
                result
                        .append("  - ")
                        .append(entry.getKey())
                        .append(": ")
                        .append(entry.getValue())
                        .append("\n");
            }
        }

        for (var entry : fileMap2.entrySet()) {
            if (!sortedMap.containsKey(entry.getKey())) {
                result
                        .append("  + ")
                        .append(entry.getKey())
                        .append(": ")
                        .append(entry.getValue())
                        .append("\n");
            }
        }

        result.append("}");
        return String.valueOf(result);
    }
}
