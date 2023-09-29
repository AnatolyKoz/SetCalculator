package org.example;

import org.example.domain.MySet;

import java.util.HashMap;

public class SetStore<E extends  Comparable<E>> {

    private final HashMap<String, MySet<E>> setHashMap;
    public SetStore(HashMap<String, MySet<E>> setHashMap) {
        this.setHashMap = setHashMap;
    }
    public void setSet(String name, MySet<E> mySet) {
        setHashMap.put(name, mySet);
    }
    public MySet<E> getSet(String name) {
        return setHashMap.get(name);
    }
}
