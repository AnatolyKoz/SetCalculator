package org.example.commands.stringCommand;

import java.util.List;

public record GetStringCommand(List<String> stringList) implements StringCommand {

    public static final StringCommandType stringCommandType = StringCommandType.GET;

}
