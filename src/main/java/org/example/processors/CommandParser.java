package org.example.processors;

import org.example.commands.Command;
import org.example.commands.stringCommand.StringCommand;

import java.util.function.Function;

public interface CommandParser<E extends Comparable<E>> extends Function<StringCommand, Command<E>> {

    boolean isSupportedClass(Class<?> clazz);

}
