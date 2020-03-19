package leetCodeTest;

import java.util.Arrays;

public class 零钱兑换 {

    public static void main(String[] args) {
        int coins[] = {186,419,83,408};
        int amount = 6249;
        int result = coinChange(coins,amount);
        System.out.println("result = " + result);
    }

    /**
     * DFS 搜索顺序为面值从大到小，同一面值数量由多到少，搜索过程中记录到此为止所花费的硬币数。
     *
     * 剪枝处理如下，具体位置见代码注释：
     *
     * 当 amount==0 时剪枝，因为大面值硬币需要更多小面值硬币替换，
     * 继续减少一枚或几枚大硬币搜索出来的答案【如果有】肯定不会更优。
     *
     * 当 amount!=0，但已经使用的硬币数 cnt 满足了 cnt+1>=ans 时剪枝，
     * 因 amount 不为 0，至少还要使用 1 枚硬币，则继续搜索得到的答案不会更优。
     * 是 break 不是 continue，因为少用几枚面值大的硬币搜索出的方案【如果有】
     * 肯定需要更多枚面值小的硬币来替换掉这枚大的硬币【同剪枝 1 理由】，
     * 而使用这几枚大的硬币都搜索不到更好的解，故应该是 break。
     *
     * 作者：iejepwy
     * 链接：https://leetcode-cn.com/problems/coin-change/solution/dfsjian-zhi-2ms-ji-bai-100bi-dphuan-kuai-by-iejepw/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    static int  ans=Integer.MAX_VALUE;
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        dfs(coins,coins.length-1,amount,0);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public static void dfs(int[] coins,int index,int amount,int cnt){
        if(index<0){
            return;
        }
        for(int c=amount/coins[index];c>=0;c--){
            int na=amount-c*coins[index]; //计算还剩下多少金额需要被其余的coin瓜分，这里调用的传入参数amount所以不会受到循环内部变量na的影响
            int ncnt=cnt+c;// 计算循环迭代到此时总使用coin的数量
            if(na==0){
                ans=Math.min(ans,ncnt);
                break;//剪枝1
            }
            if(ncnt+1>=ans){
                break; //剪枝2
            }
            dfs(coins,index-1,na,ncnt);
        }
    }
}
