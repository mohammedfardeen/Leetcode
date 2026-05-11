package org.example.Leetcode.SubArrays;

/*Given an array of integers arr[]  and a number k. Return the maximum sum of a subarray of size k.

Note: A subarray is a contiguous part of any given array.

Examples:

Input: arr[] = [100, 200, 300, 400], k = 2
Output: 700
Explanation: arr2 + arr3 = 700, which is maximum.
Input: arr[] = [1, 4, 2, 10, 23, 3, 1, 0, 20], k = 4
Output: 39
Explanation: arr1 + arr2 + arr3 + arr4 = 39, which is maximum.
Input: arr[] = [100, 200, 300, 400], k = 1
Output: 400
Explanation: arr3 = 400, which is maximum.
Constraints:
1 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 106
1 ≤ k ≤ arr.size()*/

public class MaxSumSizeK {

    public int maxSumSizeKBrute(int size,int[] arr){
        int maxSum = Integer.MIN_VALUE;
        for( int i=0;i<=arr.length-size;i++){
            int sum =0;
            for( int j=i;j<(i+size);j++){
                 sum+= arr[j];
            }
            if(sum>maxSum){
                maxSum=sum;

            }
        }
        return maxSum;

    }

    public int maxSumSizeKOP(int size,int[] arr){
        int left=0; int right=size; int maxSum=0; int sum=0;
        for( int i=0;i<size;i++){
            sum+=arr[i];
        }
        maxSum=sum;
        while(right< arr.length){


                sum=sum-arr[left]+arr[right];
                left++;
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }

    static void main() {
        MaxSumSizeK maxSumSizeK = new MaxSumSizeK();
        System.out.println( maxSumSizeK.maxSumSizeKBrute(4,new int[]{100, 200, 300, 400}));
        System.out.println(maxSumSizeK.maxSumSizeKOP(4,new int[]{100, 200, 300, 400}));

    }
}
