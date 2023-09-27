package org.example.inputSystem.inputDataProcessor;

import org.example.commands.stringCommand.StringCommand;
import org.example.commands.stringCommand.UndefinedStringCommand;

import java.util.function.Function;

public interface InputDataRouter extends Function<UndefinedStringCommand, StringCommand> {
}
