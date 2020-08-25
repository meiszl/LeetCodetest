package test;

import java.util.*;

public class tengxuntest1 {
    private static List<String> res;
    private static HashSet<String> hashSet;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        hashSet = new HashSet<>();
        res = new ArrayList<>();
        combination(s);
        Collections.sort(res,(o1, o2) -> o1.compareTo(o2));
        System.out.println(res.get(k-1));
    }
    public static void combination(String s){
        if (s == null||s.length() == 0){
            return;
        }
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                if (hashSet.contains(substring))
                    continue;
                res.add(substring);
                hashSet.add(substring);
            }
        }
        System.out.println(res);
    }


}
