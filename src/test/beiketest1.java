package test;

import java.util.*;

public class beiketest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int reduce = 0;
//        for (int i = 0; i < 2 * n; i++) {
//            reduce += sc.nextInt();
//        }
//        int upper = 0;
//        for (int i = 0; i < 2 * n; i++) {
//            upper += sc.nextInt();
//        }
//        int res = Math.abs(reduce - upper) + 1;
//        System.out.println(res);
        Deque<Integer> deque1L = new LinkedList<>();
        Deque<Integer> deque1R = new LinkedList<>();
        Deque<Integer> deque2L = new LinkedList<>();
        Deque<Integer> deque2R = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            deque1L.addLast(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            deque1R.addFirst(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            deque2L.addLast(sc.nextInt());
        }
        for (int i = 0; i < n; i++) {
            deque2R.addFirst(sc.nextInt());
        }
        int count = 0;
        Integer re = (deque2L.peekLast() - deque1L.peekLast()) > (deque2R.peekLast() - deque1R.peekLast()) ? deque1L.peekLast() : deque1R.peekLast();
        for (int i = 0; i < 2 * n; i++) {
            if (!deque1L.isEmpty()&&!deque2L.isEmpty()&&!deque1R.isEmpty()&&!deque2R.isEmpty()){
                int reduce1 = deque2L.peekLast() - deque1L.peekLast();
                int reduce2 = deque2R.peekLast() - deque1R.peekLast();
                if (reduce1 > reduce2){
                    count += reduce1;
                    deque2L.pollLast();
                    deque1L.pollLast();
                }else {
                    count += reduce2;
                    deque1R.pollLast();
                    deque2R.pollLast();
                }
            }else if (!deque1L.isEmpty()&&!deque2L.isEmpty()){
                int reduce1 = deque2L.peekLast() - deque1L.peekLast();
                count += reduce1;
                deque2L.pollLast();
                deque1L.pollLast();
            }else if (!deque1R.isEmpty()&&!deque2R.isEmpty()){
                int reduce2 = deque2R.peekLast() - deque1R.peekLast();
                count += reduce2;
                deque1R.pollLast();
                deque2R.pollLast();
            }

        }
        if (-(count)+1 > re)
            System.out.println(-(count)+1);
        else
            System.out.println(re+1);
    }
}
