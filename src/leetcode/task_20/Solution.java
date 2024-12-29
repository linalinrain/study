package leetcode.task_20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    // https://leetcode.com/problems/valid-parentheses/description/
    // Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    // determine if the input string is valid.
    // An input string is valid if:
    // - Open brackets must be closed by the same type of brackets.
    // - Open brackets must be closed in the correct order.
    // - Every close bracket has a corresponding open bracket of the same type.
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (char c : s.toCharArray()) {
            if (map.containsValue(c)) {
                stack.push(c);
            } else if (!stack.isEmpty() && map.containsKey(c)) {
                if (stack.peek() == map.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}