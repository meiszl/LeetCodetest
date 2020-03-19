package leetCodeTest;

import util.ListNode;

public class 两数相加 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode temp1 = new ListNode(4);
        ListNode temp2 = new ListNode(3);
        l1.next = temp1;
        l1.next.next = temp2;

        ListNode l2 = new ListNode(5);
        ListNode tem1 = new ListNode(6);
        ListNode tem2 = new ListNode(4);
        l2.next = tem1;
        l2.next.next = tem2;

        addTwoNumbers(l1,l2);
    }

    /**
     * 链表相加思路：将每一位分别相加，并保留每一位的进位，然后当运算下一位时将进位加上变成Sum值，
     * 之后，对10求余得到剩下的就是该位得数，同时保留下一位的进位。在此处同一位上最多余下1（例如，9+9+1=19，
     * 进位为1）所以只考虑下一位的进位就可以。
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
