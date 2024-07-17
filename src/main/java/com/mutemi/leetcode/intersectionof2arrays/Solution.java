package com.mutemi.leetcode.intersectionof2arrays;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // mine
//        List<Integer> result = new ArrayList<>();
//        for (int k : nums1) {
//            for (int j = 0; j < nums2.length; j++) {
//                if (k == nums2[j]) {
//                    result.add(k);
//                    nums2[j] = Integer.MIN_VALUE;
//                    break;
//                }
//            }
//        }
//        var fout = result.stream().mapToInt(i -> i).toArray();

        int[] arr = new int[1001];
        int[] out = new int[1001];
        int counter = 0;
        for (int k : nums1) {
            arr[k] = arr[k] + 1;
        }
        System.out.println("arr: " + Arrays.toString(arr));
        for (int j : nums2) {
            if (arr[j] >= 1) {
                out[counter] = j;
                arr[j] = arr[j] - 1;
                counter++;
            }
        }
        System.out.println("out: " + Arrays.toString(out));
        int[] fout = new int[counter];
        System.arraycopy(out, 0, fout, 0, counter);

        LocalDateTime end = LocalDateTime.now();

        return fout;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}
