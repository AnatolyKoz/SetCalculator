package org.example.inputSystem.inputDataProcessor;

import org.example.commands.stringCommand.StringCommand;
import org.example.commands.stringCommand.StringCommandType;
import org.example.commands.stringCommand.UndefinedStringCommand;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ChainInputDataRouter implements InputDataRouter {
    private final Set<StringCommandType> supportedCommand = new HashSet<>();
    private final List<InputDataProcessor> processorsList = new LinkedList<>();
    @Override
    public boolean addProcessor(StringCommandType command, InputDataProcessor executor) {
        if (supportedCommand.contains(command))
            throw new IllegalArgumentException("Bad");
        supportedCommand.add(command);
        processorsList.add(executor);
        return true;
    }

    @Override
    public StringCommand apply(UndefinedStringCommand undefinedStringCommand) {
        for (var processor : processorsList) {
            if (processor.isSupportedType(StringCommandType.getTypeByName(undefinedStringCommand.stringList().get(0)))) {
                return processor.apply(undefinedStringCommand);
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isSupportedType(StringCommandType type) {
        return supportedCommand.contains(type);
    }
}
