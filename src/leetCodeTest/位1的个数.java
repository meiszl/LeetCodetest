package leetCodeTest;

public class 位1的个数 {
    public static void main(String[] args) {
        int n = 11;
        int i = hammingWeight(n);
        System.out.println("i = " + i);
    }
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            if ((n&1) == 1)
                count++;
            n = n >>> 1;
        }
        return count;
    }
}
