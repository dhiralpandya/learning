package com.omt.learn.geekforgeek.dynamic;

import java.util.HashMap;
import java.util.Map;

public class MinCostPath {

    public static void main(String... args) {
        int cost[][] = {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};

        System.out.println("Min Cost:" + minCost(cost, 0, 0, 2, 2));
        System.out.println("Min Cost:" + minCostWithCache(cost, 0, 0, 2, 2, new HashMap<String, Integer>()));

    }

    public static int minCost(int[][] cost, int i, int j, int di, int dj) {

        if (i == di && j == dj) {
            return cost[di][dj];
        } else if (i > di || j > dj) {
            return Integer.MAX_VALUE;
        }

        int currentCost = cost[i][j];
        int minCostofDown = minCost(cost, i + 1, j, di, dj);
        int minCostOfRight = minCost(cost, i, j + 1, di, dj);
        int minCostOfDiagonal = minCost(cost, i + 1, j + 1, di, dj);


        return currentCost + (Math.min(minCostofDown, Math.min(minCostOfRight, minCostOfDiagonal)));

    }

    public static int minCostWithCache(int[][] cost, int i, int j, int di, int dj, Map<String, Integer> CACHE) {

        String cacheKey = i + "-" + j;
        if (i == di && j == dj) {
            CACHE.put(cacheKey, cost[di][dj]);
            return cost[di][dj];
        } else if (i > di || j > dj) {
            return Integer.MAX_VALUE;
        }

        int currentCost = cost[i][j];
        int minCostofDown = minCost(cost, i + 1, j, di, dj);
        int minCostOfRight = minCost(cost, i, j + 1, di, dj);
        int minCostOfDiagonal = minCost(cost, i + 1, j + 1, di, dj);


        if (CACHE.containsKey(cacheKey)) {
            return CACHE.get(cacheKey);
        }

        int minCost = currentCost + (Math.min(minCostofDown, Math.min(minCostOfRight, minCostOfDiagonal)));
        CACHE.put(cacheKey, minCost);
        return minCost;

    }
}
