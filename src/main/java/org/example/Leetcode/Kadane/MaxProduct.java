package org.example.Leetcode.Kadane;

public class MaxProduct {
    /*152. Maximum Product Subarray
Solved
Medium
Topics
premium lock icon
Companies
Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

Note that the product of an array with a single element is the value of that element.



Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any subarray of nums is guaranteed to fit in a 32-bit integer.*/

    public int maxProduct(int[] nums) {
        int maxEnd = nums[0];
        int minEnd = nums[0];
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            int v1 = nums[i];
            int v2 = maxEnd* nums[i];
            int v3 = minEnd* nums[i];
            maxEnd= Math.max(v1,(Math.max(v2,v3)));
            minEnd = Math.min(v1,Math.min(v2,v3));
            res=Math.max(res,maxEnd);

        }
       return res;
    }

    static void main() {
        MaxProduct maxProduct= new MaxProduct();
        System.out.println(maxProduct.maxProduct(new int[] {2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxProduct.maxProduct(new int[] {2,1,-3,4}));
    }
}
