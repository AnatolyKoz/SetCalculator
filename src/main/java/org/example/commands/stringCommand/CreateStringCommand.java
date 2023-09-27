package org.example.commands.stringCommand;

import org.example.commands.stringCommand.StringCommand;

import java.util.List;

public record CreateStringCommand(List<String> stringList) implements StringCommand {

    public static final StringCommandType stringCommandType = StringCommandType.CREATE;
}
