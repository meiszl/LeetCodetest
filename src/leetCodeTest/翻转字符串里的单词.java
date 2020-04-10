package leetCodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 翻转字符串里的单词 {
    public static void main(String[] args) {
        String s = "a good   example";
        String s1 = reverseWords(s);
        System.out.println("s1 =" + s1 + "---");
    }

    /**
     * 将字符串去掉空格之后存储在list集合中，然后倒序取出其中的字符串组成新的字符串即可。
     * @param s
     * @return
     */
//    public static String reverseWords(String s) {
//        if(s.length() == 0)
//            return "";
//        int i;
//        List<String> list = new ArrayList();
//        StringBuilder stringBuilder = new StringBuilder();
//        for (i=0;i<s.length();i++){
//            if (s.charAt(i) == ' ' && stringBuilder.length() != 0){
//                list.add(stringBuilder.toString());
//                stringBuilder = new StringBuilder();
//            }
//            if (s.charAt(i) != ' '){
//                stringBuilder.append(s.charAt(i));
//            }
//
//        }
//        if (stringBuilder.length() != 0)
//            list.add(stringBuilder.toString());
//        System.out.println("list = " + list);
//        stringBuilder = new StringBuilder();
//        for (i= list.size()-1;i>=0;i--){
//            if (i!=0){
//                stringBuilder.append(list.get(i));
//                stringBuilder.append(' ');
//            }
//            if (i==0){
//                stringBuilder.append(list.get(i));
//            }
//        }
//        return stringBuilder.toString();
//    }
    /**
     * 正则表达式法
     */
//    public static String reverseWords(String s) {
//        s = s.trim();
//        List<String> list = Arrays.asList(s.split("\\s+"));
//        Collections.reverse(list);
//        return String.join(" ",list);
//    }
    /**
     * 直接Split的方法，迭代的时候跳过空值（速度最快）
     */
    public static String reverseWords(String s){
        String[] ss = s.split(" ");
        int i,n = ss.length;
        StringBuilder ans = new StringBuilder();
        for (i = n-1; i >= 0; i--) {
            if (ss[i].length() == 0) continue;
            ans.append(ss[i]).append(" ");
        }
        if (ans.length() > 0) ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }

}
