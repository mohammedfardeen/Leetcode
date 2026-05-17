package org.example.Leetcode.Arrays.TwoPointers;

public class Move0s1s {

    public static void main(String[] args) {
        segregate0and1(new int[]{0 ,1, 0, 1, 0, 0, 1, 1, 1, 0});
        segregate0and1OP(new int[]{0 ,1, 0, 1, 0, 0, 1, 1, 1, 0});
    }

    static void segregate0and1(int[] arr) {
        // code here
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){

                if(arr[i]<arr[j]){
                    break;
                }
                else {
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+",");
        }
    }

   static void  segregate0and1OP(int[] arr){

        int l =0,r=arr.length-1;

        while(l<r){

            if(arr[l]==0){
                l++;
            } else if (arr[r]==1) {
                r--;

            }
            else {
                int temp = arr[l];
                arr[l]=arr[r];
                arr[r]=temp;
                l++; r--;
            }
        }
       System.out.println("OP :");
       for(int i=0;i<arr.length;i++) {

           System.out.print(arr[i]+",");
       }

    }

}
