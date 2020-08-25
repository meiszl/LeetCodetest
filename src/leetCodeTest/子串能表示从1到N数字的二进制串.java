package leetCodeTest;

public class 子串能表示从1到N数字的二进制串 {
    public static void main(String[] args) {
        String s = "0110";
        int N = 3;
        boolean b = queryString(s, N);
        System.out.println("b = " + b);
    }
    public static boolean queryString(String S, int N) {
        if (S.length() == 0 || N == 0)
            return false;
        for (int i = 1; i <= N; i++) {
            if (!S.contains(Integer.toBinaryString(i)))
                return false;
        }
        return true;
    }
}
