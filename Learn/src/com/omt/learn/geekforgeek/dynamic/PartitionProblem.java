package com.omt.learn.geekforgeek.dynamic;

public class PartitionProblem {

    public static void main(String args[]) {
        int arr[] = {1, 5, 11, 5};
        System.out.println(canDivideInTwo(arr));

        int arr2[] = {1, 5, 3};
        System.out.println(canDivideInTwo(arr2));

        int arr3[] = {7,7,7,1};
        System.out.println(canDivideInTwo(arr3));

        int arr4[] = {3, 1, 5, 9, 12};
        System.out.println(canDivideInTwo(arr4));

        int arr5[] = {3, 1, 1, 2, 2,1};
        System.out.println(canDivideInTwo(arr5));
    }
    
    public static boolean canDivideInTwo(int a[]){
    
        int totalSum = 0;
        for(int i : a){
            totalSum+=i;
        }
        
        if(totalSum%2 > 0){
            return false;
        }
        
        return canDivideInTwo(a,0,totalSum/2);
    }
    
    
    public static boolean canDivideInTwo(int a[], int start, int remainingSum){
        
        
        if(start >= a.length || remainingSum < 0) {
            return false; 
        } else if(remainingSum == 0) {
            return true;
        }
        
        int currentValue = a[start];
        
        boolean ifConsuderStart = canDivideInTwo(a,start+1,remainingSum-currentValue);
        boolean ifSkipStart = canDivideInTwo(a,start+1,remainingSum);
        
        return ifConsuderStart || ifSkipStart;
    }
    
    
    
    

}
