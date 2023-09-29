package org.example.processors;

import org.example.SetStore;
import org.example.commands.CreateCommand;
import org.example.commands.stringCommand.CreateStringCommand;
import org.example.commands.stringCommand.CreateType;
import org.example.commands.stringCommand.StringCommand;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CreateCommandProcessor<E extends Integer> implements CommandParser<Integer> {


    private final Class<?> supportedClass = CreateStringCommand.class;

    private final SetStore<Integer> store;

    public CreateCommandProcessor(SetStore<Integer> store) {
        this.store = store;
    }

    @Override
    public CreateCommand<Integer> apply(StringCommand s) {
        CreateStringCommand createStringCommand = (CreateStringCommand) s;

        var list = createStringCommand.stringList();
        String name = list.get(0);
        CreateType createType = CreateType.getTypeByName(list.get(1));
        List<Integer> resList;
        List<Integer> univerList = store.getSet("universum").getMyElms();
        switch (Objects.requireNonNull(createType)) {
            case FROM -> {
                resList = list.subList(2, list.size()).stream().mapToInt(Integer::valueOf).filter(univerList::contains).sorted().boxed().toList();
            }
            case GENERATE -> {
                int from = Integer.parseInt(list.get(2));
                int to = Integer.parseInt(list.get(3));
                int turn = Integer.parseInt(list.get(4));
                resList = IntStream.iterate(from, (i) -> i  <= to,  (i) -> i + turn).filter(univerList::contains).sorted().boxed().toList();
            }
            case RANDOM -> {
                Random random = new Random(new Date().getTime());
                int from = Integer.parseInt(list.get(2));
                int to = Integer.parseInt(list.get(3));
                int count = Integer.parseInt(list.get(4));
                Set<Integer> taked = new HashSet<>();
                if (count > univerList.size())
                    throw new IllegalArgumentException();
                resList = Stream.generate(() -> random.nextInt(from, to))
                        .filter(univerList::contains)
                        .filter(Predicate.not(taked::contains))
                        .peek(taked::add)
                        .limit(count)
                        .sorted()
                        .toList();
            }
            default -> throw new UnsupportedOperationException();
        }


        return new CreateCommand<>(resList, name.toLowerCase());
    }
    @Override
    public boolean isSupportedClass(Class<?> clazz) {
        return clazz.equals(supportedClass);
    }
}
