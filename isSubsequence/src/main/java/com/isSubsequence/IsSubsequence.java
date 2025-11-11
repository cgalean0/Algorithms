package com.isSubsequence;
public class IsSubsequence {

	/**
	 * Determine whether s is a subsequence of t using a greedy two-pointer scan.
	 * @param s candidate subsequence
	 * @param t target string
	 * @return true if every character in s appears in t in order (not necessarily contiguous), false otherwise
	 * Time complexity: O(|s| + |t|) Space complexity: O(1)
	 */
	public static boolean isSubsequenceGreedy(String s, String t) {
		int i = 0, j = 0;
		while (i < s.length() && j < t.length()) {
			if (s.charAt(i) == t.charAt(j))
				i++;
			j++;
		}
		return i == s.length();
	}


	/**
	 * Check whether string s is a subsequence of string t using dynamic programming.
	 * @param s the candidate subsequence
	 * @param t the target string
	 * @return true if s is a subsequence of t, false otherwise
	 * Time complexity: O(|s| * |t|), Space complexity: O(|s| * |t|)
	 */
	public static boolean isSubsequenceDP(String s, String t) {
		int n = s.length(), m = t.length();
		int[][] dp = new int[n + 1][m + 1];

		// Complete the base cases
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 0;
		}
		for (int j = 0; j <= m; j++) {
			dp[0][j] = 0;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s.charAt(i - 1) == t.charAt(j - 1)) { // is -1 because the index start in 0.
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = dp[i][j - 1];
				}
			}
		}
		return dp[n][m] == n;
	}

}