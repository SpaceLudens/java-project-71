package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String stylish(List<Map<String, Object>> list) {
        StringBuilder result = new StringBuilder();
        result.append("{\n");
        for (var map : list) {
            String key = (String) map.get("key");
            var oldValue = map.get("oldValue");
            var newValue = map.get("newValue");
            if (map.containsKey("changes")) {
                if (map.get("changes").equals("updated")) {
                    result.append("  - ").append(key).append(": ").append(oldValue).append("\n");
                    result.append("  + ").append(key).append(": ").append(newValue).append("\n");
                } else if (map.get("changes").equals("added")) {
                    result.append("  + ").append(key).append(": ").append(oldValue).append("\n");
                } else if (map.get("changes").equals("removed")) {
                    result.append("  - ").append(key).append(": ").append(oldValue).append("\n");
                } else {
                    result.append("    ").append(key).append(": ").append(oldValue).append("\n");
                }
            }
        }
        return String.valueOf(result + "}");
    }
}
