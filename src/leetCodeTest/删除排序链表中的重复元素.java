package leetCodeTest;

import util.ListNode;

public class 删除排序链表中的重复元素 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(3);
        ListNode listNode1 = deleteDuplicates(listNode);
        while (listNode1 != null){
            System.out.println("listNode1 = " + listNode1.val);
            listNode1 = listNode1.next;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode he = head;
        while (head.next != null){
            if (head.val == head.next.val){
                head.next = head.next.next;
            }else {
                head = head.next;
            }
        }
        return he;
    }
}
