package leetCodeTest;

public class 阶乘后的0 {
    public static void main(String[] args) {
        int n = 3;
        int i = trailingZeroes(n);
        System.out.println("i = " + i);
    }
    public static int trailingZeroes(int n) {
        int count = 0;
        while (n>0){
            count += n/5;
            n=n/5;
        }
        return count;
    }
}
