package com.changemakingproblem;

import java.util.*;
/**
 * Algorithms to solve the change making problem
 * 
 * @author cgalean0
 * */
public class ChangeMaking 
{
    /**
     * This algorithm use the technique Divide and Conquer to solve
     * the problem but it's very inefficient
     * */
    public static int changemakingproblemDivideAndConquer(int[] coinsValues, int C) {
        return minCoins(coinsValues, C);        
    }
    /**
     * auxiliar method to compute the minimun coins to solve the problem
     * */
    private static int minCoins(int[] denominatios, int change) {
        if (change == 0)
            return 0;
        Integer min = Integer.MAX_VALUE;
        int n = denominatios.length;
        for (int i = 0;i < n; i++) {
            if (denominatios[i] <= change) {
                min = Math.min(min, 1 + minCoins(denominatios, change - denominatios[i]));
            }
        }
        return min;
    }


    /**
     * Algorithm that use the Dynamic Programming technique
     * to solve more efficient this problem
     * Assume that the Array coinsValues must be Sorted in non decreasing order
     * */
     public static int changemakingproblemPD(int[] coinsValues, int C) {
        return minCoinsPD(coinsValues, C);
     }


     private static int minCoinsPD(int[] denominations, int c) {
        if (c < 0) return -1;

        int[] pd = new int[c + 1];
        Arrays.fill(pd, c + 1);
        pd[0] = 0;

        for (int i = 1; i <= c; i++) {
            for (int m : denominations) {
                if (m <= i) {
                    if (pd[i - m] != c + 1) {
                        pd[i] = Math.min(pd[i], 1 + pd[i - m]);
                    }
                }
            }
        }

        return (pd[c] != c + 1 ? pd[c] : -1);
     }
}
