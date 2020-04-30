package leetCodeTest;

import java.util.*;

public class 字母异位词分组 {
    public static void main(String[] args) {
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strings);
        System.out.println("lists = " + lists);
    }

    /**
     * 对每一个字符串进行重排序然后放入map中，保存该字符串存储的list下标。
     * @param strs
     * @return
     */
//    public static List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> lists = new ArrayList<>();
//        if (strs == null || strs.length == 0) return lists;
//        HashMap<String,Integer> hashSet = new HashMap<>();
//        char[] chars;
//        for (int i = 0; i < strs.length; i++) {
//            chars = strs[i].toCharArray();
//            Arrays.sort(chars);
//            String s = String.valueOf(chars);
//            if (hashSet.containsKey(s)){
//                lists.get(hashSet.get(s)).add(strs[i]);
//            }else {
//                ArrayList<String> list = new ArrayList();
//                list.add(strs[i]);
//                lists.add(list);
//                hashSet.put(s,lists.size() - 1);
//            }
//        }
//        return lists;
//    }

    /**
     * 保存list本身的方法
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        HashMap<String,List<String>> hashSet = new HashMap<>();
        char[] chars;
        String s;
        for (int i = 0; i < strs.length; i++) {
            chars = strs[i].toCharArray();
            Arrays.sort(chars);
            s = String.valueOf(chars);
            if (!hashSet.containsKey(s))
                hashSet.put(s,new ArrayList<>());
            hashSet.get(s).add(strs[i]);
        }
        return new ArrayList(hashSet.values());
    }
}
