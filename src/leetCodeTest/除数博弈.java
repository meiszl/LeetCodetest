package leetCodeTest;


public class 除数博弈 {
    public static void main(String[] args) {
        int N = 3;
        boolean b = divisorGame(N);
        System.out.println("b = " + b);
    }

    /**
     * 该题考虑两个关键信息，
     * 第一个就是当前位置往前遍历，找到某一个可以整除当前N值的约数，
     * 并且还需要考虑N减去该约数之后不能让另外一个人获胜。
     * dp数组记录的应该是当N为i的时候开始操作会不会获胜，
     * 两个关键信息：当N=1时先走输。当N=2时先走赢。
     * @param N
     * @return
     */
    public static boolean divisorGame(int N) {
        if (N == 1)
            return false;
        if (N==2)
            return true;
        int i,j;
        boolean[] dp = new boolean[N+1];//用来存放，当N=i的时候（i为当前dp下标）开始进行游戏能不能赢
        dp[1] = false;//N=1的位置开始时会输。
        dp[2] = true;//N=2的位置开始时会赢
        for (i=3;i<=N;i++){
            dp[i] = false;
            for (j=1;j<i;j++){
                //当在N=i的前面存在约数，并且N=i-j（j就是这个约数）的时候
                // 开始不会赢，就说明减去该约数可以取得胜利，就将该位置的dp值改为true
                if ((i%j) == 0 && !dp[i-j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        //返回最末尾的输赢情况
        return dp[N];
    }
}
