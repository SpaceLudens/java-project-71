package hexlet.code;

import picocli.CommandLine;

public class Differ {
    public static void main(String[] args) {
        new CommandLine(new HelloCommand()).execute(args);
    }
}

@CommandLine.Command(name = "gendiff", version = "1.0", mixinStandardHelpOptions = true,
description = "Compares two configuration files and shows a difference")
class HelloCommand implements Runnable {
    @Override
    public void run() {

    }
}