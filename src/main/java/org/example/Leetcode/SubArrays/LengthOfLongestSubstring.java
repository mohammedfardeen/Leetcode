package org.example.Leetcode.SubArrays;

import java.util.HashMap;

public class LengthOfLongestSubstring {
    /*Given a string s, find the length of the longest substring without duplicate characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
    * */

    public int lengthOfLongestSubstring(String s){
        int res=0;

        for(int i=0;i<s.length();i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                if (map.size() == (j - i + 1)) {
                    res = Math.max(res, j - i + 1);
                }
                if (map.size() < (j - i + 1)) break;
            }
        }
        return res;
    }

    public int lengthOfLongestSubstringOP(String s){
        int left =0, right=0, res=0;
        HashMap<Character,Integer> map = new HashMap<>();
        for( right =0;right<s.length();right++){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            if(map.size()==(right-left+1)){
                res= Math.max(res,(right-left+1));

            }
            while (map.get(s.charAt(right)) > 1){
                map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0)-1);
                if(map.get(s.charAt(left))==0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
        }
        return res;
    }

    static void main() {
        LengthOfLongestSubstring obj = new LengthOfLongestSubstring();
        String s = "abcabcbb";
        System.out.println(obj.lengthOfLongestSubstring(s));
        System.out.println(obj.lengthOfLongestSubstringOP(s));
    }

}
