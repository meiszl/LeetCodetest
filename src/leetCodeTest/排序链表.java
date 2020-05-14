package leetCodeTest;

import util.ListNode;

public class 排序链表 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(3);
        ListNode listNode1 = sortList(listNode);
        while (listNode1 != null){
            System.out.println("listNode1.val = " + listNode1.val);
            listNode1 = listNode1.next;
        }
    }

    /**
     * 归并排序，使用快慢指针找到链表的中间节点，然后在进行切割排序。
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head.next,slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null&& right != null){
            if (left.val < right.val){
                h.next = left;
                left = left.next;
            }else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null? left:right;
        return res.next;
    }
}
