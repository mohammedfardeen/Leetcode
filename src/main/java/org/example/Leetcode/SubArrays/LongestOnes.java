package org.example.Leetcode.SubArrays;


/*Given a binary array nums and an integer k, return the maximum number of consecutive 1's
in the array if you can flip at most k 0's.



Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.


Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length*/
public class LongestOnes {


    public int longestOnes(int[] nums, int k) {
        int res =0;
        for(int i =0;i<nums.length;i++){
            int[] ar = new int[2];
            for( int j=i;j<nums.length;j++){
                if(nums[j]==0){
                    ar[0]++;
                }
                else {
                    ar[1]++;
                }

                int len = j-i+1;
                int maxOccurence = Math.max(ar[0],ar[1]);

                if(len-maxOccurence<=k){
                    res = Math.max(res,len);
                }

            }
        }
        return res;
    }

    public int longestOnesOP(int[] nums, int k) {
        int left = 0, zeros = 0, res = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeros++;
            }

            // shrink window if invalid
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }


    static void main() {
        LongestOnes  longestOnes = new LongestOnes();
        System.out.println(longestOnes.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
        System.out.println(longestOnes.longestOnesOP(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }

}
