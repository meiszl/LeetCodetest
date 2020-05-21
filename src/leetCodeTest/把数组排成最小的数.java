package leetCodeTest;

import java.util.Arrays;

public class 把数组排成最小的数 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,30,34,5,9};
        String s = minNumber(nums);
        System.out.println("s = " + s);
    }
    public static String minNumber(int[] nums) {
        Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(integers,((o1, o2) -> {
            String s = String.valueOf(o1);
            String s1 = String.valueOf(o2);
            return (s+s1).compareTo(s1+s);
        }));
        StringBuilder builder = new StringBuilder();
        Arrays.stream(integers).forEach((in) -> {
            builder.append(in);
        });
        return builder.toString();
    }
}
