package org.example.inputSystem.inputDataProcessor;

import org.example.commands.stringCommand.GetStringCommand;
import org.example.commands.stringCommand.StringCommand;
import org.example.commands.stringCommand.StringCommandType;
import org.example.commands.stringCommand.UndefinedStringCommand;

public class GetStringCommandProcessor implements InputDataProcessor{
    private final StringCommandType stringCommandType = StringCommandType.GET;

    @Override
    public boolean isSupportedType(StringCommandType type) {
        return stringCommandType.equals(type);
    }

    @Override
    public StringCommand apply(UndefinedStringCommand undefinedStringCommand) {
        return new GetStringCommand(undefinedStringCommand.stringList());
    }
}
