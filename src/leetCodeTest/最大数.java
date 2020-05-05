package leetCodeTest;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 最大数 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,30,34,5,9};
        String s = largestNumber(nums);
        System.out.println("s = " + s);
    }

    /**
     * 使用String自带的比较算法即可找到每一位的最佳位置
     * stream第一版
     * @param nums
     * @return
     */
//    public static String largestNumber(int[] nums) {
//        String[] strs = Arrays.stream(nums).boxed().map(s -> s.toString()).toArray(String[]::new);
//        Arrays.sort(strs,((o1, o2) -> {
//            String s = o1 + o2;
//            String s1 = o2 + o1;
//            return s1.compareTo(s);
//        }));
//        if(strs[0].equals("0"))
//            return "0";
//        String collect = Arrays.stream(strs).collect(Collectors.joining(""));
//        return collect;
//    }

    /**
     * Stream第二版
     * @param nums
     * @return
     */
    public static String largestNumber(int[] nums) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(nums).boxed().map(s->s.toString()).sorted(((o1, o2) -> (o2 + o1).compareTo(o1+o2))).forEach(s->stringBuilder.append(s));
        return stringBuilder.charAt(0) == '0'?"0":stringBuilder.toString();
    }
}
