package test;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class tengxuntest962 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashSet<Integer>[] hashSets = new HashSet[m];
        for (int i = 0; i < m; i++) {
            hashSets[i] = new HashSet<>();
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            int m1 = sc.nextInt();
            for (int j = 0; j < m1; j++) {
                hashSets[i].add(sc.nextInt());
            }
        }
        deque.addFirst(0);
        HashSet<Integer> hash = new HashSet<>();
        HashSet<Integer> re = new HashSet<>();
        while (!deque.isEmpty()){
            Integer integer = deque.pollLast();
            for (int i = 0; i < m; i++) {
                if (re.contains(i))
                    continue;
                if (hashSets[i].contains(integer)){
                    hashSets[i].forEach(o -> {
                        if (!hash.contains(o)){
                            hash.add(o);
                            deque.addFirst(o);
                        }
                    });
                    re.add(i);
                }
            }
        }
        System.out.println(hash.size());
    }
}
