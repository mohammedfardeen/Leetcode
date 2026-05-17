package org.example.Leetcode.Arrays.SlidingWindow;

/*
* Input: s = "aabacbebebe", k = 3
Output: 7
Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.
Input: s = "aaaa", k = 2
Output: -1
Explanation: There's no substring with 2 distinct characters.
* */

import java.util.HashMap;

public class LongestSubstringKUniques {


    int uniqueBrute(String s, int k) {
        char[] arr = s.toCharArray();
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            HashMap<Character, Integer> ab = new HashMap<>();
            for (int j = i; j < arr.length; j++) {
                ab.put(arr[j], ab.getOrDefault(arr[j], 0) + 1);
                if (ab.size() == k) {
                    int length = j - i + 1;
                    res = Math.max(res, length);

                } else if (ab.size() > k) {
                    break;

                }

            }
        }
        return (res == Integer.MIN_VALUE ? -1 : res);


    }
}
