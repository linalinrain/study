package leetcode.task_13;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // https://leetcode.com/problems/roman-to-integer/
    // Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
    public int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int romanToInt = 0;
        int prevValue = 0;

        for (char c : s.toCharArray()) {
            int currentValue = romanMap.get(c);
            if (currentValue > prevValue) {
                romanToInt += currentValue - 2 * prevValue;
            } else {
                romanToInt += currentValue;
            }
            prevValue = currentValue;
        }

        return romanToInt;
    }
}