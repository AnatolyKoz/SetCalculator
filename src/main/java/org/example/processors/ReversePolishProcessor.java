package org.example.processors;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Function;

public class ReversePolishProcessor implements Function<List<String>, List<String>> {
    @Override
    public List<String> apply(List<String> stringList) {

        List<String> list = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        for (var string : stringList) {
            if (string.length() > 1) {
                list.add(string.toLowerCase());
                continue;
            }

            char symbol = string.charAt(0);
            if (symbol == '!') {
                stack.add(symbol);
                continue;
            }
            if (symbol == '(') {
                stack.add(symbol);
                continue;
            }

            if (symbol == ')') {
                while (stack.peek() != '(') {
                    list.add(String.valueOf(stack.pop()));
                }
                stack.pop();
                continue;
            }

            while (stack.size() > 0 && stack.peek() != '(') {
                list.add(String.valueOf(stack.pop()));
            }
            stack.add(symbol);
        }

        while (stack.size() > 0) {
            list.add(String.valueOf(stack.pop()));
        }

        return list;
    }
}
