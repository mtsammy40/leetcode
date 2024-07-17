package com.mutemi.leetcode.contains_duplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicateGoodMemory(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for(int i = 0; i < nums.length ; i++){
            if(numsSet.contains(nums[i])){
                return true;
            }
            numsSet.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.containsDuplicate(new int[]{1, 2, 3, 1}));
    }
}
