package org.example.processors;

import org.example.commands.CreateCommand;
import org.example.commands.stringCommand.CreateStringCommand;

import java.util.function.Function;

public class CreateCommandProcessor<E extends Comparable<E>> implements Function<CreateStringCommand, CreateCommand<E>> {

    @Override
    public CreateCommand<E> apply(CreateStringCommand createStringCommand) {
        return null;
    }
}
