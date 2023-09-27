package org.example.inputSystem.inputDataProcessor;

import org.example.commands.stringCommand.StringCommand;
import org.example.commands.stringCommand.StringCommandType;
import org.example.commands.stringCommand.UndefinedStringCommand;

import java.util.List;
import java.util.function.Function;

public interface InputDataProcessor extends Function<UndefinedStringCommand, StringCommand> {
    boolean isSupportedType(StringCommandType type);

}
