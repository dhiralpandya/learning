package com.omt.learn.algo.allAlgos;

/**
 * Created by omt on 3/23/17.
 */
public class FindPeakElmFromArray {

    public static void main(String args[]) {

        int a[] = {30,45,60,20,30,15,9,80};
        //60, 30, 80
        System.out.println(findOnePeakElement(a, 0, a.length-1));
    }


    private static int findOnePeakElement(int a[], int start, int end) {

        while(start <= end) {
            int mid = (start+end)/2;
            if(mid-1 >= start && a[mid] < a[mid-1]) {
                end = mid-1;
            } else if(mid+1 <= end && a[mid] < a[mid+1])  {
                start = mid+1;
            } else {
                return a[mid];
            }
        }

        return  -1;
    }

}
