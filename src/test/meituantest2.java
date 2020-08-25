package test;

import java.util.*;

public class meituantest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Integer[] res = new Integer[n];
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            int w = sc.nextInt();
            res[i] = v + 2*w;
        }
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        System.out.println(Arrays.toString(res));
        for (int i = 0; i < res.length; i++) {
            if (!hashMap.containsKey(res[i]))
                hashMap.put(res[i],i+1);
            else
                continue;
        }
        System.out.println(hashMap);
        Arrays.sort(res,((o1, o2) -> o2 - o1));
        HashSet<Integer> hashSet = new LinkedHashSet<>();
        for (int i = 0; i < res.length; i++) {
            hashSet.add(res[i]);
        }
        Iterator<Integer> iterator = hashSet.iterator();
        for (int i = 0; i < m; i++) {
            System.out.println(hashMap.get(iterator.next()));
        }
    }
}
