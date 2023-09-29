package org.example.executors;

import org.example.SetStore;
import org.example.commands.Command;
import org.example.commands.CreateCommand;
import org.example.domain.MySet;

import java.util.List;


public class CreateSetExecutor<E extends Comparable<E>> implements SetExecutor<E> {
    static final Class<?> SUPPORTED_COMMAND = CreateCommand.class;

    private final SetStore<E> store;

    public CreateSetExecutor(SetStore<E> store) {
        this.store = store;
    }

    @Override
    public void accept(Command<E> es) {

        if (!(es instanceof CreateCommand))
            throw new UnsupportedOperationException();

        CreateCommand<E> command = (CreateCommand<E>) es;


        store.setSet(command.name(), MySet.of((command.list())));
    }

    @Override
    public boolean isSupportedClass(Class<?> clazz) {
        return SUPPORTED_COMMAND.equals(clazz);
    }
}
