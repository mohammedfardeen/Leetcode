package org.example.Leetcode.Arrays.TwoPointers;

public class FourPointer {

    //{2,5,7,11,15,20,22,25} target = 45

    public static void main(String[] args) {
        fourSum(45,new int[]{2,5,7,11,15,20,22,25});
        fourPointerSum(45,new int[]{2,5,7,11,15,20,22,25});

    }
 // formula to find outer loop condition = (n-(k-1) = n-(4-1) =n-3
    public static void fourSum(int t,int[] a){
        for(int i=0;i<a.length-3;i++){
            for (int j=i+1;j<a.length-2;j++){
                for (int k=j+1;k<a.length-1;k++){
                    for (int l=k+1;l<a.length;l++){
                        int sum= a[i]+a[j]+a[k]+a[l];
                        if(sum == t){
                            System.out.println(a[i]+" "+a[j]+" "+a[k]+" "+a[l]);
                            return;
                        }
                    }
                }

            }
        }
        System.out.println("-1");

    }

    public static void fourPointerSum(int k,int[] a){
        for (int i=0;i<a.length-3;i++){
            for(int j=i+1;j<a.length-2;j++){
                int l =j+1; int r=a.length-1;
                while(l<r){
                    int s= a[i]+a[j]+a[l]+a[r];
                    if(s == k){
                        System.out.println(a[i]+" "+a[j]+" "+a[l]+" "+a[r]);
                        return;
                    } else if (s>k) {
                        r--;
                    }
                    else l++;
                }

            }
        }
        System.out.println("-1");
    }

}
