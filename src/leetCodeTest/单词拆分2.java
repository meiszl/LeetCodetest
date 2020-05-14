package leetCodeTest;

import java.util.*;

public class 单词拆分2 {
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<String>(){{
            add("cat");
            add("cats");
            add("and");
            add("sand");
            add("dog");
            }};
        List<String> list = wordBreak(s, wordDict);
        System.out.println("list = " + list);
    }

    /**
     * 回溯法
     */
    private static HashSet<String> hashSet;
    private static HashMap<Integer,List<String>> hashMap;
    private static List<String> res;
    public static List<String> wordBreak(String s, List<String> wordDict) {
        hashSet = new HashSet<>(wordDict);
        hashMap = new HashMap<>();
        res = new ArrayList<>();
        return find(s, 0);
    }
    public static List<String> find(String s,int start){
        if (hashMap.containsKey(start))
            return hashMap.get(start);
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length())
            res.add("");
        for (int end = start+1; end <= s.length(); end++) {
            if (hashSet.contains(s.substring(start,end))){
                List<String> list = find(s, end);
                for (String s1 : list) {
                    res.add(s.substring(start,end) + (s1.equals("")?"":" " + s1));
                }
            }
        }
        hashMap.put(start,res);
        return res;
    }
}
