package com.mutemi.leetcode.strings.first_unique_character;

import java.util.*;

public class Solution {
    public int firstUniqChar(String s) {
        char[] sArray = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : sArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        var singles = map.entrySet().stream().filter((entry) -> entry.getValue() == 1).map(Map.Entry::getKey).toList();
        for (char c : sArray) {
            if (singles.contains(c)) {
                return s.indexOf(c);
            }
        }
        return -1;
    }

    public int firstUniqCharOptimized(String s) {
        int[] count = new int[26];
        char[] charArray = s.toCharArray();

        for(char c: charArray) {
            count[c-'a']++;
        }

        for(int i=0; i<charArray.length; i++) {
            if(count[charArray[i] - 'a']==1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("test"));
        System.out.println(solution.firstUniqChar("leetcode"));
        System.out.println(solution.firstUniqChar("loveleetcode"));
        System.out.println(solution.firstUniqChar("aabb"));
    }
}
