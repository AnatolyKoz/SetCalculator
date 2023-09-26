package org.example.executors;

import org.example.commands.Command;
import org.example.commands.ExecuteCommand;


public class ExecuteSetExecutor<E extends Comparable<E>> implements SetExecutor<E> {
    static final Class<?> SUPPORTED_COMMAND = ExecuteCommand.class;
    @Override
    public void accept(Command<E> es) {

        if (!(es instanceof ExecuteCommand))
            throw new UnsupportedOperationException();

        ExecuteCommand<E> command = (ExecuteCommand<E>) es;
    }

    @Override
    public boolean isSupportedClass(Class<?> clazz) {
        return SUPPORTED_COMMAND.equals(clazz);
    }


}
