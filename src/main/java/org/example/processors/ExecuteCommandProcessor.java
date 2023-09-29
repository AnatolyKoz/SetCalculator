package org.example.processors;

import org.example.commands.Command;
import org.example.commands.ExecuteCommand;
import org.example.commands.stringCommand.CreateStringCommand;
import org.example.commands.stringCommand.ExecuteStringCommand;
import org.example.commands.stringCommand.StringCommand;

import java.util.function.Predicate;

public class ExecuteCommandProcessor<E extends  Comparable<E>> implements CommandParser<E> {
    private final Class<?> supportedClass = ExecuteStringCommand.class;

    private final ReversePolishProcessor reversePolishProcessor= new ReversePolishProcessor();
    @Override
    public boolean isSupportedClass(Class<?> clazz) {
        return supportedClass.equals(clazz);
    }

    @Override
    public Command<E> apply(StringCommand stringCommand) {

        var command = (ExecuteStringCommand)stringCommand;

        var list = command.stringList();

        return new ExecuteCommand<>(reversePolishProcessor.apply(list.subList(0, list.size() - 2).stream().filter(Predicate.not(String::isBlank)).toList()), list.get(list.size() - 1).toLowerCase());

    }
}
