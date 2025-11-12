/**
 * This algorithm solve the problem (121 Best Time to Buy and Sell Stock)
 * of leetCode page.
 * */
package com.maxprofitproblem;
public class MaxProfit {
  

  /**
   * This solution improve a decrease and conquer technique
   * it's very ineficient
   * Complexity O(n²)
   * */
  public static int maxProfit(int[] prices) {
    Integer maxCurrentProfit = Integer.MIN_VALUE;
    for (int i = 0; i < prices.length - 1; i++) {
      for (int j = i+1; j < prices.length; j++) {
        maxCurrentProfit = Math.max(maxCurrentProfit, (prices[j] - prices[i]));
      }
    }
    return maxCurrentProfit < 0 ? 0 : maxCurrentProfit;
  }

  /**
   * This is a simple improvement for the previous algorithm
   * complexity O(n)
   * */
  public static int maxProfitEfficient(int[] prices) {
    Integer maxCurrentProfit = Integer.MIN_VALUE;
    int minPrice = prices[0];
    for (int i = 1; i < prices.length; i++) {
      // Find a new best price of Buy
      if (prices[i] < minPrice)
        minPrice = prices[i];

      int newProfit = (prices[i] - minPrice);
      if (maxCurrentProfit < newProfit) {
        maxCurrentProfit = newProfit;
      }
    }
    return maxCurrentProfit;
  }
}
