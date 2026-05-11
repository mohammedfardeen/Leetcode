package org.example.Leetcode.SubArrays;

public class MinSubArrayLen {

    /*209. Minimum Size Subarray Sum
Medium
Topics
premium lock icon
Companies
Given an array of positive integers nums and a positive integer target,
 return the minimal length of a subarray whose sum is greater than or equal to target.
 If there is no such subarray, return 0 instead.



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


Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104*/

    public int minSubArrayLen(int target, int[] nums) {
        int res =Integer.MAX_VALUE;
        for(int i =0;i<nums.length;i++){
            int sum=0;
            for(int j =i; j< nums.length;j++){
                sum+=nums[j];
                int len = j-i+1;
                if(sum>=target){
                    res=Math.min(res,len);
                }

            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }

    public int minSubArrayLenOP(int target, int[] nums) {
        int res = Integer.MAX_VALUE; int left =0, right =0,  sum =0;
        for( right =0;right<nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                res = Math.min(res, right - left + 1); // update inside loop
                sum -= nums[left];
                left++;
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }


    static void main() {
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        int k =minSubArrayLen.minSubArrayLen(7,new int[]{2,3,1,2,4,3});
        System.out.println("K:"+k);
        int op = minSubArrayLen.minSubArrayLenOP(7,new int[]{2,3,1,2,4,3});
        System.out.println("op:"+op);
    }
}
