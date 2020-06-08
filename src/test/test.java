package test;

import util.TreeNode;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.*;

public class test {
    public static void main(String[] args) {
        test te = new test();
        int[] test = new int[]{1,4,2,5};
        int i = te.maxProfit(test);
        System.out.println("i = " + i);
    }
    public int maxProfit(int[] prices) {
        int minPrice1 = Integer.MAX_VALUE;
        int maxProfit1 = 0;
        int maxProfitAfterBuy = Integer.MIN_VALUE;
        int maxProfit2 = 0;
        for(int price : prices) {
            // 1.第一次最小购买价格
            minPrice1  = Math.min(minPrice1,  price);

            // 2.第一次卖出的最大利润
            maxProfit1 = Math.max(maxProfit1, price - minPrice1);

            // 3.第二次购买后的剩余净利润
            maxProfitAfterBuy  = Math.max(maxProfitAfterBuy,  maxProfit1 - price );

            // 4.第二次卖出后，总共获得的最大利润（第3步的净利润 + 第4步卖出的股票钱）
            maxProfit2 = Math.max(maxProfit2, price + maxProfitAfterBuy);
            System.out.print(price + " " + minPrice1 + " " + maxProfit1+ " " +maxProfitAfterBuy+ " " +maxProfit2);
            System.out.println();
        }
        return maxProfit2;

    }
    private void sortUsingJava7(List<String> names){
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }
}
