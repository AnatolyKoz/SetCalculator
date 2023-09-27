package org.example.inputSystem.inputDataProcessor;

import org.example.commands.stringCommand.*;

public class ExecuteStringCommandProcessor implements InputDataProcessor{

    private final StringCommandType stringCommandType = StringCommandType.EXECUTE;
    @Override
    public boolean isSupportedType(StringCommandType type) {
        return type.equals(stringCommandType);
    }

    @Override
    public StringCommand apply(UndefinedStringCommand stringCommand) {
        return new ExecuteStringCommand(stringCommand.stringList());
    }
}
