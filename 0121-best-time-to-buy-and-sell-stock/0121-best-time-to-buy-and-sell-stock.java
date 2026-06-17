class Solution {
    public int maxProfit(int[] prices) 
    {
        int buystock=prices[0];
        int maxprofit=0;

        for(int i=0;i<prices.length;i++)
        {
            buystock=Math.min(buystock,prices[i]);
            maxprofit=Math.max(maxprofit,prices[i]-buystock);
        }

        return maxprofit;
    }
}