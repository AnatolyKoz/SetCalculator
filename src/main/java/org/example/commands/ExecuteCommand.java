package org.example.commands;

import org.example.domain.MySet;

import java.util.List;
import java.util.function.Function;

public record ExecuteCommand<E extends  Comparable<E>>
        (List<String> commandsToExecute, String resultName)  implements Command<E> {
}
