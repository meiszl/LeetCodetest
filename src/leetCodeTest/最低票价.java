package leetCodeTest;


import java.util.Arrays;

public class 最低票价 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,4,6,7,8,20};
        int[] cost = new int[]{2,7,15};
        int exampl = mincostTickets(nums, cost);
        System.out.println("exampl = " + exampl);
    }

    /**
     * 动态规划
     * @param days
     * @param costs
     * @return
     */
    public static int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0) return 0;
        int last = days[days.length - 1];
        int[] sum = new int[last + 1];
        int fla = 0;
        int i;
        int day1,day2,day3;
        for (i=1;i<sum.length;i++){
            if (i == days[fla]){
                day1 = i-1;
                day2 = i-7>0?i-7:0;
                day3 = i-30>0?i-30:0;
                sum[i] = Math.min(sum[day1] + costs[0],Math.min(sum[day2] + costs[1],sum[day3] + costs[2]));
                fla++;
            }else {
                sum[i] = sum[i-1];
            }
        }
        return sum[last];
    }
}
