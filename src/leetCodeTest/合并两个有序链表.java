package leetCodeTest;

import util.ListNode;

public class 合并两个有序链表 {
    public static void main(String[] args) {
        ListNode li1 = new ListNode(1);
        li1.next = new ListNode(2);
        li1.next.next = new ListNode(4);
        ListNode li2 = new ListNode(1);
        li2.next = new ListNode(3);
        li2.next.next = new ListNode(4);
        ListNode listNode = mergeTwoLists(li1, li2);
        while (listNode != null){
            System.out.println("listNode.val = " + listNode.val);
            listNode = listNode.next;
        }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null?l2:l1;
        ListNode temp = new ListNode(0);
        ListNode res = temp;
        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                temp.next = l2;
                l2 = l2.next;
            }else {
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }
        temp.next = l1==null?l2:l1;
        res = res.next;
        return res;
    }
}
