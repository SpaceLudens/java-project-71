package hexlet.code;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String stylish(List<Map<String, Object>> list) {
        StringBuilder result = new StringBuilder();
        result.append("{\n");
        for (var map : list) {
            String changes = (String) map.get("changes");
            String key = (String) map.get("key");
            var value = map.get("oldValue");
            result.append(changes).append(key).append(": ").append(value).append("\n");
        }
        return String.valueOf(result + "}");
    }
}
