package leetCodeTest;

import java.util.*;

public class 字符串中的第一个唯一字符 {
    public static void main(String[] args) {
        String s = "loveleetcode";
        int i = firstUniqChar(s);
        System.out.println("i = " + i);
    }

    /**
     * 使用map去重，最后再使用分割字符数组来确定位置。
     * @param s
     * @return
     */
//    public static int firstUniqChar(String s) {
//        if(s.length() == 0)
//            return -1;
//        if (s.length() == 1)
//            return 0;
//        Map<String,Integer> map = new HashMap();
//        String[] split = s.split("");
//        int i;
//        for (i=0;i<split.length;i++){
//            if (map.containsKey(split[i])){
//                Integer integer = map.get(split[i]);
//                map.put(split[i],++integer);
//            }else {
//                map.put(split[i],1);
//            }
//        }
//        for (i=0;i<split.length;i++){
//            Integer integer = map.get(split[i]);
//            if (integer == 1)
//                return i;
//        }
//        return -1;
//    }
    public static int firstUniqChar(String s) {
        if(s.length() == 0)
            return -1;
        if (s.length() == 1)
            return 0;
        char[] chars = s.toCharArray();
        LinkedHashMap<Character,Integer> hashMap = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            hashMap.put(chars[i],hashMap.getOrDefault(chars[i],0)+1);
        }
        for (int i = 0; i < chars.length; i++) {
            if (hashMap.get(chars[i]) == 1)
                return i;
        }
        return 0;
    }
}
