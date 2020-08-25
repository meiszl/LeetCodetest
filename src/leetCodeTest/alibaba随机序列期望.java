package leetCodeTest;

import java.util.Deque;
import java.util.Scanner;

public class alibaba随机序列期望 {

    /**
     * 小强得到了长度为n的序列，但他只对非常大的数字感兴趣，
     * 因此随机选择这个序列的一个连续子序列，
     * 并求这个序列的最大值，请告诉他这个最大值的期望是多少?
     *
     * 输入
     * 第一行n表示序列长度接下来一行n个数描述这个序列，
     * n大于等于1小于等于1000000，
     * 数字保证是正整数且不超过100000
     * 第二行n个数字表示序列的值
     *
     * 输出
     * 保留6位小数
     *
     * 样例
     * 输入：
     * 3
     * 1 2 3
     *
     * 输出：
     * 2.333333
     *
     * 解释：
     * {1},{2},{3},{1,2},{2,3},{1,2,3}为所有子序列，
     * 1最大的概率1/6，2最大的概率为2/6，3最大概率3/6，
     * 期望14/6
     * @param args
     */
    public static void main(String[] args) {
        int n,t;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        long c = n*(n+1)/2;
        int[] dp = new int[1000006];
    }

}
