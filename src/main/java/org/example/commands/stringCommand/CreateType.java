package org.example.commands.stringCommand;

public enum CreateType {
    FROM("FROM"),
    GENERATE("GENERATE"),
    RANDOM("RANDOM");

    public final String name;

    public static CreateType getTypeByName(String name) {
        for (var elem : values()) {
            if (elem.name.equalsIgnoreCase(name))
                return elem;
        }
        return null;
    }

    CreateType(String name) {
        this.name = name;
    }
}
