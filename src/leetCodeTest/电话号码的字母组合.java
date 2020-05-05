package leetCodeTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class 电话号码的字母组合 {
    public static void main(String[] args) {
        String digits = "23";
        List<String> list = letterCombinations(digits);
        System.out.println("list = " + list);
    }

    /**
     * 暴力解法
     * @param digits
     * @return
     */
//    public static List<String> letterCombinations(String digits) {
//        if (digits == null|| digits.length() == 0) return new ArrayList<>();
//        char[] chars = digits.toCharArray();
//        HashMap<Character,char[]> hashMap = new HashMap<>();
//        LinkedList<LinkedList<String>> lists = new LinkedList<>();
//        for (char aChar : chars) {
//            lists.add(new LinkedList<>());
//            if (hashMap.containsKey(aChar))
//                continue;
//            switch (aChar){
//                case '2':
//                    hashMap.put(aChar,new char[]{'a','b','c'});
//                    break;
//                case '3':
//                    hashMap.put(aChar,new char[]{'d','e','f'});
//                    break;
//                case '4':
//                    hashMap.put(aChar,new char[]{'g','h','i'});
//                    break;
//                case '5':
//                    hashMap.put(aChar,new char[]{'j','k','l'});
//                    break;
//                case '6':
//                    hashMap.put(aChar,new char[]{'m','n','o'});
//                    break;
//                case '7':
//                    hashMap.put(aChar,new char[]{'p','q','r','s'});
//                    break;
//                case '8':
//                    hashMap.put(aChar,new char[]{'t','u','v'});
//                    break;
//                case '9':
//                    hashMap.put(aChar,new char[]{'w','x','y','z'});
//                    break;
//            }
//        }
//        char[] chars1 = hashMap.get(chars[0]);
//        for (char c : chars1) {
//            lists.get(0).add(String.valueOf(c));
//        }
//        for (int i = 1; i < chars.length; i++) {
//            LinkedList<String> strings = lists.get(i - 1);
//            char[] chars2 = hashMap.get(chars[i]);
//            for (int j = 0; j < strings.size(); j++) {
//                for (char aChar : chars2) {
//                    lists.get(i).add(strings.get(j) + aChar);
//                }
//            }
//        }
//        return lists.get(lists.size()-1);
//    }
    /**
     * 回溯算法。
     */
    private static String[] strings;
    private static ArrayList<String> list;
    public static List<String> letterCombinations(String digits) {
        if (digits == null|| digits.length() == 0) return new ArrayList<>();
        list = new ArrayList<>();
        strings = new String[]{"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] chars = digits.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        findAll(stringBuilder,chars,0);
        return list;
    }
    public static void findAll(StringBuilder temp,char[] chars,int k){
        if (k == chars.length){
            list.add(temp.toString());
            return;
        }
        int i = chars[k]-'0'-1;
        for (char c : strings[i].toCharArray()) {
            temp.append(c);
            findAll(temp,chars,k+1);
            temp.deleteCharAt(k);
        }
    }

}
