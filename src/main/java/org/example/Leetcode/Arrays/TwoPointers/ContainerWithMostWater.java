package org.example.Leetcode.Arrays.TwoPointers;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int res=0;
        int left=0, right = height.length-1;
        while(left<right){

            int area = Math.min(height[left],height[right]) * (right-left);
            res=Math.max(res,area);
            if(height[left]<height[right]){
                left++;
            }
            else right--;
        }
        return res;

    }

    public static void main(String[] args) {
        int[] arr={1,8,6,2,5,4,8,3,7};
        System.out.println("max:"+ maxArea(arr));
        System.out.println("max:"+bruteRainWater(arr));

    }

    public static int bruteRainWater(int[] s){
        int n = s.length;
        int l=0,b=0;int area=0,maxarea=0;
        for(int i=0;i<n-1;i++){
            for( int j=i+1;j<n;j++){
                l=Math.min(s[i],s[j]);
                b=j-i;

                area= l*b;

                maxarea=Math.max(area,maxarea);
                System.out.println("l:"+l+" b:"+b);
                System.out.println("maxarea:"+maxarea);


            }
        }System.out.println("maxarea:::::"+maxarea);
        return maxarea;
    }

}
