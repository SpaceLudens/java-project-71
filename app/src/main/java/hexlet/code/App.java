package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.Callable;

import static hexlet.code.Differ.generate;

@Command(name = "gendiff",
        version = "1.0",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")

class App implements Callable {
    static Scanner scanner = new Scanner(System.in);
    static String nextLine = scanner.nextLine();
    Path filePath1 = Paths.get("src/main/java/resources/file1.json");
    Path absolutePath1 = filePath1.toAbsolutePath();
    String absolutePathString1 = absolutePath1.toString();
    Path filePath2 = Paths.get("src/main/java/resources/file2.json");
    Path absolutePath2 = filePath2.toAbsolutePath();
    String absolutePathString2 = absolutePath2.toString();

    @Parameters(index = "0", description = "path to first file", paramLabel = "filepath1")
    private File file1;
    @Parameters(index = "0", description = "path to second file", paramLabel = "filepath2")
    private File file2;
    @Option(names = {"-f", "--format"},
            description = "output format [default: stylish]",
            paramLabel = "format")

    @Override
    public Object call() throws Exception {
        if (nextLine.equals("file1.json file2.json")) {
            file1 = new File(absolutePathString1);
            file2 = new File(absolutePathString2);
            System.out.println(generate(file1, file2));
        }

        return null;
    }
    public static void main(String[] args) {
        new CommandLine(new App()).execute(nextLine);
    }
}