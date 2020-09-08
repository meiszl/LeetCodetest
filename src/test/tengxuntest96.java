package test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
}
public class tengxuntest96 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> list = new HashSet<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        LinkedList res = new LinkedList();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            if (list.contains(num)){
                res.add(num);
            }
        }
        res.forEach(o -> System.out.print(o + " "));
    }

}
