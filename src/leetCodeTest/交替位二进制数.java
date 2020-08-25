package leetCodeTest;

public class 交替位二进制数 {
    public static void main(String[] args) {
        int n = 2;
        boolean b = hasAlternatingBits(n);
        System.out.println("b = " + b);
    }
    public static boolean hasAlternatingBits(int n) {
        if (n == 0||n == 1)
            return true;
        int pre;
        while (n != 0){
            pre = n&1;
            n = n >>> 1;
            if (pre == (n&1))
                return false;
        }
        return true;
    }
}
