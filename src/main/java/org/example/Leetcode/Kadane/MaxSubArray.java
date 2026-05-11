package org.example.Leetcode.Kadane;

public class MaxSubArray {

    /*
    * 53. Maximum Subarray
Solved
Medium
Topics
premium lock icon
Companies
Given an integer array nums, find the subarray with the largest sum, and return its sum.



Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104

    * */
    public int maxSubArray(int[] nums) {
        int bestEnd = nums[0];
        int res = nums[0];
        for( int i=1;i< nums.length;i++){
            int v1 = nums[i];
            int v2 = nums[i]+ bestEnd;
            bestEnd = Math.max(v1,v2);
            res = Math.max(res,bestEnd);
        }
        return res;
    }

    static void main() {
        MaxSubArray maxSubArray = new MaxSubArray();
       int k = maxSubArray.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
        System.out.println("maxSubArray:"+k);
    }

}
