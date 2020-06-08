package leetCodeTest;

import util.ListNode;

public class 删除排序链表中的重复元素2 {
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
        ListNode nums = new ListNode(-1);
        nums.next = head;
        ListNode a = nums;
        ListNode b = head;
        while (b != null&& b.next != null){
            if (b.next.val != a.next.val){
                a = a.next;
                b = b.next;
            }else {
                while (b != null&&b.next != null&&b.next.val == a.next.val){
                    b = b.next;
                }
                a.next = b.next;
                b = b.next;
            }
        }
        return nums.next;
    }
}
