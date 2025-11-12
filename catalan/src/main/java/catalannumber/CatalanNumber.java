package catalannumber;

import java.util.HashMap;
import java.util.Map;




/**
 * The {@code CatalanNumber} class provides different methods to compute
 * the n-th Catalan number, a sequence of natural numbers that have many applications
 * in combinatorial mathematics.
 * 
 * This class includes implementations using plain recursion, dynamic programming (DP),
 * and memoization.
 * 
 * Catalan numbers follow the recurrence relation:
 * Cₙ = Σ (Cₖ₋₁ * Cₙ₋ₖ) for k = 1 to n, with C₀ = 1
 * 
 * Example of Catalan numbers: 1, 1, 2, 5, 14, 42, 132, ...
 */
public class CatalanNumber {
    // Map to use memoization
    private static HashMap<Integer, Long> memo = new HashMap<>();

    /**
     * Computes the n-th Catalan number using a plain recursive approach.
     * 
     * This implementation has exponential time complexity due to redundant subproblem computation.
     * 
     * @param n the index of the Catalan number to compute (n ≥ 0)
     * @return the n-th Catalan number
     */

    public static long computeCatalanNumber(int n){
        if (n == 0) return 1;
        long partialSum = 0;
        for (int i = 0; i < n; i++) {
            partialSum+= computeCatalanNumber(i) * computeCatalanNumber(n - 1 - i);
        }
        return partialSum;
    }

    /**
     * Computes the n-th Catalan number using dynamic programming (DP).
     * 
     * This implementation avoids redundant computation by storing intermediate results
     * in a bottom-up manner. 
     * 
     * @param n the index of the Catalan number to compute (n ≥ 0)
     * @return the n-th Catalan number
     */
    public static long computeCatalanNumberPD(int n){
        long[] arr = new long[n + 1];

        // Catalán de 0 = 1
        arr[0] = 1;
        // Programación Dinámica para almacenar los resultados
        for (int i = 1; i <= n; i++) {
            arr[i] = 0;
            for (int j = 0; j < i; j++) {
                arr[i] += arr[j] * arr[i - 1 - j];
            }
        }

        return arr[n];
    }


    /**
     * Computes the n-th Catalan number using memoization (top-down dynamic programming).
     * 
     * This implementation improves the basic recursive version by caching results
     * of subproblems to avoid redundant calculations. 
     * 
     * @param n the index of the Catalan number to compute (n ≥ 0)
     * @return the n-th Catalan number
     */
    public static long computeCatalanNumberMemo(int n){
        memo.put(0,1L); // Catalan of 0 is 1.
        return calculeCatalanHelper(n);
    }

    private static long calculeCatalanHelper(int target) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }

        long partialSum = 0;
        for (int i = 0; i < target; i++) {
            partialSum += calculeCatalanHelper(i) * calculeCatalanHelper(target - 1 - i);
        }
    
        // Save te partialSum (Memoization)
        memo.put(target, partialSum);
        return partialSum;
    }

}
