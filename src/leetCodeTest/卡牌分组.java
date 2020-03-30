package leetCodeTest;


public class 卡牌分组 {
    public static void main(String[] args) {
        int[] deck = new int[]{1,1,1,2,2,2,3,3};
        boolean b = hasGroupsSizeX(deck);
        System.out.println("b = " + b);
    }

    /**
     * 首先统计所有的数字出现的次数，然后求所有出现次数的最大公约数，
     * 如果最大公约数大于等于2则返回true。
     * @param deck
     * @return
     */
    public static boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int c: deck)
            count[c]++;

        int g = -1;
        for (int i = 0; i < 10000; ++i)
            if (count[i] > 0) {
                if (g == -1)
                    g = count[i];
                else
                    g = gcd(g, count[i]);
            }

        return g >= 2;
    }

    public static int gcd(int x, int y) {
        return x == 0 ? y : gcd(y%x, x);
    }

}
