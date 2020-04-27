package leetCodeTest;


public class 解码方法 {
    public static void main(String[] args) {
        String s = "01";
        int i = numDecodings(s);
        System.out.println("i = " + i);
    }
    public static int numDecodings(String s) {
        if(s.length() == 1) return s.charAt(0) == '0'?0:1;
        char[] sc = s.toCharArray();
        int[] sum = new int[s.length()];
        sum[0] = 1;
        for (int i = 1; i < sc.length; i++) {
            if (sc[i] == '0'){
                if (sc[i-1] == '0')
                    sum[i] = sum[i-1] - 1;
//                else if (sc[i-1] <= '2')
//                    sum[i] = sum[i-1] + 1;
                else
                    sum[i] = sum[i-1];
            }else if (sc[i] <= '6'){
                if (sc[i-1] == '0')
                    sum[i] = sum[i-1] - 1;
                else if (sc[i-1] <= '2')
                    sum[i] = sum[i-1]+1;
                else
                    sum[i] = sum[i-1];
            }else {
                if (sc[i-1] == '0')
                    sum[i] = sum[i-1] - 1;
                else if (sc[i-1] == '1')
                    sum[i] = sum[i-1] + 1;
                else
                    sum[i] = sum[i-1];
            }
        }
        return sum[s.length()-1];
    }
}
