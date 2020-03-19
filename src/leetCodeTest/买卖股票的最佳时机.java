package leetCodeTest;

public class 买卖股票的最佳时机 {

    public static void main(String[] args) {
        int prices[] = {7,1,5,3,6,4};
        final int i = maxProfit(prices);
        System.out.println("i = " + i);
    }

    /**
     * 传统方法使用双循环嵌套查询。
     * 因为需要找到当前位置与之前位置的差的最小值，所以使用双循环即可找到最佳答案。
     * @param prices
     * @return
     */
//    public static int maxProfit(int[] prices) {
//        int i,j;
//        int temp = 0;
//        int te;
//        for (i = 0;i<prices.length;i++){
//            for (j = 0;j<i;j++){
//                te = prices[i] - prices[j];
//                if (te > temp){
//                    temp = te;
//                }
//            }
//        }
//        int result = temp;
//        return result;
//    }

    /**
     * 升级版方法，单循环查找。
     * 因为只需要知道差值的大小即可，所以只需要用当前位置的值减去之前位置的最小值就可以找到最佳答案
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int i;
        int min = 0;
        int temp = 0;
        int inmin = Integer.MIN_VALUE;
        for (i = 0;i<prices.length;i++){
            if(prices[i] < min && inmin < i){
                min = prices[i];
                inmin = i;
            }
            if (prices[i] - min > temp)
                temp = prices[i] - min;
        }
        return temp;
    }
}
