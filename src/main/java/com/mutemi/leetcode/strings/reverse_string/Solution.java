package com.mutemi.leetcode.strings.reverse_string;

public class Solution {
    public void reverseString(char[] s) {
        for (int i = s.length / 2; i > 0; i--) {
            char temp = s[s.length - i];
            s[s.length - i] = s[i - 1];
            s[i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] argsy = new char[] {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(argsy);
        System.out.printf(String.valueOf(argsy));
    }
}
