package org.example.Leetcode.SubArrays;

import java.util.HashMap;

public class MinWindow {

    /*76. Minimum Window Substring
Hard

Given two strings s and t of lengths m and n respectively,
 return the minimum window substring of s such that every character
 in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.*/

    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (n > m) return "";

        // build frequency map for t
        int[] tFreq = new int[128];
        for (char c : t.toCharArray()) {
            tFreq[c]++;
        }

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int i = 0; i < m; i++) {
            int[] windowFreq = new int[128];

            for (int j = i; j < m; j++) {
                char c = s.charAt(j);
                windowFreq[c]++;

                // check if current window is valid
                if (isValid(windowFreq, tFreq)) {
                    int len = j - i + 1;
                    if (len < minLen) {
                        minLen = len;
                        start = i;
                    }
                    break; // no need to expand further for this i
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    private boolean isValid(int[] windowFreq, int[] tFreq) {
        for (int i = 0; i < 128; i++) {
            if (windowFreq[i] < tFreq[i]) {
                return false;
            }
        }
        return true;
    }

    public String minWindowOP(String s, String t) {
        if (t.length() > s.length()) return "";

        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> window = new HashMap<>();

        int have = 0;
        int required = need.size();

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // if this char satisfies requirement
            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                have++;
            }

            // try to shrink window
            while (have == required) {
                // update result
                if ((right - left + 1) < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                // if removing breaks requirement
                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                    have--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    static void main() {

    }

    }
