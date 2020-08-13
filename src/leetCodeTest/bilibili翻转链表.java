package leetCodeTest;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class bilibili翻转链表 {
    static class LinkNode {
        int val;
        LinkNode next;

        public LinkNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] ints = Arrays.stream(scanner.nextLine().split(","))
                .parallel().mapToInt(Integer::parseInt).toArray();
        Stack<LinkNode> stack = new Stack<>();
        LinkNode head = new LinkNode(0);
        LinkNode p = head;
        //链表初始化并放入stack中
        for(int i = 0; i < ints.length; i++){
            p.next = new LinkNode(ints[i]);
            p = p.next;
            stack.add(p);
        }
        head = head.next;
        //开始链表转换
        p = head;
        LinkNode q = stack.peek();
        System.out.println(p.val);
        System.out.println(q.val);
        while ((!p.equals(q)) && (!p.next.equals(q))) {
            q = stack.pop();
            q.next = p.next;
            p.next = q;
            p = p.next.next;
            q = stack.peek();
        }
        q.next = null;
        //打印
        while (head != null) {
            if(head.next == null){
                System.out.print(head.val);
            }else{
                System.out.print(head.val + ",");
            }
            head = head.next;
        }
    }
}