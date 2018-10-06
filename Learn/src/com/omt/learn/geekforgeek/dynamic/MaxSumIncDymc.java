package com.omt.learn.geekforgeek.dynamic;

public class MaxSumIncDymc {

    public static void main(String args[]) {
        //OMT
        int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};
        System.out.println("Max Sum is:"+maxSum(arr));
        
        
        int ar[] = new int[]  {3, 4, 5, 10};
        System.out.println("Max Sum is:"+maxSum(ar));


        int a[] = new int[]  {100, 3, 4, 5, 10};
        System.out.println("Max Sum is:"+maxSum(a));

    }
    
    
    public static int maxSum(int[] a) {
        int maxSum = 0;
        int cache[] = new int[a.length];
        int lastPosition = a.length-1;
        
        cache[lastPosition] = a[lastPosition];
        maxSum = a[lastPosition];
        
        for(int i = a.length-2; i >=0; i--) {
            int tempSum = a[i];
            if(a[i] < a[i+1]){
                tempSum+=cache[i+1]; // Total max sum till i+1;
            }
            maxSum = Math.max(maxSum,tempSum);
            cache[i] = maxSum;
        }
        
        return maxSum;
    }

}
