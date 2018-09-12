package com.omt.learn.algo.allAlgos;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DivideArryAndUnique {

    public static void main(String args[]) {
        int a[]={3,4,6,6,7,7,7,7,7,7,7,7};
        System.out.println(findMaxUnique(a));
    }


    public static int findMaxUnique(int a[]){
        return Math.min(toSet(a).size(), a.length/2);
    }


    public static Set<Integer> toSet(int a[]){
        Set<Integer> allUniqueNumber = new HashSet<>(a.length);
        for(int i : a){
            allUniqueNumber.add(i);
        }
        return allUniqueNumber;
    }

}
