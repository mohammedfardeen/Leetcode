package org.example.Leetcode.Arrays.TwoPointers;

import java.util.Arrays;

public class ClosestSumToTarget {


        public int threeSumClosest(int[] nums, int target) {

            Arrays.sort(nums);

            // Initialize with first possible triplet
            int closestSum = nums[0] + nums[1] + nums[2];

            for (int i = 0; i < nums.length - 2; i++) {
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];

                    // If exact match, return immediately
                    if (sum == target) {
                        return sum;
                    }

                    // Update closest sum if this is better
                    if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                        closestSum = sum;
                    }

                    // Move pointers
                    if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }

            return closestSum;
        }

        static int closestSumBrute(int[] nums, int target){
            int closum= nums[0]+nums[1]+nums[2];

            for(int i=0;i<nums.length-2;i++){
                for(int j=i+1;j<nums.length-1;j++){
                    for(int k=j+1;k<nums.length;k++){
                        int sum= nums[i]+nums[j]+nums[k];

                        if (Math.abs(sum - target) < Math.abs(closum - target)) {
                            closum = sum;
                        }
                    }
                }
            }
            return closum;
        }
    }

