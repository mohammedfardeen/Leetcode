package org.example.Leetcode.SubArrays;

public class MinSubArraySum {
/* * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose
sum is greater than or equal to target. If there is no such subarray, return 0 instead.



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
1 <= nums[i] <= 104
    * */
    public int minSubArraySumBrute(int k,int[] arr){
        int res=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            int sum=0; int len=0;
            for(int j=i;j<arr.length;j++){
                sum+=arr[j];
                if(sum>=k){
                    len= j-i+1;
                    res=Math.min(len,res);
                    break;
                }
            }
        }
        return res;

    }

    public int minSubArraySumOP(int k,int[] arr){
        int left =0 , right =0 , res=Integer.MAX_VALUE; int sum=0;
        while(right<arr.length){
            sum+=arr[right];

            while(sum>=k){
                int len=right-left+1;
                res=Math.min(res,len);
                sum=sum-arr[left];
                left++;

            }
            right++;

        }
        return res==Integer.MAX_VALUE?-1:res;
    }

    static void main() {
        MinSubArraySum minSubArraySum = new MinSubArraySum();
        System.out.println(minSubArraySum.minSubArraySumBrute(7,new int[]{2,3,1,2,4,3}));
        System.out.println(minSubArraySum.minSubArraySumOP(7,new int[]{2,3,1,2,4,3}) );
    }
}
