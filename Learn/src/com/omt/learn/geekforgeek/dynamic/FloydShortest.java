package com.omt.learn.geekforgeek.dynamic;

import com.omt.learn.algo.util.matrix.MatrixUtil;

import java.util.Arrays;

public class FloydShortest {

    public static void main(String args[]) {
        int INF = 1000000;
        int graph[][] = {{0, 5, INF, 10},
                {INF, 0, 3, INF},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}
        };

        MatrixUtil.printMatrix(shortestPath(graph));

    }


    public static int[][] shortestPath(int[][] graph) {

        int dist[][] = new int[graph.length][graph.length];

        for (int i = 0; i < graph.length; i++) {
            dist[i] = Arrays.copyOf(graph[i], graph.length);
        }

        for (int middle = 0; middle < graph.length; middle++) {
            for (int left = 0; left < graph.length; left++) {
                for (int right = 0; right < graph.length; right++) {
                    //We want to find best path from Left to Right through middle or without middle
                    // LEFT to RIGHT
                    int LEFT_TO_RIGHT = dist[left][right];
                    int LEFT_MIDDLE_RIGHT = dist[left][middle] + dist[middle][right];
                    
                    dist[left][right] = Math.min(LEFT_TO_RIGHT, LEFT_MIDDLE_RIGHT);
                }
            }
        }

        return dist;
    }

}
