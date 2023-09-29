package org.example.processors;

import org.example.commands.stringCommand.StringCommandType;
import org.example.inputSystem.inputDataProcessor.InputDataProcessor;

public interface CommandParserRouter<E extends Comparable<E>> extends CommandParser<E> {
    boolean addProcessor(Class<?> clazz, CommandParser<E> executor);

}
