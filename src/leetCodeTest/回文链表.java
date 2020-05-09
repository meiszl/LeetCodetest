package leetCodeTest;

import util.ListNode;

import java.util.Stack;

public class 回文链表 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(1);
        boolean palindrome = isPalindrome(listNode);
        System.out.println("palindrome = " + palindrome);
    }
    public static boolean isPalindrome(ListNode head) {
        if (head == null|| head.next == null) return false;
        ListNode lefthe = head,righthe = head.next;
        Stack<Integer> stack = new Stack<>();
        int len = 0;
        while (lefthe != null){
            len++;
            lefthe = lefthe.next;
        }
        lefthe = head;
        for (int i = 0; i < len/2; i++) {
            stack.push(lefthe.val);
            lefthe = lefthe.next;
        }
        if (len % 2 != 0)
            lefthe = lefthe.next;
        for (int i = 0; i < len / 2; i++) {
            if (stack.pop() != lefthe.val)
                return false;
            lefthe = lefthe.next;
        }
        return true;
    }
}
