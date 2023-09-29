package org.example.commands.stringCommand;

import java.util.List;

public record GetStringCommand(String name) implements StringCommand {

    public static final StringCommandType stringCommandType = StringCommandType.GET;

}
