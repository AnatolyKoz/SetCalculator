package org.example.inputSystem;

import org.example.commands.stringCommand.StringCommand;
import org.example.commands.stringCommand.UndefinedStringCommand;

import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class InputService implements Supplier<StringCommand> {
    private final Scanner scanner;

    private InputService(Scanner scanner) {
        this.scanner = scanner;
    }

    public static InputService of(Scanner scanner) {
        return new InputService(scanner);
    }

    @Override
    public StringCommand get() {
        return new UndefinedStringCommand(List.of(scanner.nextLine().split(" ")));
    }
}
