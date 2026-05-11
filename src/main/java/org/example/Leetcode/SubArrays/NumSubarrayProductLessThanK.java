package org.example.Leetcode.SubArrays;

public class NumSubarrayProductLessThanK {
    /*713. Subarray Product Less Than K
Medium
Topics
premium lock icon
Companies
Hint
Given an array of integers nums and an integer k,
 return the number of contiguous subarrays where the product
 of all the elements in the subarray is strictly less than k.



Example 1:

Input: nums = [10,5,2,6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are:
[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
Example 2:

Input: nums = [1,2,3], k = 0
Output: 0


Constraints:

1 <= nums.length <= 3 * 104
1 <= nums[i] <= 1000
0 <= k <= 106*/


    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            int product=1;
            for (int j=i;j<nums.length;j++){
                product*=nums[j];
                if(product<k){
                    count++;
                }
            }
        }
        return count;

    }


    public int numSubarrayProductLessThanKOP(int[] nums, int k) {

        int left =0, right =0, product =1, count =0;
        for(right=0;right<nums.length;right++){
            product*=nums[right];
            while(product>=k){
                product= product/nums[left];
                left++;
            }

            count += (right - left + 1);

        }
        return count;
    }




    static  void main() {
        NumSubarrayProductLessThanK lessThanK = new NumSubarrayProductLessThanK();
         int c=   lessThanK.numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100);
        System.out.println("C:"+c);
        int a =lessThanK.numSubarrayProductLessThanKOP(new int[]{10,5,2,6}, 100);
        System.out.println("A:"+a);
    }

}
