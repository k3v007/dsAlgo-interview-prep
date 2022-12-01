package org.example.dsAlgo.dp;

public class BestTimeToBuyandSellStock {
    
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int leftGloblaMinima = prices[0];

        for (int i = 1; i < prices.length; i++) {
            leftGloblaMinima = Math.min(prices[i], leftGloblaMinima);
            int potentialProfit = prices[i] - leftGloblaMinima;
            maxProfit = Math.max(maxProfit, potentialProfit);
        }
        return maxProfit;
    }
}
