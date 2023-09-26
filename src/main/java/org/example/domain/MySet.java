package org.example.domain;

import java.util.ArrayList;
import java.util.List;

public class MySet<E extends Comparable<E>> {

    private List<E> myElems;


    private MySet(List<E> myElems) {
        var copyList = new ArrayList<>(myElems);
        copyList.sort(E::compareTo);
        this.myElems = copyList;
    }

    static <E extends Comparable<E>> MySet<E> of(List<E> list) {
        return new MySet<>(list);
    }


    static <E extends Comparable<E>> MySet<E> union(MySet<E> oneSet, MySet<E> twoSet) {

        var firstPointer = 0;
        var secondPointer = 0;

        var firstList = oneSet.myElems;
        var secondList = twoSet.myElems;

        List<E> resultList = new ArrayList<>();

        while (firstPointer < firstList.size() && secondPointer < secondList.size()) {
            if (firstList.get(firstPointer) == secondList.get(secondPointer)) {
                resultList.add(firstList.get(firstPointer));
                firstPointer++;
                secondPointer++;
                continue;
            }
            if (firstList.get(firstPointer).compareTo(secondList.get(secondPointer)) < 0) {
                resultList.add(firstList.get(firstPointer++));
            }
            else {
                resultList.add(secondList.get(secondPointer++));
            }
        }

        if (firstPointer < firstList.size() && resultList.get(resultList.size() - 1) == firstList.get(firstPointer))
            firstPointer += 1;

        while (firstPointer < firstList.size()) {
            resultList.add(firstList.get(firstPointer++));
        }

        if (secondPointer < secondList.size() && resultList.get(resultList.size() - 1) == secondList.get(secondPointer))
            secondPointer += 1;
        while (secondPointer < secondList.size()) {
            resultList.add(secondList.get(secondPointer++));
        }
        return MySet.of(resultList);
    }

    static <E extends  Comparable<E>> MySet<E> cross(MySet<E> oneSet, MySet<E> twoSet) {
        var firstPointer = 0;
        var secondPointer = 0;

        var firstList = oneSet.myElems;
        var secondList = twoSet.myElems;

        List<E> resultList = new ArrayList<>();
        while (firstPointer < firstList.size() && secondPointer < secondList.size()) {
            if (firstList.get(firstPointer) == secondList.get(secondPointer)) {
                resultList.add(firstList.get(firstPointer));
                firstPointer++;
                secondPointer++;
                continue;
            }
            if (firstList.get(firstPointer).compareTo(secondList.get(secondPointer)) < 0) {
                firstPointer++;
            }
            else {
               secondPointer++;
            }
        }

        return MySet.of(resultList);
    }

    static <E extends Comparable<E>> MySet<E> subtract(MySet<E> oneSet, MySet<E> twoSet) {
        var secondPointer = 0;

        var firstList = oneSet.myElems;
        var secondList = twoSet.myElems;

        List<E> resultList = new ArrayList<>();
        for (var e : firstList) {
            if (secondPointer == secondList.size() || e.compareTo(secondList.get(secondPointer)) < 0)
                resultList.add(e);
            else  {
                while (secondPointer < secondList.size() && e.compareTo(secondList.get(secondPointer)) > 0)
                    secondPointer++;
                if (secondPointer == secondList.size() || e.compareTo(secondList.get(secondPointer)) != 0)
                    resultList.add(e);
            }
        }

        return MySet.of(resultList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MySet<?> mySet = (MySet<?>) o;

        return myElems.equals(mySet.myElems);
    }

    @Override
    public int hashCode() {
        return myElems.hashCode();
    }
}
