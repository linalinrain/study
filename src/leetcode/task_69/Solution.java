package leetcode.task_69;

public class Solution {
    // https://leetcode.com/problems/sqrtx/
    // Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
    // Constraints:
    // - 0 <= x <= 2^31 - 1

    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = x, result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid <= x / mid) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}