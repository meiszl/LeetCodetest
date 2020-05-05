package leetCodeTest;

import util.ListNode;

import java.util.HashSet;

public class 环形链表 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        ListNode listNode1 = new ListNode(2);
        listNode.next = listNode1;
        listNode.next.next = new ListNode(0);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = listNode1;
//        ListNode listNode = new ListNode(1);
//        listNode.next = new ListNode(2);
        boolean b = hasCycle(listNode);
        System.out.println("b = " + b);
    }

    /**
     * 快慢指针算法
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode low = head;
        ListNode high = head.next;
        while (low != high){
            if (high == null || high.next == null)
                return false;
            low = low.next;
            high = high.next.next;
        }
        return true;
    }

    /**
     * hash表算法
     * @param head
     * @return
     */
//    public static boolean hasCycle(ListNode head) {
//        HashSet<ListNode> hashSet = new HashSet<>();
//        while (head != null){
//            if (hashSet.contains(head))
//                return true;
//            hashSet.add(head);
//            head = head.next;
//        }
//        return false;
//    }
}
