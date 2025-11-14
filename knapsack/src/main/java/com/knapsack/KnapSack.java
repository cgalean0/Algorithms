package com.knapsack;
import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

/**
 * Class that implement the algorithm to the knapSack problem
 * with technique Greedy
 * 
 * @author cgalean0
 * */
public class KnapSack
{
    private static List<String> result;
    public static List<String> knapsackGreedy(Article[] articles, int bagWeight) {
        result = new LinkedList<>();
        return knapsackGreedy(articles, bagWeight, result);
    }

    private static List<String> knapsackGreedy(Article[] articles, int bagWeight, List<String> result) {
        // Sort the array by Values
        Arrays.sort(articles);
        int n = articles.length;
        if (bagWeight <= 0)
            return null;

        for (int i = n - 1;i >= 0; i--) {
            if (bagWeight - articles[i].getWeigth() >= 0) {
                result.add(articles[i].getName()); // Add the name of the product
                bagWeight -= articles[i].getWeigth();
            }
        }

        return result;
    }
}
