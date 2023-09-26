package org.example.commands;

import java.util.List;

public record CreateCommand<E extends  Comparable<E>>
        (List<E> list, String name)  implements Command<E> {
}
