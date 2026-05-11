package org.example.Leetcode.SubArrays;

import java.util.HashMap;

public class LongestSubStringWithUniqueK {
    /*
    * Longest Substring with K Uniques

You are given a string s consisting only lowercase alphabets and an integer k.
* Your task is to find the length of the longest substring that contains exactly k distinct characters.

Note : If no such substring exists, return -1.

Examples:

Input: s = "aabacbebebe", k = 3
Output: 7
Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.
Input: s = "aaaa", k = 2
Output: -1
Explanation: There's no substring with 2 distinct characters.
Input: s = "aabaaab", k = 2
Output: 7
Explanation: The entire string "aabaaab" has exactly 2 unique characters 'a' and 'b', making it the longest valid substring.
Constraints:
1 ≤ s.size() ≤ 105
1 ≤ k ≤ 26*/

    public int longestSubStringBrute(int k,String s){
        int res=-1;
        for(int i=0;i<s.length();i++){
            HashMap<Character,Integer> map = new HashMap<>();
            for(int j=i;j<s.length();j++){
                map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
                if(map.size()==k){
                    int len = j-i+1;
                    res=Math.max(res,len);
                }
                if (map.size() > k) break;
            }
        }
        return res;
    }

    public int longestSubStringOP(int k, String s) {
        int left = 0, res = -1;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // shrink if more than k distinct
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            // valid window
            if (map.size() == k) {
                res = Math.max(res, right - left + 1);
            }
        }

        return res;
    }

    static void main() {
        LongestSubStringWithUniqueK longestSubStringWithUniqueK = new LongestSubStringWithUniqueK();
        System.out.println(longestSubStringWithUniqueK.longestSubStringBrute(3,"aabacbebebe"));
        System.out.println(longestSubStringWithUniqueK.longestSubStringOP(3,"aabacbebebe"));
    }
}
