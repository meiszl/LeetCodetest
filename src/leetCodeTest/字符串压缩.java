package leetCodeTest;


public class 字符串压缩 {
    public static void main(String[] args) {
        String s = new String("aabcccccaaa");
        final String s1 = compressString(s);
        System.out.println("s1 = " + s1);
    }

    /**
     * 思路将字符串一个一个分割成char，然后分别计算与上一位是否相等，如果相等的话，就将统计值+1.
     * 最后使用StringBuilder将char与统计值串联在一起。
     * @param S
     * @return
     */
    public static String compressString(String S) {
        if (S.length() <= 1){
            return S;
        }
        int i,num = 1;
        char a = S.charAt(0);
        StringBuilder str = new StringBuilder();
        for (i = 1;i<S.length();i++){
            if (a == S.charAt(i)){
                num++;
            }else {
                str.append(a);
                str.append(num);
                a = S.charAt(i);
                num = 1;
            }
            if (i == S.length()-1){
                a = S.charAt(i);
                str.append(a);
                str.append(num);
            }
        }
        final String s = str.toString();
        if (s.length() == S.length() || s.length()>S.length()){
            return S;
        }else {
            return s;
        }
    }
}
