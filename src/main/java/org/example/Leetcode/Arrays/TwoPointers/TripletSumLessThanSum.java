package org.example.Leetcode.Arrays.TwoPointers;

import java.util.Arrays;

public class TripletSumLessThanSum {

    // User function Template for Java

    public static void main(String[] args) {
        long[] arr = new long[]{5, 1, 3, 4, 7};

        countTriplets(5,12,arr);
        countTripletsOP(5,12,arr);
    }

       static long countTriplets(int n, int sum, long arr[]) {
            long count=0;
//            List<List<Long>> res = new ArrayList<>();
//            Arrays.sort(arr);
            for(int i=0;i<n-2;i++){
                for(int j=i+1;j<n-1;j++){
                    for(int k=j+1;k<n;k++){

//                        if(i>0 && arr[i]==arr[i-1]){
//                            continue;
//                        }
//                        if(j>1 && arr[j]==arr[j-1]){
//                            continue;
//                        }
//                        if(k>2 && arr[k]==arr[k-1]){
//                            continue;
//                        }

                        long temp_sum = arr[i]+arr[j]+arr[k];
                        if(temp_sum<sum){
                            count++;
//                            List<Long> a = new ArrayList<>();
//                            a.add(arr[i]);
//                            a.add(arr[j]);
//                            a.add(arr[k]);
//                            res.add(a);
                        }
                    }
                }
            }
            return count;

        }

    // User function Template for Java


      static  long countTripletsOP(int n, int sum, long arr[]) {


            Arrays.sort(arr);
            int count=0;
            for(int i=0;i<n-2;i++){

                int l=i+1; int r = n-1;

                while(l<r){
                    long temp_sum = arr[i]+arr[l]+arr[r];
                    if(temp_sum<sum){
                        count+=(r-l);
                        l++;
                    }
                    else {
                        r--;
                    }
                }

            }
            return count;

        }




}
