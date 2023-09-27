package org.example.commands.stringCommand;

public enum StringCommandType {
    CREATE("CREATE"),
    EXECUTE("EXECUTE"),
    GET("GET");

    public final String name;

    public StringCommandType getTypeByName(String name) {
        for (var elem : values()) {
            if (elem.name.equalsIgnoreCase(name))
                return elem;
        }
        return null;
    }

    StringCommandType(String name) {
        this.name = name;
    }
}
