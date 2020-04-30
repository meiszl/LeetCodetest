package leetCodeTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 快乐数 {
    public static void main(String[] args) {
        int n = 19;
        boolean happy = isHappy(n);
        System.out.println("happy = " + happy);
    }

    /**
     * 计算下一位，然后判断是否与之前的数字重复，最后判断最终能否走到1.
     * 数学方法：可以证明只存在4->16->37->58->89->145->42->20->4
     * 对于 3 位数的数字，它不可能大于 243。这意味着它要么被困在 243 以下的循环内，
     * 要么跌到 1。4 位或 4 位以上的数字在每一步都会丢失一位，直到降到 3 位为止。
     * （因为直到13位的数字每位的平方和才会大于1000）
     * 所以我们知道，最坏的情况下，算法可能会在 243 以下的所有数字上循环，
     * 然后回到它已经到过的一个循环或者回到 1。但它不会无限期地进行下去，
     * 所以我们排除第三种选择。
     *
     *
     * @param n
     * @return
     */
    //数学法去除循环
    private static Set<Integer> cycleMembers =
            new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));

    public static boolean isHappy(int n) {
        //使用HashSet进行循环判断.
//        HashSet<Integer> hashSet = new HashSet<>();
//        while (!hashSet.contains(n) && n != 1){
//            hashSet.add(n);
//            n = getnext(n);
//        }
//        return n == 1;

        //使用快慢指针检查循环
//        int slow = n;
//        int fast = getnext(n);
//        while (slow != 1&& slow != fast){
//            slow = getnext(slow);
//            fast = getnext(getnext(fast));
//        }
//        return slow == 1;
        while (n != 1&& !cycleMembers.contains(n)){
            n = getnext(n);
        }
        return n==1;
    }
    public static int getnext(int n){
        int sum = 0;
        while (n!=0){
            int nu = n%10;
            n = n/10;
            sum += nu*nu;
        }
        return sum;
    }
}
