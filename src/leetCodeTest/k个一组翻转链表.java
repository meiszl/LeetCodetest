package leetCodeTest;

import util.ListNode;

public class k个一组翻转链表 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode he = listNode;
        for (int i = 2; i <= 5; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        ListNode listNode1 = reverseKGroup(he,4);
        while (listNode1 != null){
            System.out.println("listNode1 = " + listNode1.val);
            listNode1 = listNode1.next;
        }
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        int count = 0;
        ListNode he = head;
        ListNode temp;
        ListNode res = new ListNode(0);
        ListNode rehead = res;
        while (head != null){
            count++;
            if (count%k==0){
                temp = head.next;
                head.next = null;
                res.next = cut(he);
                while (res.next != null)
                    res = res.next;
                head = temp;
                he = temp;
                continue;
            }
            head = head.next;
        }
        if (he != null){
            res.next = he;
        }
        return rehead.next;
    }
    public static ListNode cut(ListNode head){
        ListNode leftnode = new ListNode(0);
        ListNode tem;
        while (true){
            if (head == null)
                break;
            tem = head.next;
            head.next = leftnode.next;
            leftnode.next = head;
            head = tem;
        }
        return leftnode.next;
    }
}
