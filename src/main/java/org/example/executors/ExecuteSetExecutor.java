package org.example.executors;

import org.example.SetStore;
import org.example.commands.Command;
import org.example.commands.ExecuteCommand;
import org.example.domain.MySet;

import java.util.Stack;


public class ExecuteSetExecutor<E extends Comparable<E>> implements SetExecutor<E> {
    static final Class<?> SUPPORTED_COMMAND = ExecuteCommand.class;
    private final SetStore<E> store;

    public ExecuteSetExecutor(SetStore<E> store) {
        this.store = store;
    }

    @Override
    public void accept(Command<E> es) {

        if (!(es instanceof ExecuteCommand<E> executeCommand))
            throw new UnsupportedOperationException();

        Stack<MySet<E>> stack = new Stack<>();

        for (var command : executeCommand.commandsToExecute()) {
            if (command.length() > 1) {
                stack.add(store.getSet(command));
                continue;
            }

            var symbol = command.charAt(0);

            if (symbol == '!') {
                var result = MySet.subtract(stack.pop(), store.getSet("universum"));
                stack.add(result);
            }
            else if (symbol == '&'){
                var result = MySet.union(stack.pop(), stack.pop());
                stack.add(result);
            }
            else if (symbol == '|') {
                var result = MySet.cross(stack.pop(), stack.pop());
                stack.add(result);
            }
            else if (symbol == '/') {
                var result = MySet.cross(stack.pop(), stack.pop());
                stack.add(result);
            }
            else {
                throw new UnsupportedOperationException();
            }

        }

        store.setSet(executeCommand.resultName(), stack.pop());
    }

    @Override
    public boolean isSupportedClass(Class<?> clazz) {
        return SUPPORTED_COMMAND.equals(clazz);
    }


}
