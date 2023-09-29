package org.example.inputSystem;

import org.example.commands.stringCommand.UndefinedStringCommand;

import java.util.List;
import java.util.Scanner;

public class ConsoleInputService  implements InputService {
    private final Scanner scanner;

    private ConsoleInputService(Scanner scanner) {
        this.scanner = scanner;
    }

    public static InputService of(Scanner scanner) {
        return new ConsoleInputService(scanner);
    }

    @Override
    public UndefinedStringCommand get() {
        return new UndefinedStringCommand(List.of(scanner.nextLine().split(" ")));
    }
}
