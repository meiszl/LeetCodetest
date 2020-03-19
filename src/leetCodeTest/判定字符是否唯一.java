package leetCodeTest;

public class 判定字符是否唯一 {

    public static void main(String[] args) {
        String s = "leetcode";
        final boolean unique = isUnique(s);
        System.out.println("unique = " + unique);
    }

    /**
     * 用replace后的长度做判断即可
     * @param astr
     * @return
     */
    public static boolean isUnique(String astr) {
        for (int i=0;i<astr.length();i++){
            String s=astr;
            s=s.replace(String.valueOf(s.charAt(i)),"");
            if (s.length()!=astr.length()-1)
                return false;
        }
        return true;
    }
}
