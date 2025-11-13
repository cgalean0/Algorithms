package com.assignCookies;
import java.util.Arrays;
public class AssignCookies {
  /**
   * The goal of this problem is Maximize the number of content childrens
   * you should give each children at most one cookie
   * @param g is the greed factor of each children
   * @param s is the size of the cookies
   * in the worst case this algorithm complexity is O(N log n + M log m)
   * */
  public static int assignCookies(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int i = 0, j = 0, contentChildrens = 0;
    while (i < g.length && j < s.length) {
      if (g[i] <= s[j]){
        contentChildrens++;
        i++;
      }
      j++;
    }
    return contentChildrens;
  }
}
