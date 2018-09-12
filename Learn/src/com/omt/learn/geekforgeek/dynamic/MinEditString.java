package com.omt.learn.geekforgeek.dynamic;

import java.util.HashMap;
import java.util.Map;

public class MinEditString {

    public static void  main(String...args){

        String p = "AYZ";
        String q = "AXYZ";


        System.out.println("Min edit "+minEditRequire(p,q,0,0)+" required to make "+p+" like "+q+" ");
        System.out.println("Min edit "+minEditRequireWithCache(p,q,0,0,new HashMap<>())+" required to make "+p+" like "+q+" ");


        p = "CAT";
        q = "CUT";


        System.out.println("Min edit "+minEditRequire(p,q,0,0)+" required to make "+p+" like "+q+" ");
        System.out.println("Min edit "+minEditRequireWithCache(p,q,0,0,new HashMap<>())+" required to make "+p+" like "+q+" ");


        p = "SUNDAY";
        q = "SATURDAY";


        System.out.println("Min edit "+minEditRequire(p,q,0,0)+" required to make "+p+" like "+q+" ");
        System.out.println("Min edit "+minEditRequireWithCache(p,q,0,0,new HashMap<>())+" required to make "+p+" like "+q+" ");

    }



    public static int minEditRequire(String p, String q, int pNext, int qNext) {

        if(p.length() <= pNext && q.length() <= qNext) {
            return 0;
        }else if(p.length() <= pNext || q.length() <= qNext) {
            return Math.max(p.length(),q.length()) - Math.min(p.length(),q.length());
        }

        if(p.charAt(pNext) == q.charAt(qNext)) {
            return minEditRequire(p,q, pNext+1,qNext+1);
        } else {
            //Check all three conditions, INSERT, UPDATE, DELETE

            //INSERT
            int minEditForInsert = 1+minEditRequire(p,q,pNext,qNext+1);

            //UPDATE
            int minEditForUpdate = 1+minEditRequire(p,q,pNext+1,qNext+1);

            // DELETE
            int minEditForDelete = 1+minEditRequire(p,q,pNext+1,qNext);

            return Math.min(Math.min(minEditForInsert,minEditForUpdate),minEditForDelete);

        }
    }


    public static int minEditRequireWithCache(String p, String q, int pNext, int qNext, Map<String,Integer> CACHE) {

        final String cacheKey = pNext+"-"+qNext;

        if(CACHE.containsKey(cacheKey)) {
            return CACHE.get(cacheKey);
        } else if(p.length() <= pNext && q.length() <= qNext) {
            CACHE.put(cacheKey,0);
            return 0;
        }else if(p.length() <= pNext || q.length() <= qNext) {
            int min = Math.max(p.length(),q.length()) - Math.min(p.length(),q.length());
            CACHE.put(cacheKey,min);
            return min;
        }

        if(p.charAt(pNext) == q.charAt(qNext)) {
            int min = minEditRequireWithCache(p,q, pNext+1,qNext+1,CACHE);
            CACHE.put(cacheKey,min);
            return min;
        } else {
            //Check all three conditions, INSERT, UPDATE, DELETE

            //INSERT
            int minEditForInsert = 1+minEditRequireWithCache(p,q,pNext,qNext+1,CACHE);

            //UPDATE
            int minEditForUpdate = 1+minEditRequireWithCache(p,q,pNext+1,qNext+1,CACHE);

            // DELETE
            int minEditForDelete = 1+minEditRequireWithCache(p,q,pNext+1,qNext,CACHE);

            int min = Math.min(Math.min(minEditForInsert,minEditForUpdate),minEditForDelete);
            CACHE.put(cacheKey,min);
            return min;
        }
    }


}
