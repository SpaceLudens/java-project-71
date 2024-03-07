package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

import static hexlet.code.Formatter.formatter;
import static hexlet.code.Parser.parser;
import static hexlet.code.TreeBuilder.treeBuilder;

public class Differ {
    public static String readContent(String filePath) throws Exception {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();

        if (Files.notExists(path)) {
            throw new Exception("File '" + path + " does not exist");
        }

        return Files.readString(path);
    }

    public static String detectFormat(String filePath) {
        var array = filePath.split("\\.");
        String format = null;
        if (array[array.length - 1].equalsIgnoreCase("json")) {
            format = "json";
        } else if (array[array.length - 1].equalsIgnoreCase("yaml")
                   || array[array.length - 1].equalsIgnoreCase("yml")) {
            format = "yaml";
        }
        return format;
    }

    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        String data1 = readContent(filePath1);
        String data2 = readContent(filePath2);

        String format1 = detectFormat(filePath1);
        String format2 = detectFormat(filePath2);

        Map<String, Object> map1 = new TreeMap<>(parser(data1, format1));
        Map<String, Object> map2 = new TreeMap<>(parser(data2, format2));

        return formatter(treeBuilder(map1, map2), format);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}
