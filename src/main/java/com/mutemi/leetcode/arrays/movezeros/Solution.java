package com.mutemi.leetcode.arrays.movezeros;

public class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, j= 0;
        while(j < nums.length){
            if(nums[j] == 0) j++;
            else if(nums[i] == 0 && nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }else {
                i++;j++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.moveZeroes(new int[]{0, 1, 0, 3, 12});
        solution.moveZeroes(new int[]{0, 0, 1});
        solution.moveZeroes(new int[]{1, 2, 0});
    }
}
