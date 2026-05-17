package org.example.Leetcode.Arrays.SlidingWindow;


import java.util.HashMap;

/*
* You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.



Example 1:

Input: fruits = [1,2,1]
Output: 3
Explanation: We can pick from all 3 trees.
Example 2:

Input: fruits = [0,1,2,2]
Output: 3
Explanation: We can pick from trees [1,2,2].
If we had started at the first tree, we would only pick from trees [0,1].
Example 3:

Input: fruits = [1,2,3,2,2]
Output: 4
Explanation: We can pick from trees [2,3,2,2].
If we had started at the first tree, we would only pick from trees [1,2].
* */
public class FruitIntoBaskets {

    public static void main(String[] args) {
        System.out.println(totalFruitBrute(new int[]{1,2,3,2,2}));
        System.out.println(totalFruit(new int[]{1,2,3,2,2}));
    }


    public static int totalFruitBrute(int[] fruits) {
        int res =0;
        for(int i=0;i<fruits.length;i++){
            HashMap<Integer,Integer> ab = new HashMap<>();
            for( int j=i;j<fruits.length;j++){
                ab.put(fruits[j], ab.getOrDefault(fruits[j],0)+1);
                if(ab.size()<=2){
                    int len = j-i+1;
                    res= Math.max(res,len);

                }
                else {
                    break;
                }

            }
        }
        return res;
    }

    public static int totalFruit(int[] fruits) {
        int res =0; int low =0 ;
        HashMap<Integer,Integer> ab = new HashMap<>();
        for(int high=0;high<fruits.length;high++){


            ab.put(fruits[high], ab.getOrDefault(fruits[high],0)+1);
            if(ab.size()<=2){
                int len = high-low+1;
                res= Math.max(res,len);

            }
            while( ab.size()>2){
                ab.put(fruits[low],ab.get(fruits[low])-1);
                if(ab.get(fruits[low])==0){
                    ab.remove(fruits[low]);
                }
                low++;
            }



        }
        return res;
    }
}
