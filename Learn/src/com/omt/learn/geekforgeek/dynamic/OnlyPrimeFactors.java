package com.omt.learn.geekforgeek.dynamic;

import java.util.*;

public class OnlyPrimeFactors {

    public static void main(String args[]) {
        //OMT
        int primeFactors[] = {2, 3, 5};
        System.out.println(findNthNumber(7, primeFactors));
    }


    public static int findNthNumber(int n, int primeFactors[]) {
        List<Integer> storedValues = new ArrayList<>();
        storedValues.add(1);

        int nextCount = 2;

        while (storedValues.size() < n) {
            boolean canInclude = isOnlyConbinationOfPrimeFactors(nextCount, storedValues, primeFactors, 0);
            if (canInclude) {
                storedValues.add(nextCount);
            }
            nextCount++;
        }

        System.out.println(Arrays.toString(storedValues.toArray()));

        return storedValues.get(n - 1);
    }

    public static boolean isOnlyConbinationOfPrimeFactors(int count, List<Integer> alreadyFound, int primeFactors[], int index) {

        if (alreadyFound.contains(count)) {
            return true;
        } else if (index >= primeFactors.length) {
            return false;
            // if it cannot divide with 3 then it much not divide with previous element which is 2
        } else if (count % primeFactors[index] == 0) {
            return isOnlyConbinationOfPrimeFactors(count / primeFactors[index], alreadyFound, primeFactors, index + 1);
        } else {
            return isOnlyConbinationOfPrimeFactors(count, alreadyFound, primeFactors, index + 1);
        }


    }

}
