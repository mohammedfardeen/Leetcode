package org.example.Leetcode.Kadane;

public class MaxSubarraySumCircular {

    /*918. Maximum Sum Circular Subarray
Medium
Topics
premium lock icon
Companies
Hint
Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.



Example 1:

Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.
Example 2:

Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
Example 3:

Input: nums = [-3,-2,-3]
Output: -2
Explanation: Subarray [-2] has maximum sum -2.
*/
    public int maxSubarraySumCircular(int[] nums) {

        int totalSum = 0;

        int maxEnd = nums[0];
        int maxSum = nums[0];

        int minEnd = nums[0];
        int minSum = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];

            totalSum += val;

            if (i > 0) {
                maxEnd = Math.max(val, maxEnd + val);
                maxSum = Math.max(maxSum, maxEnd);

                minEnd = Math.min(val, minEnd + val);
                minSum = Math.min(minSum, minEnd);
            }
        }

        // Edge case: all numbers are negative
        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }
    static void main() {
        MaxSubarraySumCircular sumCircular = new MaxSubarraySumCircular();
        System.out.println( sumCircular.maxSubarraySumCircular(new int[]{-3,-2,-3}));
    }

}
