package com.omt.learn.algo.allAlgos;

import java.util.Stack;

/**
 * Created by dhpandya on 3/29/17.
 */
public class NextGreaterElement {

    public static void main(String args[]) {
        int a[] = {98, 23, 54, 12, 20, 7, 27};
        int result[] = getNextGreaterElements(a);
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static int[] getNextGreaterElements(int a[]) {
        int nextGreaterElms[] = new int[a.length];
        nextGreaterElms[a.length - 1] = -1;
        Stack<Integer> indexStack = new Stack<>();
        Stack<Integer> greaterElmsStack = new Stack<>();

        greaterElmsStack.push(a[0]);
        indexStack.push(0);

        int index = 1;

        while (index < a.length) {
            while (greaterElmsStack.peek() < a[index]) {
                nextGreaterElms[indexStack.pop()] = a[index];
                greaterElmsStack.pop();
            }

            indexStack.push(index);
            greaterElmsStack.push(a[index]);
            index++;
        }

        while (!indexStack.empty()) {
            nextGreaterElms[indexStack.pop()] = -1;
            greaterElmsStack.pop();
        }
        return nextGreaterElms;
    }
}
