package leetCodeTest;

import util.ListNode;

public class 奇偶链表 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode head = listNode;
        for (int i = 2; i <= 5; i++) {
            listNode.next = new ListNode(i);
            listNode =listNode.next;
        }
        ListNode listNode1 = oddEvenList(head);
        while (listNode1 != null){
            System.out.println("listNode1.val = " + listNode1.val);
            listNode1 = listNode1.next;
        }
    }

    /**
     * 使用两个指针存储奇偶结果，最后将两个指针串在一起。
     * @param head
     * @return
     */
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode lefthe = head,righthead = head.next,temp = head,temp1 = head.next;
        int count = 3;
        ListNode antr = head.next.next;
        while (antr != null){
            if (count % 2 == 0){
                righthead.next = antr;
                righthead = righthead.next;
            }else {
                lefthe.next = antr;
                lefthe = lefthe.next;
            }
            antr = antr.next;
            count++;
        }
        if (count % 2 == 0){
            righthead.next = righthead.next.next;
        }else {
            lefthe.next = lefthe.next.next;
        }
        lefthe.next = temp1;
        return temp;
    }
}
