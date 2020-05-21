package leetCodeTest;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class 字符串的排列 {
    public static void main(String[] args) {
        String s= "abc";
        String[] permutation = permutation(s);
        System.out.println("permutation = " + Arrays.toString(permutation));
    }
    private static List<String> res;
    private static HashSet<String> hashSet;
    public static String[] permutation(String s) {
        hashSet = new HashSet<>();
        res = new ArrayList<>();
        find(s,new StringBuilder(),new HashSet<>());
        return res.toArray(new String[res.size()]);
    }
    public static void find(String s,StringBuilder builder,HashSet<Integer> de){
        if (!hashSet.contains(builder.toString()) && builder.length() == s.length()){
            res.add(builder.toString());
            hashSet.add(builder.toString());
            return;
        }
        if (hashSet.contains(builder.toString()))
            return;
        for (int j = 0; j < s.length(); j++) {
            if (de.contains(j))
                continue;
            builder.append(s.charAt(j));
            de.add(j);
            find(s, builder,de);
            builder.deleteCharAt(builder.length()-1);
            de.remove(j);
        }
    }
}
