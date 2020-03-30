package leetCodeTest;


import java.util.ArrayList;
import java.util.List;

public class 圆圈中最后剩下的数字 {
    public static void main(String[] args) {
        int i = lastRemaining(10, 17);
        System.out.println("i = " + i);
    }

    /**
     * 使用List容器保存数据，然后计算删除的位置。由于删除之后数组会向前移一位
     * 所以位置为当前位置+m-1，同时还需要考虑超出数组范围所以需要加上%n。
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (n > 1) {
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }
}
