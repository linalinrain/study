package leetcode.task_27;

public class Solution {
    // https://leetcode.com/problems/remove-element/
    // Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
    // The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
    //
    // Consider the number of elements in nums which are not equal to val to be k. You need to:
    // 1. Modify nums so that the first k elements contain the elements which are not equal to val.
    // 2. Return k.
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0)
            return 0;
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
