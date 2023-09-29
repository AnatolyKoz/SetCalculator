package org.example.processors;

import org.example.commands.Command;
import org.example.commands.stringCommand.StringCommand;
import org.example.executors.SetExecutor;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ChainCommandRouter<E extends Comparable<E>>  implements CommandParserRouter<E>{


    private final Set<Class<?>> supportedClasses = new HashSet<>();
    private final List<CommandParser<E>> executorList = new LinkedList<>();

    @Override
    public  Command<E> apply(StringCommand command) {
        for (var executor : executorList) {
            if (executor.isSupportedClass(command.getClass())) {
                return executor.apply(command);
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isSupportedClass(Class<?> clazz) {
        return supportedClasses.contains(clazz);
    }

    @Override
    public boolean addProcessor(Class<?> command, CommandParser<E> executor) {
        if (supportedClasses.contains(command))
            throw new IllegalArgumentException();
        supportedClasses.add(command);
        executorList.add(executor);
        return true;
    }
}
