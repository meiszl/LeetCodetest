package leetCodeTest;

public class 二进制间距 {
    public static void main(String[] args) {
        int n = 3;
        int i = binaryGap(n);
        System.out.println(i);
    }
    public static int binaryGap(int N) {
        if (N == 1||N == 0||N == 2)
            return 0;
        String s = Integer.toBinaryString(N);
        System.out.println(s);
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            int cou = 1;
            while (i+1<chars.length&&chars[i+1] != '1'){
                i++;
                cou++;
            }
            if (i==s.length()-1&&chars[i]!='1')
                cou = 0;
            count = Math.max(cou,count);
        }
        return count;
    }
}
