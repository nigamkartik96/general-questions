class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] min = new int[n];
        min[0] = prices[0];
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(min[i - 1], prices[i]);
        }
        int maxProfit = Integer.MIN_VALUE;
        for (int i = n - 1; i > 0; i--) {
            maxProfit = Math.max(maxProfit, prices[i] - min[i]);
        }

        return maxProfit == Integer.MIN_VALUE ? 0 : maxProfit;
    }
}