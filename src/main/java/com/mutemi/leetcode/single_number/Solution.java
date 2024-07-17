package com.mutemi.leetcode.single_number;

import java.util.Arrays;

public class Solution {
//    public int singleNumber(int[] nums) {
//        Arrays.sort(nums);
//        int singleNumber = nums[0];
//        for (int i = 0; i < nums.length - 2; i++){
//            if (nums[i+1] == singleNumber) {
//                singleNumber = nums[i + 2];
//                i++;
//            }
//        }
//        return singleNumber;
//    }

    public int singleNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
            System.out.println("ans: " + ans + " nums[i]: " + nums[i] + " :: ans ^ nums[i]: " + (ans ^ nums[i]));
            ans^=nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.singleNumber(new int[]{2,1,2,1,4}));
//        System.out.println(solution.singleNumber(new int[]{2,2,1}));
        System.out.println(solution.singleNumber(new int[]{-336,513,-560,-481,-174,101,-997,40,-527,-784,-283,-336,513,-560,-481,-174,101,-997,40,-527,-784,-283,354}));
    }
}
