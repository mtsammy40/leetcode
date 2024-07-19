package com.mutemi.leetcode.arrays.largeinteger;

import java.util.Arrays;

public class Solution {
    public int[] plusOne(int[] digits) {
        var lastIndex = digits.length - 1;
        for (int i = lastIndex; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
            if (i == 0) {
               digits[i] = 1;
            }
        }
        return Arrays.copyOf(digits, digits.length + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1, 9, 9, 9})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1, 9, 9, 8})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{ 9, 9 })));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{ 9 })));
    }
}
