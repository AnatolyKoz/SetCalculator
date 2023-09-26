package org.example.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySetTest {

    @Test
    void union() {
        MySet<Integer> firstSet = MySet.of(List.of(1, 2, 3, 5, 7));
        MySet<Integer> secondSet = MySet.of(List.of(1, 2, 4, 6, 7));
        MySet<Integer> resultSet = MySet.union(firstSet, secondSet);

        MySet<Integer> expectedSet = MySet.of(List.of(1, 2, 3, 4, 5, 6, 7));


        assertEquals(resultSet, expectedSet);
    }

    @Test
    void cross() {

        MySet<Integer> firstSet = MySet.of(List.of(1, 2, 3, 5, 7));
        MySet<Integer> secondSet = MySet.of(List.of(1, 2, 4, 6, 7));
        MySet<Integer> resultSet = MySet.cross(firstSet, secondSet);

        MySet<Integer> expectedSet = MySet.of(List.of(1, 2, 7));


        assertEquals(resultSet, expectedSet);
    }

    @Test
    void subtract() {
        MySet<Integer> firstSet = MySet.of(List.of(1, 2, 3, 5, 7, 9));
        MySet<Integer> secondSet = MySet.of(List.of(1, 2, 4, 6, 7, 8));
        MySet<Integer> resultSet = MySet.subtract(firstSet, secondSet);

        MySet<Integer> expectedSet = MySet.of(List.of(3, 5, 9));


        assertEquals(resultSet, expectedSet);
    }
}