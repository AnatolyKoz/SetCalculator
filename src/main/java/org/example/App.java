package org.example;

import org.example.commands.Command;
import org.example.commands.CreateCommand;
import org.example.commands.stringCommand.StringCommand;
import org.example.executors.SetExecutor;
import org.example.inputSystem.InputService;
import org.example.inputSystem.inputDataProcessor.InputDataProcessor;
import org.example.inputSystem.inputDataProcessor.InputDataRouter;
import org.example.processors.CommandParser;
import org.example.processors.CreateCommandProcessor;

import java.io.InputStream;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class App<E extends Comparable<E>> {
    private final InputService inputService;
    private final InputDataProcessor inputDataProcessor;
    private final CommandParser<E> commandParser;
    private final SetExecutor<E> setExecutor;
    public App(InputService inputService, InputDataProcessor inputDataProcessor,
               CommandParser<E> commandParser, SetExecutor<E> setExecutor) {
        this.inputDataProcessor = inputDataProcessor;
        this.inputService = inputService;
        this.commandParser = commandParser;
        this.setExecutor = setExecutor;
    }

    public void run() {
        Stream.generate(inputService).map(inputDataProcessor).map(commandParser).forEach(setExecutor);
    }
}
