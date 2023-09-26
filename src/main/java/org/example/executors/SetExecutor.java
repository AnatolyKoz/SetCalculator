package org.example.executors;

import org.example.commands.Command;

import java.util.Set;
import java.util.function.Consumer;

public interface SetExecutor<E extends  Comparable<E>> extends Consumer<Command<E>> {

    boolean isSupportedClass(Class<?> clazz);

}
