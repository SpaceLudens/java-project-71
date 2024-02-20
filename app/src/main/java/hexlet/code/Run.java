package hexlet.code;

import static hexlet.code.Differ.differ;
import static hexlet.code.Formatter.stylish;

public class Run {
    public static String run(String filePath1, String filePath2, String format) throws Exception {
        String result = null;
        if (format.equals("stylish")) {
            result = stylish(differ(filePath1, filePath2));
        }
        return result;
    }
}
