package com.omt.learn.leetcode.google;


import java.util.*;

/**
 * 281. Zigzag Iterator
 * <p>
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 * For example, given two 1d vectors:
 * v1 = [1, 2]
 * v2 = [3, 4, 5, 6]
 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3,
 * 2, 4, 5, 6].
 * Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
 * Clarification for the follow up question - Update (2015-09-18):
 * The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases.
 * If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:
 * [1,2,3]
 * [4,5,6,7]
 * [8,9]
 * It should return [1,4,8,2,5,9,3,6,7].
 */
public class ZigzagIterator281 {

    public static void main(String args[]) {
        //OMT


        ZZIterator zz1 = new ZZIterator(getVectors());
        while (zz1.hasNext()) {
            System.out.print(zz1.next() + ",");
        }

        System.out.println();

        zz1 = new ZZIterator(getVectors2());
        while (zz1.hasNext()) {
            System.out.print(zz1.next() + ",");
        }

    }


    static class ZZIterator {

        private List<List<Integer>> oneDV;
        private Queue<Iterator<Integer>> queue = new LinkedList<>();

        public ZZIterator(List<List<Integer>> oneDVectors) {
            this.oneDV = oneDVectors;
            init();
        }

        private void init() {
            oneDV.forEach(v -> queue.add(v.iterator()));
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }

        public int next() {
            Iterator<Integer> iterator = queue.poll();
            int next = iterator.next();

            if (iterator.hasNext()) {
                queue.add(iterator);
            }

            return next;
        }


    }


    private static List<List<Integer>> getVectors() {
        List<Integer> v1 = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
            }
        };

        List<Integer> v2 = new ArrayList<Integer>() {
            {
                add(4);
                add(5);
                add(6);
                add(7);
            }
        };


        List<Integer> v3 = new ArrayList<Integer>() {
            {
                add(8);
                add(9);
                add(10);
            }
        };


        List<List<Integer>> r = new ArrayList<>();
        r.add(v1);
        r.add(v2);
        r.add(v3);
        return r;
    }

    private static List<List<Integer>> getVectors2() {
        List<Integer> v1 = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
            }
        };

        List<Integer> v2 = new ArrayList<Integer>() {
            {
                add(3);
                add(4);
                add(5);
                add(6);
            }
        };


        List<List<Integer>> r = new ArrayList<>();
        r.add(v1);
        r.add(v2);
        return r;
    }

}
