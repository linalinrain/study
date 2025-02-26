package leetcode.task_67;

public class Solution {
    // https://leetcode.com/problems/add-binary/
    // Given two binary strings a and b, return their sum as a binary string.
    // Constraints:
    // - 1 <= a.length, b.length <= 10^4
    // - a and b consist only of '0' or '1' characters.
    // - a and b do not contain leading zeros except for "0" itself.
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';

            result.append(sum % 2);
            carry = sum / 2;
        }

        return result.reverse().toString();
    }
}