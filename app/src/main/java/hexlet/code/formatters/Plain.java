package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String plain(List<Map<String, Object>> list) {
        StringBuilder result = new StringBuilder();

        for (var map : list) {
            String key = (String) map.get("key");
            String changes = (String) map.get("changes");
            var oldValue =  formatMapValue(map.get("oldValue"));
            var newValue = formatMapValue(map.get("newValue"));

            if (map.containsKey("changes")) {
                result.append("Property '")
                        .append(key)
                        .append("' was ")
                        .append(map.get("changes"));
                if (changes.equals("updated")) {
                    result.append(". From ");
                    result.append(oldValue)
                            .append(" to ")
                            .append(newValue)
                            .append("\n");
                } else if (changes.equals("added")) {
                    result.append(" with value: ")
                            .append(oldValue)
                            .append("\n");
                } else {
                    result.append("\n");
                }
            }
        }
        return String.valueOf(result).trim();
    }

    public static String formatMapValue(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        } else if (value != null && !(value instanceof Boolean) && !(value instanceof Integer)) {
            return  "[complex value]";
        } else {
            return String.valueOf(value);
        }
    }
}
