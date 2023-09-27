package org.example.commands.stringCommand;

import java.util.List;

public record UndefinedStringCommand(List<String> stringList) implements StringCommand {

}
