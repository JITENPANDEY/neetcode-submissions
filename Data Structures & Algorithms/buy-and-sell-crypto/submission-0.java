class Solution {
    public int maxProfit(int[] prices) {
        int mini = prices[0], profit = 0;
        for(int i = 0;i<prices.length;i++){
            profit = Math.max(profit, prices[i] - mini);
            mini = Math.min(mini, prices[i]);
        }
        return profit;
    }
}
