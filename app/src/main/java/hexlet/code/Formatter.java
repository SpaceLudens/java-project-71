package hexlet.code;

import java.util.List;
import java.util.Map;

import static hexlet.code.formatters.Json.json;
import static hexlet.code.formatters.Plain.plain;
import static hexlet.code.formatters.Stylish.stylish;

public class Formatter {
    public static String formatter(List<Map<String, Object>> diffResult, String format) throws Exception {
        return switch (format) {
            case "stylish" -> stylish(diffResult);
            case "plain" -> plain(diffResult);
            case "json" -> json(diffResult);
            default -> throw new Exception("Unexpected value: " + format);
        };
    }

}
