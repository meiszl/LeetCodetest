package test;

import java.util.*;

public class test {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap();
        List<String> names1 = new ArrayList<String>();
        names1.add("Google ");
        names1.add("Runoob ");
        names1.add("Taobao ");
        names1.add("Baidu ");
        names1.add("Sina ");
        test tester = new test();
        tester.sortUsingJava7(names1);
        System.out.println(names1);
        int mid = (1 + 1) >>> 1;
        System.out.println(mid);
        int left = 0,right = 5;
        int[] a = new int[]{2,6,5,4,3,1};
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
