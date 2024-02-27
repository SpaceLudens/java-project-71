package hexlet.code;

import java.util.List;
import java.util.Map;

import static hexlet.code.formatters.Plain.plain;
import static hexlet.code.formatters.Stylish.stylish;

public class Formatter {
    public static String formatter(List<Map<String, Object>> diffResult, String format) {
        if (format.equals("stylish")) {
            return stylish(diffResult);
        } else if (format.equals("plain")) {
            return plain(diffResult);
        }
        return null;
    }

}
