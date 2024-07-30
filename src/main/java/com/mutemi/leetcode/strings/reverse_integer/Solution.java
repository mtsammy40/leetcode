package com.mutemi.leetcode.strings.reverse_integer;

public class Solution {
    public int reverse(int x) {
        String xString = String.valueOf(x);
        boolean signed = false;
        if (xString.startsWith("-")) {
            signed = true;
            xString = xString.substring(1);
        }
        var reversedString = reverseString(xString);
        if (signed) {
            reversedString  = "-" + reversedString;
        }
        try {
            return Integer.parseInt(reversedString);
        } catch (Exception e) {
            return 0;
        }
    }

    String reverseString(String string) {
        char[] stringChars = string.toCharArray();
        for (int i = 0; i < stringChars.length / 2; i++) {
            char temp = stringChars[stringChars.length - i - 1];
            stringChars[stringChars.length - i - 1] = stringChars[i];
            stringChars[i] = temp;
        }
        return String.valueOf(stringChars);
    }

    public int reverseOptimized(int x) {
        int reversed = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if(reversed > Integer.MAX_VALUE/10 || reversed < Integer.MIN_VALUE/10 ){
                return 0;
            }
            reversed = reversed * 10 + pop;
        }

        return reversed;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.reverse(123));
//        System.out.println(solution.reverse(-123));
//        System.out.println(solution.reverse(120));
//        System.out.println(solution.reverse(0));
//        System.out.println(solution.reverse(900000));
        System.out.println(solution.reverse(1534236469));
    }
}
