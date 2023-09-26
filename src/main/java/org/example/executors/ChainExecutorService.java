package org.example.executors;

import org.example.commands.Command;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ChainExecutorService<E extends Comparable<E>> implements SetExecutor<E>, ExecutorService<E>{

    private final Set<Class<?>> supportedClasses = new HashSet<>();
    private final List<SetExecutor<E>> executorList = new LinkedList<>();

    @Override
    public void accept(Command<E> eCommand) {
        for (var executor : executorList) {
            if (executor.isSupportedClass(eCommand.getClass())) {
                executor.accept(eCommand);
                break;
            }
        }
    }

    @Override
    public boolean isSupportedClass(Class<?> clazz) {
        return supportedClasses.contains(clazz);
    }

    @Override
    public boolean addExecutor(Command<E> command, SetExecutor<E> executor) {
        if (supportedClasses.contains(command.getClass()))
            throw new IllegalArgumentException();
        supportedClasses.add(command.getClass());
        executorList.add(executor);
        return true;
    }
}
