package org.example.Leetcode.Arrays.SlidingWindow;


/*
* Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.



Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
* */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        minSubArrayLen(7,new int[]{2,3,1,2,4,3});
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int minlength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int l = 0;
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                l++;
                if (sum >= target) {

                    minlength = Math.min(minlength, l);
                    break;
                }
            }
        }
        return (minlength == Integer.MAX_VALUE) ? 0 : minlength;

    }
}