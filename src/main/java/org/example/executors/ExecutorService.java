package org.example.executors;

import org.example.commands.Command;

public interface ExecutorService<E extends Comparable<E>> extends SetExecutor<E> {

    boolean addExecutor(Class<?> clazz, SetExecutor<E> executor);
}
