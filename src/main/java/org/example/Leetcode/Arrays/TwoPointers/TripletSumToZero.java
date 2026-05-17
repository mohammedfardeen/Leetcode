package org.example.Leetcode.Arrays.TwoPointers;


import java.util.*;

public class TripletSumToZero {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        Object arrlist =  tripletSumBrute(nums);
        System.out.println("Object:"+arrlist);
        Object arrlistt= threeSumOP(nums);
        System.out.println("Object:"+arrlistt);

}

 static List<List<Integer>> tripletSumBrute(int[] nums){



     Set<List<Integer>> arrlist = new HashSet<>();


         for( int i=0;i<nums.length-2;i++){
             for( int j=i+1;j<nums.length-1;j++){
                 for( int k=j+1;k<nums.length;k++){

                     if(nums[i]+nums[j]+nums[k]==0){
                         List<Integer> arr= new ArrayList<>();
                         arr.add(nums[i]);
                         arr.add(nums[j]);
                         arr.add(nums[k]);
                       Collections.sort(arr);

                         arrlist.add(arr);
                     }
                 }
             }
         }

     return new ArrayList<>(arrlist);
 }


    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        int left =1; int right = nums.length-1;
        for(int i=0;i<nums.length-2;i++){

            while(left<right){
                if(nums[left]+nums[right]==-nums[i]){
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(nums[i]);
                    arr.add(nums[left]);
                    arr.add(nums[right]);
                    Collections.sort(arr);
                    res.add(arr);
                    left++; right--;
                }
                else if(nums[left]+nums[right]<-nums[i]){
                    left++;
                }
                else {
                    right++;
                }
            }
        }

        return new ArrayList<>(res);


    }


        public static List<List<Integer>> threeSumOP(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 2; i++) {

                // Skip duplicate 'i'
                if (i > 0 && nums[i] == nums[i - 1]) continue;

                int left = i + 1;
                int right = nums.length - 1;
                int target = -nums[i];

                while (left < right) {
                    int sum = nums[left] + nums[right];

                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                        left++;
                        right--;

                        // Skip duplicates for left
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }

                        // Skip duplicates for right
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }

                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }

            return res;
        }


}

