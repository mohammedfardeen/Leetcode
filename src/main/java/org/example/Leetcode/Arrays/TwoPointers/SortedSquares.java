package org.example.Leetcode.Arrays.TwoPointers;

public class SortedSquares {

    public static void main(String[] args) {
        int[] k=  sortedSquaresBrute(new int[]{-4, -2, -1, 0, 3, 4, 5, 10});
        int[] s=   sortedSquares(new int[]{-4, -2, -1, 0, 3, 4, 5, 10});


    }

    public static int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int index = nums.length - 1;
        int[] res = new int[nums.length];
        while (l <= r) {
            int lsqrt = nums[l] * nums[l];
            int rsqrt = nums[r] * nums[r];

            if (lsqrt > rsqrt) {
                res[index] = lsqrt;
                l++;
            } else {
                res[index] = rsqrt;
                r--;
            }
            index--;
        }

        return res;
    }

    public static int[] sortedSquaresBrute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
}

