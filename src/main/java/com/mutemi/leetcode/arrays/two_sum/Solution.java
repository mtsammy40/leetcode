package com.mutemi.leetcode.arrays.two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        return optimized(nums, target);
    }

    int[] optimized(int[] nums, int target) {
        Map<Integer, Integer> intMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(intMap.containsKey(target - nums[i])) {
                return new int[] {i, intMap.get(target- nums[i])};
            }
            intMap.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }


    int indexOf(Integer needle, int[] haystack) {
        for (int i = 0; i < haystack.length; i++) {
            if (needle == haystack[i]) {
                return i;
            }
        }
        return -1;
    }

    int[] optimizedBruteForce(int[] nums, int target) {
        int[] result = new int[2];
        for (int j = 0; j < nums.length; j++) {
            int complement = target - nums[j];
            int index = indexOf(complement, nums);
            if (index == j) {
                continue;
            }
            if (index != -1) {
                result[0] = j;
                result[1] = index;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.printf("test 1" + Arrays.toString(solution.twoSum(new int[]{2, 7, 11, 15}, 9)) + "\n");
        System.out.printf("test 2" + Arrays.toString(solution.twoSum(new int[]{2, 11, 15, 7}, 9)) + "\n");
        System.out.printf("test 3" + Arrays.toString(solution.twoSum(new int[]{15, 11, 2, 7}, 9))+ "\n");
        System.out.printf("test 4" + Arrays.toString(solution.twoSum(new int[]{3,3}, 6))+ "\n");

    }
}
