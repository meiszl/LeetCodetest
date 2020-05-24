package test;

import util.TreeNode;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class test {
    public static void main(String[] args) {
//        HashMap<String,String> map = new HashMap();
//        List<String> names1 = new ArrayList<String>();
//        names1.add("Google ");
//        names1.add("Runoob ");
//        names1.add("Taobao ");
//        names1.add("Baidu ");
//        names1.add("Sina ");
//        test tester = new test();
//        tester.sortUsingJava7(names1);
//        System.out.println(names1);
//        int mid = (1 + 1) >>> 1;
//        System.out.println(mid);
//        int left = 0,right = 5;
//        int[] a = new int[]{2,6,5,4,3,1};
//        //插入排序简化版
//        for (int i = left, j = i; i < right; j = ++i) {
//            int ai = a[i + 1];
//            while (ai < a[j]) {
//                a[j + 1] = a[j];
//                System.out.println("Arrays.toString(a) = " + Arrays.toString(a));
//                if (j-- == left) {
//                    break;
//                }
//            }
//            a[j + 1] = ai;
//            System.out.println("Arrays.toString(a) = " + Arrays.toString(a));
//            System.out.println();
//        }
//        String str = "[{床上套件=1}, {烹饪锅具=4}, {杯壶用具=1}, {清洁用品=1}, {家居日用=6}]";
//        StringBuilder stringBuilder = new StringBuilder(str);
//        stringBuilder.deleteCharAt(0);
//        stringBuilder.deleteCharAt(stringBuilder.length()-1);
//        String s = stringBuilder.toString();
//        String[] split = s.split(",");
//        for (int i = 0; i < split.length; i++) {
//            stringBuilder.delete(0,stringBuilder.length() - 1);
//            stringBuilder.append(split[i].trim());
//            stringBuilder.deleteCharAt(0);
//            stringBuilder.deleteCharAt(0);
//            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
//            String s1 = stringBuilder.toString();
//            String[] split1 = s1.split("=");
////            {value:<%split1[1]%>, name:<%split1[0]%>},
//        }
//        String s = "321321321";
//        System.out.println(s.substring(3));
//        int[] a= {7};
//        System.out.println(Arrays.toString(Arrays.copyOfRange(a,1,1)));
//        Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
//        queue.add(-2);
//        queue.add(-1);
//        queue.add(-3);
//        System.out.println("queue = " + queue);
//        System.out.println("queue.poll() = " + queue.poll());
//        String str = "anusyb";
//        char[] chars = str.toCharArray();
//        Character[] characters = new Character[chars.length];
//        for (int i = 0; i < chars.length; i++) {
//            characters[i] = chars[i];
//        }
//        //重写排序比较方法的时候不能使用基础数据类型。
//        Arrays.sort(chars);
//        System.out.println(Arrays.toString(chars));
//        DecimalFormat decimalFormat = new DecimalFormat("0.00");
//        System.out.println("3.0/6.0 = " + decimalFormat.format(200.0 / 6.0));
        //1,5,8,9,10,12,13,16,17,18,19,20,23,24,29
        //3,12,54
//        List<Integer> list = new ArrayList<>();
//        TreeNode treeNode = new TreeNode(0);
//        int i = treeNode.hashCode();
//        System.out.println("i = " + i);
//        priorityQueue1.add(6);
//        System.out.println((priorityQueue.peek() + priorityQueue1.peek()) / 2);
        int ones = 0, twos = 0;
        int[] nums = new int[]{3,3,1,3};
        for (int num : nums) {
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
            System.out.println("ones = " + ones);
            System.out.println("twos = " + twos);
        }

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
