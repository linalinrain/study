package leetcode.task_9;

class Solution {
    // https://leetcode.com/problems/palindrome-number/
    // Given an integer x, return true if x is a palindrome, and false otherwise.
    public boolean isPalindrome(int x) {
        String numberAsString = String.valueOf(x);
        String reversedNumberAsString = new StringBuilder(numberAsString).reverse().toString();

        return numberAsString.equals(reversedNumberAsString);
    }
}