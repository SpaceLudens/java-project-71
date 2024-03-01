package io.hexlet;

import static hexlet.code.Differ.generate;
import static hexlet.code.Parser.parser;
import static hexlet.code.formatters.Json.json;
import static hexlet.code.formatters.Plain.plain;
import static hexlet.code.formatters.Stylish.stylish;
import static io.hexlet.TestFixture.getList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class ApplicationTest {
    String pathJson1 = "src/test/resources/file1.json";
    String pathJson2 = "src/test/resources/file2.json";
    String pathJson3 = "src/test/resources/file3.json";
    String pathYaml1 = "src/test/resources/file1.yaml";
    @Test
    public void testParserJson() throws Exception {
        Path absolutePath = Paths.get(pathJson1).toAbsolutePath().normalize();
        String content = Files.readString(absolutePath).trim();
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> expected = objectMapper.readValue(content, new TypeReference<>() { });
        var actual = parser(pathJson1);
        assertEquals(expected, actual);

    }

    @Test
    public void testParserYaml() throws Exception {
        Path absolutePath = Paths.get(pathYaml1).toAbsolutePath().normalize();
        String content = Files.readString(absolutePath).trim();
        ObjectMapper objectMapper = new YAMLMapper();
        Map<String, Object> expected = objectMapper.readValue(content, new TypeReference<>() { });
        var actual = parser(pathYaml1);
        assertEquals(expected, actual);

    }
    @Test
    public void testStylishFormatter() {
        String expected = """
                {
                    chars1: [a, b, c]
                  - chars2: [d, e, f]
                  + chars2: false
                  - checked: false
                  + checked: true
                  - default: null
                  + default: [value1, value2]
                  - key1: value1
                  + key2: value2
                }""";
        String actual = stylish(getList());
        assertEquals(expected, actual);
    }

    @Test
    public void testPlainFormatter() {
        String expected = """
                Property 'chars2' was updated. From [complex value] to false
                Property 'checked' was updated. From false to true
                Property 'default' was updated. From null to [complex value]
                Property 'key1' was removed
                Property 'key2' was added with value: 'value2'""";
        String actual = plain(getList());
        assertEquals(expected, actual);
    }

    @Test
    public void testJsonFormatter() throws Exception {
        Path absolutePath = Paths.get(pathJson3).toAbsolutePath().normalize();
        String expected = Files.readString(absolutePath).trim();
        String actual = json(getList());
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateWithPlainFormatter() throws Exception {
        String expected = """
                Property 'chars2' was updated. From [complex value] to false
                Property 'checked' was updated. From false to true
                Property 'default' was updated. From null to [complex value]
                Property 'id' was updated. From 45 to null
                Property 'key1' was removed
                Property 'key2' was added with value: 'value2'
                Property 'numbers2' was updated. From [complex value] to [complex value]
                Property 'numbers3' was removed
                Property 'numbers4' was added with value: [complex value]
                Property 'obj1' was added with value: [complex value]
                Property 'setting1' was updated. From 'Some value' to 'Another value'
                Property 'setting2' was updated. From 200 to 300
                Property 'setting3' was updated. From true to 'none'""";
        String actual = generate(pathJson1, pathJson2, "plain");
        assertEquals(expected, actual);
    }
}
