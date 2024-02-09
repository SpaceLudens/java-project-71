package io.hexlet;

import static hexlet.code.Differ.generate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ApplicationTest {
    @Test
    public void testGenerate() throws Exception {
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
        assertEquals(actual,expected);
    }
}
