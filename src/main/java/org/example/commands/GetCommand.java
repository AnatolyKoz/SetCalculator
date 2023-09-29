package org.example.commands;

import java.util.List;

public record GetCommand <E extends  Comparable<E>>
        (String name)  implements Command<E> {
}
