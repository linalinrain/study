package leetcode.task_28;

public class Solution {
    // https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
    // Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
    // or -1 if needle is not part of haystack.
    // Constraints:
    // 1 <= haystack.length, needle.length <= 10^4
    // haystack and needle consist of only lowercase English characters.
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty())
            return 0;

        int haystackLength = haystack.length();
        int needleLength = needle.length();

        for (int i = 0; i <= haystackLength - needleLength; i++) {
            if (haystack.substring(i, i + needleLength).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
