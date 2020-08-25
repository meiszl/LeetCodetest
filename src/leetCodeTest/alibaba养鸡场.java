package leetCodeTest;

import java.util.PriorityQueue;
import java.util.Scanner;

public class alibaba养鸡场 {
    /**
     *
     * 1，小强有n个养鸡场，弟i个养鸡场初始有a[i]只小鸡。与其他养鸡场不同的是，
     * 他的养鸡场每天增加k只小鸡，小强每天结束都会在数量最多的养鸡场里卖掉一半的小鸡，
     * 假如一个养鸡场有x只鸡，则卖出后只剩下x/2(向下取整)只鸡。问m天后小强的n个养鸡场一共多少只小鸡？
     *
     * 输入
     * 第一行输入三个int类型n,m,k（1 <= n,m,k <= 10^6）
     * 第二行输入n个正整数，表示n个养鸡场初始鸡的个数
     *
     * 输出
     * 输出一个整数表示鸡的总数
     *
     * 输入：
     * 3 3 100
     * 100 200 400
     *
     * 输出：
     * 925
     * @param args
     */
    public static void main(String[] args) {
        int n,m,k;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        long sum = 0,base = 0,t;
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>((o1, o2) -> (int) (o2 - o1));
        for (int i = 0; i < n; i++) {
            t = sc.nextInt();
            priorityQueue.add(t);
            sum += t;
        }
        /**
         * 公式推导：
         * f(x) = (max + i*k)/2 - i*k;
         * f(x) = (max - i*k)/2;
         * 该公式指每次均减去每日新增的数目，
         * 所以最后输出的时候需要加上所有天数新增的数目m*n*k;
         */
        for (int i = 1; i <= m; i++) {
            Long poll = priorityQueue.poll();
            Long tmp = (poll - k*i)/2;
            priorityQueue.add(tmp);
        }
        sum = 0;
        while (priorityQueue.size()>0){
            Long poll = priorityQueue.poll();
            sum += poll;
        }
        System.out.println(sum + n*m*k);
    }

}
