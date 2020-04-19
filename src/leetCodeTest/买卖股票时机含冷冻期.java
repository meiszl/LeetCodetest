package leetCodeTest;


public class 买卖股票时机含冷冻期 {
    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,0,2};
        int i = maxProfit(prices);
        System.out.println("i = " + i);
    }
    public static int maxProfit(int[] prices) {
        if (prices.length == 0|| prices == null) return 0;
        //状态数组，第一位存储天数，第二位存储是否卖出。数组中记录的是当前情况下的利润。
        int[][] res = new int[prices.length][2];//res[i][0]代表未持有股票，即已卖出。res[i][1]代表持有股票，即未卖出。
        int i;
        // 因为当天的股票情况有如下可能，买进与卖出，由题可知，卖出的情况下第二天无法买股票
        // 只能隔一天买。所以需要记录买股票第一天的前两天的持股情况。
        // 当天卖出股票之后无法再次买入所以如果当天卖出股票那么所记录的股票利润
        // 一定是减去之前第二天的股票价格，所以需要记录没买股票之前的前两天的情况，
        // 即没买股票的前一天情况与前两天情况。
        int res_1_0 = 0;//没买股票的前两天未持有股票的利润，因为买卖还未开始所以是0
        int res_2_1 = Integer.MIN_VALUE;//没买股票的前一天持有股票的利润，因为买卖还没开始所以使用极小值规避此情况
        int res_2_0 = 0;//没买股票的前一天未持有股票的利润，因为买卖还没开始所以是0
        for (i=0;i<prices.length;i++){
            if (i == 0){
                res[i][0] = Math.max(res_2_0,res_2_1 + prices[i]);
                res[i][1] = Math.max(res_2_1,res_1_0 - prices[i]);
                continue;
            }
            if (i == 1){
                res[i][0] = Math.max(res[i-1][0],res[i-1][1] + prices[i]);
                res[i][1] = Math.max(res[i-1][1],res_2_0- prices[i]);
                continue;
            }
            res[i][0] = Math.max(res[i-1][0],res[i-1][1] + prices[i]);
            res[i][1] = Math.max(res[i-1][1],res[i-2][0]- prices[i]);
        }
        return res[prices.length - 1][0];
    }
}
