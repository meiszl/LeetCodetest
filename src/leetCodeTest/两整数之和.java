package leetCodeTest;

public class 两整数之和 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int sum = getSum(a, b);
        System.out.println("sum = " + sum);
    }
    public static int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        int lower = 0;
        int carrier = 0;
        while (true){
            lower = a^b;
            carrier = a&b;
            if (carrier == 0)break;
            a = lower;
            b = carrier << 1;
        }
        return lower;
    }
}
