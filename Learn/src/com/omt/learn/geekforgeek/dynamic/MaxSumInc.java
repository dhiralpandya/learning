package com.omt.learn.geekforgeek.dynamic;

public class MaxSumInc {

    public static void main(String args[]) {
        //OMT
        int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};
        System.out.println("Max Sum is:"+maxSum(arr,0));
        
        
        int ar[] = new int[]  {3, 4, 5, 10};
        System.out.println("Max Sum is:"+maxSum(ar,0));


        int a[] = new int[]  {100, 3, 4, 5, 10};
        System.out.println("Max Sum is:"+maxSum(a,0));

    }
    
    
    public static int maxSum(int a[], int start) {
        int maxSum = 0;
        if(start >= a.length) {
            return 0;
        } else if(start == a.length-1) {
            return a[start];
        }
        
        int first = a[start];
        for(int i=start+1;i<a.length;i++) {
            int temp1 = maxSum(a,i);
            if(a[i]>first) {
                temp1 += first;
            }
            maxSum = Math.max(first,Math.max(maxSum,temp1));
        }
        
        return maxSum;
    }

}
