package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

import static hexlet.code.Differ.generate;

@Command(name = "gendiff",
        version = "1.0",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")

class App implements Callable<Integer> {
    @Parameters(index = "0",
            description = "path to first file",
            paramLabel = "filepath1")
    private String filePath1;
    @Parameters(index = "1",
            description = "path to second file",
            paramLabel = "filepath2")
    private String filePath2;
    @Option(names = {"-f", "--format"},
            description = "output format [default: stylish]",
            paramLabel = "format")
    String format;
    @Override
    public Integer call() throws Exception {
        System.out.println(generate(filePath1, filePath2));
        return null;
    }
    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }
}