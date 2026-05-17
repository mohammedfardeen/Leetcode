package org.example.Leetcode.Arrays.SlidingWindow;

public class SubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        int res=1;
        char[] c = s.toCharArray();
        for(int i=1;i<s.length();i++){
           int len = 0;
            for(int j=i;j<s.length();j++){

                if(c[j]==c[j-1]){
                    break;

                }
                else {
                    len= j-i+1;
                    res=Math.max(res,len);
                }



            }
        }
        return res;

    }


}
