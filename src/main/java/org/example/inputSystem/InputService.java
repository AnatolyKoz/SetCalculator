package org.example.inputSystem;

import org.example.commands.stringCommand.UndefinedStringCommand;

import java.util.function.Supplier;

public interface InputService extends Supplier<UndefinedStringCommand> {
}
