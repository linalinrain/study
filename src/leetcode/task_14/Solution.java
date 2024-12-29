package leetcode.task_14;

public class Solution {
    // https://leetcode.com/problems/longest-common-prefix/
    // Write a function to find the longest common prefix string amongst an array of strings.
    // If there is no common prefix, return an empty string "".
    public String longestCommonPrefix(String[] strs) {
        int lengthOfString = strs[0].length();
        String prefix = "";

        for (int i = 0; i < lengthOfString; i++) {
            String newPrefix = strs[0].substring(0, i + 1);

            for (String str : strs) {
                if (!str.startsWith(newPrefix)) {
                    return prefix;
                }
            }

            prefix = newPrefix;
        }

        return prefix;
    }
}
