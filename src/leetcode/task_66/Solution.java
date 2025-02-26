package leetcode.task_66;

public class Solution {
    // https://leetcode.com/problems/plus-one/
    // Given a large integer represented as an integer array digits, where each digits[i] is the i-th digit of the number,
    // add one to the integer.
    // The digits are stored such that the most significant digit is at the head of the array.
    // Constraints:
    // - 1 <= digits.length <= 100
    // - 0 <= digits[i] <= 9
    // - digits does not contain leading zeros, except for the number 0 itself.
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}