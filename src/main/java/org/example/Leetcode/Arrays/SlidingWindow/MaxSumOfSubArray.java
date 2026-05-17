package org.example.Leetcode.Arrays.SlidingWindow;

public class MaxSumOfSubArray {

    public static void main(String[] args) {
       int sumBrute = maxSubarraySumBrute(new int[]{100,200,300,400},2);
        System.out.println("sumBrute:"+sumBrute);
        int sumOP= maxSubarraySum(new int[]{100,200,300,400},2);
        System.out.println("sumOP:"+sumOP);
    }

    public static int maxSubarraySumBrute(int[] arr, int k) {
        // Code here
        int maxSum = 0;
        for(int i=0;i<=arr.length-k;i++){
            int sum=0;
            sum=arr[i];
            for(int j=i+1;j<i+k;j++){
                sum+=arr[j];

            }
            if(sum>maxSum){
                maxSum=sum;
            }
        }
        return maxSum;
    }

    public static int maxSubarraySum(int[] arr, int k){
        int maxSum=0; int low=0,high=k-1; int sum=0;
        for(int i=low;i<=high;i++){
            sum+=arr[i];
        }

        while(high<arr.length){
            maxSum=Math.max(sum,maxSum);
            low++;high++;
            if(high==arr.length){
                break;
            }
            sum=sum-arr[low-1]+arr[high];

        }
        return maxSum;
    }
}
