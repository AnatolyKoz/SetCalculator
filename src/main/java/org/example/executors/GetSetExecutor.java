package org.example.executors;

import org.example.SetStore;
import org.example.commands.Command;
import org.example.commands.GetCommand;

public class GetSetExecutor<E extends  Comparable<E>> implements SetExecutor<E> {

    private final Class<?> clazz = GetCommand.class;
    private final SetStore<E> store;

    public GetSetExecutor(SetStore<E> store) {
        this.store = store;
    }

    @Override
    public boolean isSupportedClass(Class<?> clazz) {
        return clazz.equals(this.clazz);
    }

    @Override
    public void accept(Command<E> command) {
        GetCommand<E> getCommand = (GetCommand<E>) command;
        for (var elem : store.getSet(getCommand.name()).getMyElms()) {
            System.out.print(elem + " ");
        }
        System.out.print("\n");

    }
}
