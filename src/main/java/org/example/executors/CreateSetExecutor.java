package org.example.executors;

import org.example.commands.Command;
import org.example.commands.CreateCommand;


public class CreateSetExecutor<E extends Comparable<E>> implements SetExecutor<E> {
    static final Class<?> SUPPORTED_COMMAND = CreateCommand.class;
    @Override
    public void accept(Command<E> es) {

        if (!(es instanceof CreateCommand))
            throw new UnsupportedOperationException();

        CreateCommand<E> command = (CreateCommand<E>) es;
    }

    @Override
    public boolean isSupportedClass(Class<?> clazz) {
        return SUPPORTED_COMMAND.equals(clazz);
    }
}
