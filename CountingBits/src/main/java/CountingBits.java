public class CountingBits {
  public int[] countingBits(int n) {
    int[] ans = new int[n + 1];
        ans[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            String curr = Integer.toBinaryString(i);
            int counter = 0;
            for (int j = 0; j < curr.length(); j++) {
                if (curr.charAt(j) == '1')
                    counter++;
            }
            ans[i] = counter;
        }
        return ans;
  }
}
