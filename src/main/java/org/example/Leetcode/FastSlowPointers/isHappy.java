package org.example.Leetcode.FastSlowPointers;

public class isHappy {
    /*202. Happy Number
Easy
Topics
premium lock icon
Companies
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.



Example 1:

Input: n = 19
Output: true
Explanation:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
Example 2:

Input: n = 2
Output: false

    * */



    public boolean isHappy(int n) {
        int slow =n;
        int fast = n;
        while(fast !=1 ){
            slow=getSum(slow);
            fast=getSum(fast);
            fast=getSum(fast);
            if (slow==fast && slow !=1 ){
                return false;

            }
        }
        return true;



    }
//below works only for 2 digit n and will fail when n is 3 digit or greater
//    public int getSum( int n){
//        int d = n%10;
//        int t = n/10;
//       int  sum =0;
//       sum= d*d + t*t;
//       return sum;
//    }

    public int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }
        return sum;
    }

    static void main() {
        isHappy isHappy= new isHappy();
        System.out.println(isHappy.isHappy(19));

        isHappy.getSum(19);
    }
}
