import java.util.Map;
import java.util.HashMap;



public class ClimbStairs{
  private Map<Integer, Integer> memo;
  // Constructor
  public ClimbStairs() {
    memo = new HashMap<>();
    memo.put(1, 1);
    memo.put(2, 2);

  }

  /**
   * Method for count ways to climb stairs of length n
   * using memoization
   * Complexity O(n)
   * */
  public int climbStairsSolutionMEMO(int n) {
    if (memo.containsKey(n)) {
      return memo.get(n);
    } else {
      memo.put(n, climbStairsSolutionMEMO(n - 1) + climbStairsSolutionMEMO(n - 2));
      return memo.get(n);
    }
  }
}
