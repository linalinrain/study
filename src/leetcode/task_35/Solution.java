package leetcode.task_35;

public class Solution {
    // https://leetcode.com/problems/search-insert-position/
    // Given a sorted array of distinct integers and a target value, return the index if the target is found.
    // If not, return the index where it would be if it were inserted in order.
    // You must write an algorithm with O(log n) runtime complexity.
    // Constraints:
    // - 1 <= nums.length <= 10^4
    // - -10^4 <= nums[i] <= 10^4
    // - nums contains distinct values sorted in ascending order.
    // - -10^4 <= target <= 10^4
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                index = mid;
                return index;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        index = left;
        return index;
    }
}
