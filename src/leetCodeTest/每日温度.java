package leetCodeTest;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class 每日温度 {
    public static void main(String[] args) {
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = dailyTemperatures(T);
        System.out.println("Arrays.toString(in) = " + Arrays.toString(ints));
    }

    /**
     * 暴力法
     * @param T
     * @return
     */
//    public static int[] dailyTemperatures(int[] T) {
//        int[] res = new int[T.length];
//        for (int i = 0; i < T.length; i++) {
//            for (int j = i+1; j < T.length; j++) {
//                if (T[j] > T[i]){
//                    res[i] = j-i;
//                    break;
//                }
//            }
//        }
//        return res;
//    }

    /**
     * 栈存储下标
     * @param T
     * @return
     */
    public static int[] dailyTemperatures(int[] T) {
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--) {
            while (!deque.isEmpty()&& T[i] >= T[deque.peekFirst()])deque.pollFirst();
            res[i] = deque.isEmpty()?0: deque.peekFirst() - i;
            deque.offerFirst(i);
        }
        return res;
    }
}
