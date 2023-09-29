package org.example.inputSystem.inputDataProcessor;

import org.example.commands.stringCommand.CreateStringCommand;
import org.example.commands.stringCommand.StringCommand;
import org.example.commands.stringCommand.StringCommandType;
import org.example.commands.stringCommand.UndefinedStringCommand;

public class CreateStringCommandProcessor implements  InputDataProcessor {


    private final StringCommandType stringCommandType = StringCommandType.CREATE;
    @Override
    public boolean isSupportedType(StringCommandType type) {
        return type.equals(stringCommandType);
    }
    @Override
    public StringCommand apply(UndefinedStringCommand stringCommand) {
        return new CreateStringCommand(stringCommand.stringList().subList(1, stringCommand.stringList().size()));
    }
}
