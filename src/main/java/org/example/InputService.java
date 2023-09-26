package org.example;

import java.util.Scanner;
import java.util.function.Supplier;

public class InputService implements Supplier<String> {

    private final Scanner scanner;

    private InputService(Scanner scanner) {
        this.scanner = scanner;
    }

    public static InputService of(Scanner scanner) {
        return new InputService(scanner);
    }

    @Override
    public String get() {
        return scanner.nextLine();
    }
}
