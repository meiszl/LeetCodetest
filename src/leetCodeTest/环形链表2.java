package leetCodeTest;

import util.ListNode;

public class 环形链表2 {
    /**
     * 寻找环形链表入口的方法：首先找到环形链表双指针的相遇点，
     * 然后将其中一个指针置为起始位置，然后两个指针分别向下运动，最终两个指针会在环形链表入口相遇。
     * @param head
     * @return
     */
//    public ListNode detectCycle(ListNode head) {
//        ListNode first = head;
//        ListNode second = cycle(head);
//        if(second == null)
//            return null;
//        while(first != second){
//            first = first.next;
//            second = second.next;
//        }
//        return second;
//    }
//    public ListNode cycle(ListNode head){
//        ListNode tortoise = head;
//        ListNode hare = head;
//
//        // A fast pointer will either loop around a cycle and meet the slow
//        // pointer or reach the `null` at the end of a non-cyclic list.
//        while (hare != null && hare.next != null) {
//            tortoise = tortoise.next;
//            hare = hare.next.next;
//            if (tortoise == hare) {
//                return tortoise;
//            }
//        }
//
//        return null;
//    }
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode first = head;
        ListNode second = head;
        while (second != null&& second.next != null){
            first = first.next;
            second = second.next.next;
            if (first == second){
                first = head;
                while (first != second){
                    first = first.next;
                    second = second.next;
                }
                return second;
            }
        }
        return null;
    }
}
