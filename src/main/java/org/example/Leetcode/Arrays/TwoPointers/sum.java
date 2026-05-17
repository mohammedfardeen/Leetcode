package org.example.Leetcode.Arrays.TwoPointers;

public class sum {

    public static void main(String[] args) {

        findSum(9,new int[]{2,7,11,15});
        twoPointerSum(9,new int[]{2,7,11,15});


    }

    //brute force , time complexity O(n)^2
    public static void findSum(int k,int[] arr){

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int temp=arr[i]+arr[j];
                if(temp==k){
                    System.out.print(arr[i]+" "+arr[j]);
                    return;
                }
            }
        }
        System.out.println("No element adds to K");
    }

    //optimised solution
    public static void twoPointerSum(int k,int[] arr){
        int l=0; int r=arr.length-1;
        System.out.println();
        while(l<r){
           int temp_sum=arr[l]+arr[r];
            if(temp_sum == k){
                System.out.println(arr[l]+" "+arr[r]);
                break;
            } else if (temp_sum>k) {
                r--;
            }
            else l++;
        }
        return;

    }


    }


