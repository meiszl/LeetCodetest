package leetCodeTest;

public class 最长公共前缀 {
    public static void main(String[] args) {
        String[] strs = new String[]{"c","c"};
        String s = longestCommonPrefix(strs);
        System.out.println("s = " + s);
    }

    /**
     * 水平扫描法，按列比较每一个字符，直到出现不相等字符或者
     * 下标大于某一个短字符返回公共最长前缀。
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int i,j;
        for (i=0;i<strs[0].length();i++){
            char c = strs[0].charAt(i);
            for (j=0;j<strs.length;j++){
                if (i==strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }

}
