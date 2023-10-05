package org.example;

import org.example.commands.CreateCommand;
import org.example.commands.ExecuteCommand;
import org.example.commands.GetCommand;
import org.example.commands.stringCommand.CreateStringCommand;
import org.example.commands.stringCommand.ExecuteStringCommand;
import org.example.commands.stringCommand.GetStringCommand;
import org.example.commands.stringCommand.StringCommandType;
import org.example.domain.MySet;
import org.example.executors.*;
import org.example.inputSystem.ConsoleInputService;
import org.example.inputSystem.InputService;
import org.example.inputSystem.inputDataProcessor.*;
import org.example.processors.*;

import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.IntStream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        InputService inputService = ConsoleInputService.of(scanner);

        InputDataRouter inputDataProcessor = new ChainInputDataRouter();
        inputDataProcessor.addProcessor(StringCommandType.CREATE, new CreateStringCommandProcessor());
        inputDataProcessor.addProcessor(StringCommandType.EXECUTE, new ExecuteStringCommandProcessor());
        inputDataProcessor.addProcessor(StringCommandType.GET, new GetStringCommandProcessor());

        SetStore<Integer> store = new SetStore<>(new HashMap<>());

        CommandParserRouter<Integer> commandParserRouter = new ChainCommandRouter<>();
        commandParserRouter.addProcessor(CreateStringCommand.class, new CreateCommandProcessor<Integer>(store));
        commandParserRouter.addProcessor(ExecuteStringCommand.class, new ExecuteCommandProcessor<>());
        commandParserRouter.addProcessor(GetStringCommand.class, new GetCommandParser<>());

        store.setSet("universum", MySet.of(IntStream.rangeClosed(1, 100).boxed().toList()));
        ExecutorService<Integer> executorService = new ChainExecutorService<>();
        executorService.addExecutor(CreateCommand.class,  new CreateSetExecutor<>(store));
        executorService.addExecutor(ExecuteCommand.class, new ExecuteSetExecutor<>(store));
        executorService.addExecutor(GetCommand.class, new GetSetExecutor<>(store));

        App<Integer> app = new App<>(inputService,inputDataProcessor, commandParserRouter, executorService);
        app.run();

    }
}