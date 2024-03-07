package io.hexlet;

import static hexlet.code.Differ.generate;

import static io.hexlet.FixtureReader.readFromFile;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
public class ApplicationTest {
    @Test
    public void testStylishFormatterJson() throws Exception {
        String expected = readFromFile("src/test/resources/fixtures/stylish.txt");
        String actual = generate("src/test/resources/fixtures/file1.json",
                "src/test/resources/fixtures/file2.json", "stylish");
        assertEquals(expected, actual);
    }

    @Test
    public void testPlainFormatterJson() throws Exception {
        String expected = readFromFile("src/test/resources/fixtures/plain.txt");
        String actual = generate("src/test/resources/fixtures/file1.json",
                "src/test/resources/fixtures/file2.json", "plain");
        assertEquals(expected, actual);
    }

    @Test
    public void testJsonFormatterJson() throws Exception {
        String expected = readFromFile("src/test/resources/fixtures/json.txt");
        String actual = generate("src/test/resources/fixtures/file1.json",
                "src/test/resources/fixtures/file2.json", "json");
        assertEquals(expected, actual);
    }

    @Test
    public void testStylishFormatterYaml() throws Exception {
        String expected = readFromFile("src/test/resources/fixtures/stylish.txt");
        String actual = generate("src/test/resources/fixtures/file1.yaml",
                "src/test/resources/fixtures/file2.yaml", "stylish");
        assertEquals(expected, actual);
    }

    @Test
    public void testPlainFormatterYaml() throws Exception {
        String expected = readFromFile("src/test/resources/fixtures/plain.txt");
        String actual = generate("src/test/resources/fixtures/file1.yaml",
                "src/test/resources/fixtures/file2.yaml", "plain");
        assertEquals(expected, actual);
    }

    @Test
    public void testJsonFormatterYaml() throws Exception {
        String expected = readFromFile("src/test/resources/fixtures/json.txt");
        String actual = generate("src/test/resources/fixtures/file1.yaml",
                "src/test/resources/fixtures/file2.yaml", "json");
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateJson() throws Exception {
        String expected = readFromFile("src/test/resources/fixtures/stylish.txt");
        String actual = generate("src/test/resources/fixtures/file1.json",
                "src/test/resources/fixtures/file2.json");
        assertEquals(expected, actual);
    }

    @Test
    public void testGenerateYaml() throws Exception {
        String expected = readFromFile("src/test/resources/fixtures/stylish.txt");
        String actual = generate("src/test/resources/fixtures/file1.yaml",
                "src/test/resources/fixtures/file2.yaml");
        assertEquals(expected, actual);
    }
}
