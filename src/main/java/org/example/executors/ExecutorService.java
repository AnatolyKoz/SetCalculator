package org.example.executors;

import org.example.commands.Command;

public interface ExecutorService<E extends Comparable<E>> {

    boolean addExecutor(Command<E> command, SetExecutor<E> executor);
}
