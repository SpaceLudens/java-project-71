package io.hexlet;

import static hexlet.code.Differ.differ;
import static hexlet.code.Formatter.stylish;
import static hexlet.code.Parser.parser;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;

public class ApplicationTest {
    @Test
    public void testParserJson() throws Exception {
        var path = "src/test/resources/file1.json";
        Path absolutePath = Paths.get(path).toAbsolutePath().normalize();
        String content = Files.readString(absolutePath);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> expected = objectMapper.readValue(content, new TypeReference<>() { });
        var actual = parser(path);
        assertEquals(expected, actual);

    }

    @Test
    public void testParserYaml() throws Exception {
        var path = "src/test/resources/file1.yaml";
        Path absolutePath = Paths.get(path).toAbsolutePath().normalize();
        String content = Files.readString(absolutePath);
        ObjectMapper objectMapper = new YAMLMapper();
        Map<String, Object> expected = objectMapper.readValue(content, new TypeReference<>() { });
        var actual = parser(path);
        assertEquals(expected, actual);

    }
    @Test
    public void testStylishFormatter() throws Exception {
        var path1 = "src/test/resources/file1.json";
        var path2 = "src/test/resources/file2.json";
        String expected = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - id: 45
                  + id: null
                  - key1: value1
                  + key2: value2
                    numbers1: [1, 2, 3, 4]
                  - numbers2: [2, 3, 4, 5]
                  + numbers2: [22, 33, 44, 55]
                  - numbers3: [3, 4, 5]
                  + numbers4: [4, 5, 6]
                  + obj1: {nestedKey=value, isNested=true}
                  - setting1: Some value
                  + setting1: Another value
                  - setting2: 200
                  + setting2: 300
                  - setting3: true
                  + setting3: none
                }""";
        String actual = stylish(differ(path1, path2));
        assertEquals(expected, actual);
    }

    @Test
    public void testDiffer() throws Exception {
        var path1 = "src/test/resources/file3.json";
        var path2 = "src/test/resources/file4.json";
        List<Map<String, Object>> expected = new ArrayList<>();
        Map<String, Object> innerMap = new LinkedHashMap<>();
        innerMap.put("follow", false);
        innerMap.put("changes", "  - ");
        innerMap.put("key", "follow");
        innerMap.put("oldValue", false);
        innerMap.put("newValue", false);
        expected.add(innerMap);
        innerMap = new LinkedHashMap<>();
        innerMap.put("timeout", 20);
        innerMap.put("changes", "  + ");
        innerMap.put("key", "timeout");
        innerMap.put("oldValue", 20);
        innerMap.put("newValue", 20);
        expected.add(innerMap);
        var actual = differ(path1, path2);
        assertEquals(expected, actual);
    }
}
