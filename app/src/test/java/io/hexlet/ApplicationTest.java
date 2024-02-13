package io.hexlet;

import static hexlet.code.Differ.generate;
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

public class ApplicationTest {
    @Test
    public void testGenerateJson() throws Exception {
        var path1 = "src/test/resources/file1.json";
        var path2 = "src/test/resources/file2.json";
        var expected = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";
        var actual = generate(path1, path2);
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateYaml() throws Exception {
        var path1 = "src/test/resources/file1.yaml";
        var path2 = "src/test/resources/file2.yaml";
        var expected = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";
        var actual = generate(path1, path2);
        assertEquals(expected, actual);
    }
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
}
