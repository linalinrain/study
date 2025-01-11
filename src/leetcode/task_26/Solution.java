package leetcode.task_26;

public class Solution {
    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    // Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place
    // such that each unique element appears only once. The relative order of the elements should be kept the same.
    // Return the number of unique elements in nums.
    //
    // Consider the number of unique elements of nums to be k. You need to:
    // 1. Modify nums so that the first k elements contain the unique elements in the original order.
    // 2. Return k.
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int k = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
