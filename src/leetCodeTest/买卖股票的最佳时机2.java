package leetCodeTest;


public class 买卖股票的最佳时机2 {
    public static void main(String[] args) {
        int prices[] = new int[]{7,1,5,3,6,4};
        final int i = maxProfit(prices);
        System.out.println("i = " + i);
    }

    /**
     * 详解： https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode/
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
