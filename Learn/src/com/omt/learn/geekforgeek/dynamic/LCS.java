package com.omt.learn.geekforgeek.dynamic;

public class LCS {


    public static void main(String... args) {

        String p = "AXYZ";
        String q = "AYZ";
        System.out.println(LCS(p, q, 0, 0));

        p = "AGGTAB";
        q = "GXTXAYB";
        System.out.println(LCS(p, q, 0, 0));


        //Below algorithm will same as above but not going to work.
        //System.out.println(LCSThisWillNotWork(p, q, 0, 0));

    }

    /**
     * Make sure you should use pNext+1 instead of pNext++ to avoid actual object modification.
     */
    public static int LCS(String p, String q, int pNext, int qNext) {

        if (p.length() <= pNext || q.length() <= qNext) {
            return 0;
        }

        if (p.charAt(pNext) == q.charAt(qNext)) {
            return 1 + LCS(p, q, pNext + 1, qNext + 1);
        } else {
            return Math.max(LCS(p, q, pNext, qNext + 1), LCS(p, q, pNext + 1, qNext));
        }
    }


    /**
     * Below algorithm is identical to above but not going to work at all,
     * Because of pNext++ instead of pNext+1,
     * Java will update the actual object in case of pNext++
     */
    public static int LCSThisWillNotWork(String p, String q, int pNext, int qNext) {

        if (p.length() <= pNext || q.length() <= qNext) {
            return 0;
        }

        if (p.charAt(pNext) == q.charAt(qNext)) {
            return 1 + LCSThisWillNotWork(p, q, ++pNext, ++qNext);
        } else {
            return Math.max(LCSThisWillNotWork(p, q, pNext, ++qNext), LCSThisWillNotWork(p, q, ++pNext, qNext));
        }
    }
}
