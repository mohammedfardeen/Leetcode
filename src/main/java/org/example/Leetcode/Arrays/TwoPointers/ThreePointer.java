package org.example.Leetcode.Arrays.TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class ThreePointer {

    //{2,7,11,15} k=20

    public static void main(String[] args) {
        threeSum(20,new int[]{2,7,11,15});
        threeSum(27,new int[]{2,5,7,10,12});
        threepointer(20,new int[]{2,7,11,15});
        threepointer(27,new int[]{2,5,7,10,12});
            //20,28,33,
    }

    public static void threeSum(int k,int[] a){
        for(int i=0;i< a.length;i++){
            for(int j=i+1;j<a.length;j++){
                for(int l=j+1;l<a.length;l++){
                 int sum= a[i]+a[j]+a[l];
                    System.out.println("sum="+sum);
                 if(sum==k){
                     System.out.println(a[i]+" "+a[j]+" "+a[l]);
                    return;
                 }
                }
            }

        }
        System.out.println("Not found");
    }


public static void threepointer(int target, int[] a){


    for(int i = 0; i < a.length - 2; i++){
        int left = i + 1;
        int right = a.length - 1;

        while(left < right){
            int sum = a[i] + a[left] + a[right];

            if(sum == target){
                System.out.println(a[i] + " " + a[left] + " " + a[right]);
                return; // optional
            }
            else if(sum > target){
                right--;
            }
            else {
                left++;
            }
        }
    }
    System.out.println("Not found");
}

    public List<List<Integer>> threeSum(int[] nums) {
        int target =0;
        List<List<Integer>> arrlist = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == target){
                    System.out.println(nums[i] + " " + nums[left] + " " + nums[right]);
                    List<Integer> arr = new ArrayList<>();
                    arr.add(i);
                    arr.add(left);
                    arr.add(right);
                    arrlist.add(arr);

                }
                else if(sum > target){
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return arrlist;

    }
}
