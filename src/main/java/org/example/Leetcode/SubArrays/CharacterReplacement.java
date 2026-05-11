package org.example.Leetcode.SubArrays;

import java.util.HashMap;

/*
* 424. Longest Repeating Character Replacement
Medium

You are given a string s and an integer k. You can choose any character of the string
* and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get
* after performing the above operations.



Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achieve this answer too.


Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
* */
public class CharacterReplacement {

    public int characterReplacement(String s, int k) {
        int res =0;
        for(int i=0;i<s.length();i++){
            HashMap<Character,Integer> map = new HashMap<>();
                for( int j=i;j<s.length();j++){
                    map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
                    int len= j-i+1;
                    int maxFreq = 0;
                    for( int max : map.values()){
                        maxFreq=Math.max(maxFreq,max);
                    }

                    int notUnique = len-maxFreq;
                    if(notUnique<=k){
                        res=Math.max(res,len);
                    }
                    if (notUnique>k){
                        break;
                    }
                }
        }
       return res;

    }

    public int characterReplacementOP(String s, int k) {
        int[] freq = new int[26]; // since uppercase letters
        int left = 0;
        int maxFreq = 0;
        int res = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freq[ch - 'A']++;

            // update max frequency in current window
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            int windowSize = right - left + 1;

            // if more than k replacements needed, shrink window
            if (windowSize - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }


        static void main() {
        CharacterReplacement replacement = new CharacterReplacement();
        System.out.println(replacement.characterReplacement("AABABBA",1));
        System.out.println(replacement.characterReplacementOP("AABABBA",1));
    }




}
