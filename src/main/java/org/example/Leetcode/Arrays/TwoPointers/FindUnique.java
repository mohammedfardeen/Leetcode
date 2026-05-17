package org.example.Leetcode.Arrays.TwoPointers;

public class FindUnique {

    //IN AN ARRAY FIND THE UNIQUE NUMS
    //[0,0,0,1,1,2,3,3]

    public static void main(String[] args) {
        findUniqueBrute(new int[]{0,0,0,1,1,2,3,3});
        findUniqueOP(new int[]{0,0,0,1,1,2,3,3});

    }

    static int findUniqueBrute(int[] arr){
        int unique=1;
        for( int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1]){
                arr[unique]=arr[i];
                unique++;

            }
        }
        System.out.println(unique);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+",");
        }
        return unique;
    }

    static int[] findUniqueOP(int[] arr){
        int unique=1;
        int l=0,r=1;
        while(r<arr.length){
            if(arr[r]!=arr[l]){
                arr[l+1]=arr[r];
                l++; r++;
                unique++;
            }
            else r++;
        }
        System.out.println("");
        System.out.println(unique);
        for(int i=0;i<arr.length;i++){

            System.out.print(arr[i]+",");
        }
        return arr;
    }
}
