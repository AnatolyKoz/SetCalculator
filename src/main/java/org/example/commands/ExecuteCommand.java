package org.example.commands;

import java.util.List;

public record ExecuteCommand<E extends  Comparable<E>>
        (List<E> list, String name)  implements Command<E> {
}
