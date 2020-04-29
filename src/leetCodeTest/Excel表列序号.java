package leetCodeTest;

public class Excel表列序号 {
    public static void main(String[] args) {
        String s = "ZY";
        int i = titleToNumber(s);
        System.out.println("i = " + i);
    }
    public static int titleToNumber(String s) {
        if (s == null || s.length() == 0)return 0;
        int res = 0,j = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            int num = s.charAt(i) - 'A' + 1;
            res += (num) *(Math.pow(26,j++));
        }
        return res;
    }
}
