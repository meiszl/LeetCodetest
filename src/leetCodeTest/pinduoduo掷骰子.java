package leetCodeTest;

import java.util.*;

public class pinduoduo掷骰子 {
    /**
     * 掷n个不同面数的骰子，以最大点数为结果，求点数的期望。一共有n个骰子
     * 第i个骰子面数为ni，点数为[1,ni]，每个面的概率相同,同时掷这n个骰子，
     *
     * 所有骰子中的最大点数为最终点数,求骰子投出的期望值
     *
     * 输入
     * 2
     * 2 2
     *
     * 输出
     * 1.75
     *
     * 输入
     * 4
     * 1 2 3 4
     * 输出
     * 2.875
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int []arr = new int[number];
        for(int i = 0; i < number; i++) arr[i] = sc.nextInt();
        int maxNumber = 0;

        //获取最大面数
        for(int i = 0; i < number; i++) {
            if (maxNumber < arr[i]) maxNumber = arr[i];
        }

        //result存储最后结果，temp存储临时结果
        double [] result =  new double[maxNumber+1];
        double [] temp  = new double[maxNumber+1];
        for(int i = 0; i <= maxNumber; i++) {
            result[i] = 0; temp[i] = 0;
        }

        //第一个色子
        for(int i = 1; i <= arr[0]; i++) result[i] = 1.0 / arr[0];
        for(int i = 1; i <= arr[0]; i++) temp[i] = 1.0 / arr[0];

        //递推
        for(int i = 1; i < number; i++) {
            for(int j = 1; j <= arr[i]; j++) {
                //第一种情况 + 第二种情况
                result[j] = sum(temp, j-1) * (1.0/arr[i]) + temp[j] * j *(1.0/arr[i]);
            }
            for(int t = 1; t <= maxNumber; t++) temp[t] = result[t];
        }

        double finalResult = 0;
        for(int i = 1; i <= maxNumber; i++) finalResult += i * result[i];

        sc.close();
        System.out.println(finalResult);
    }
    public static double sum(double[] arr,int index){
        double total = 0;
        for (int i = 1; i <= index; i++) {
            total += arr[i];
        }
        return total;
    }
}
