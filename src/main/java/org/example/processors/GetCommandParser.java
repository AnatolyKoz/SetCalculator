package org.example.processors;

import org.example.commands.Command;
import org.example.commands.GetCommand;
import org.example.commands.stringCommand.CreateStringCommand;
import org.example.commands.stringCommand.GetStringCommand;
import org.example.commands.stringCommand.StringCommand;

public class GetCommandParser<E extends Comparable<E>> implements CommandParser<E>{

    private final Class<?> supportedClass = GetStringCommand.class;
    @Override
    public boolean isSupportedClass(Class<?> clazz) {
        return supportedClass.equals(clazz);
    }

    @Override
    public Command<E> apply(StringCommand stringCommand) {
        GetStringCommand getStringCommand = (GetStringCommand) stringCommand;
        return new GetCommand<>(getStringCommand.name().toLowerCase());
    }
}
