package com.abrus.task3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.Collection;

/*
https://leetcode.com/problems/valid-parentheses/description/
 */
public class Main {

    public static void main(String[] args) {
        test("()");
        test("(]");
        test("}");
        test("()[");
        test("([}])[]{}");
        test("([])[]{}");
    }

    public static void test(String input) {
        System.out.println(input + " is valid input: " + isValid(input));
    }

    public static boolean isValid(String s) {
        Map<Character, Character> parenthesisDictionary = new HashMap<>();
        parenthesisDictionary.put('(', ')');
        parenthesisDictionary.put('[', ']');
        parenthesisDictionary.put('{', '}');

        Set<Character> openers = parenthesisDictionary.keySet();
        Collection<Character> closers = parenthesisDictionary.values();

        Stack<Character> closerStack = new Stack<>();
        for (Character c: s.toCharArray()) {
            if (openers.contains(c)) {
                closerStack.push(parenthesisDictionary.get(c));
            } else if (closers.contains(c) && (closerStack.empty() || closerStack.pop() != c)) {
                return false;
            }
        }
        return closerStack.empty();
    }
}
