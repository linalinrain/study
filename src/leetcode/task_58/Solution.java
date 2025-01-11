package leetcode.task_58;

public class Solution {
    // https://leetcode.com/problems/length-of-last-word/
    // Given a string s consisting of words and spaces, return the length of the last word in the string.
    // A word is a maximal substring consisting of non-space characters only.
    // Constraints:
    // - 1 <= s.length <= 10^4
    // - s consists of only English letters and spaces ' '
    // - There will be at least one word in s
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int lastSpaceIndex = s.lastIndexOf(' ');

        return s.length() - lastSpaceIndex - 1;
    }
}
