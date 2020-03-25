package leetCodeTest;

public class 实现strStr {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        int i = strStr(haystack, needle);
        System.out.println("i = " + i);
    }
    /**
     * 传统方法，切分字符串，首先遍历haystack，
     * 每次遍历切分出来needle长度的字符串，然后对比haystack切分串与needle是否相等。
     * 此处遍历的次数为haystack.length()-needle.length()+1因为你需要切分出needle长度的字符串，
     * 所以需要保证最后遍历的i值可以切分出needle长度的字符串。
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if (needle.length() ==0)
            return 0;
        if (haystack.length() == 0 || (needle.length() > haystack.length()))
            return -1;
        int i,j,cou = needle.length();
        for (i=0;i<haystack.length()-needle.length()+1;i++)
        {
            String substring = haystack.substring(i, i + needle.length());
            if (substring.equals(needle))
                return i;
        }
        return -1;
    }
}
