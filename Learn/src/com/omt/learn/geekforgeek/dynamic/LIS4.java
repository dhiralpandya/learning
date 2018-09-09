package com.omt.learn.geekforgeek.dynamic;

import java.util.ArrayList;
import java.util.List;

public class LIS4 {


    public static void main(String... args) {
        int a[] = {3, 10, 2, 1, 20};
        System.out.println(lis(a));

        int b[] = {3, 2};
        System.out.println(lis(b));

        int c[] = {50, 3, 10, 7, 40, 80};
        System.out.println(lis(c));

        int d[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(lis(d));


        int f[] = {0, 8, 4, 12, 2, 10};
        System.out.println(lis(f));


        int e[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        System.out.println(lis(e));
    }

    private static int lis(int a[]) {
        if (a.length == 0) {
            return 0;
        } else if (a.length == 1) {
            return 1;
        }

        List<Integer> lis = new ArrayList<>();
        List<Integer> lastElement = new ArrayList<>();
        lis.add(1);
        lastElement.add(a[0]);

        for (int index = 1; index < a.length; index++) {

            int element = a[index];
            int position = findPosition(element, lastElement);

            if (position == lastElement.size()) { // This means element is biggest, Create new entry in lastElement
                lastElement.add(element);
                lis.add(1 + lis.get(position - 1));
            } else { // Replace in between element with same position.
                lastElement.set(position, element);
                //Since we are replacing element at position, Here no need to set LIS,
            }

            //System.out.println("Lis :" + lis.toString());
            //System.out.println("Element :" + lastElement.toString());
        }

        return lis.get(lis.size() - 1);
    }


    private static int findPosition(int find, List<Integer> lastElement) {
        int position = 0;

        int start = 0;
        int end = lastElement.size() - 1;
        boolean isElementBiggest = true;
        while (start <= end) {
            int middle = (end - start) / 2 + start;
            if (lastElement.get(middle) <= find) {
                position = middle;
                start = middle + 1;
            } else {
                end = middle - 1;
                isElementBiggest = false;
            }
        }

        if (isElementBiggest) {
            position = lastElement.size(); // Means element is biggest, Create new entry in lastElement list
        } else if (lastElement.get(position) < find) { // Replace next biggest element not smallest one,
            // So if element at "position" is "smaller than find_element", Increase position by one
            position++;
            //Example : {1,8,4}
            //Two subjects : {1} and {1,8}
            //Now for element 4 , position will be 0 where 1 < 4 means replace 4 with 8 not with 1
            //Final output : {1} and {1,4}
        }
        return position;
    }


}
