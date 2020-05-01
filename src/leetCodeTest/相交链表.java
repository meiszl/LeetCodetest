package leetCodeTest;

import util.ListNode;

import java.util.HashSet;

public class 相交链表 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(8);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(5);
        ListNode listNode1 = new ListNode(4);
        listNode1.next = new ListNode(1);
        listNode1.next.next = listNode;
        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(0);
        listNode2.next.next = new ListNode(1);
        listNode2.next.next.next = listNode;
        ListNode intersectionNode = getIntersectionNode(listNode1, listNode2);
        while (intersectionNode != null){
            System.out.println("intersectionNode.val = " + intersectionNode.val);
            intersectionNode = intersectionNode.next;
        }
    }

    /**
     * hash表法
     * @param headA
     * @param headB
     * @return
     */
//    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        HashSet<ListNode> hashSet = new HashSet<>();
//        while (headA != null){
//            hashSet.add(headA);
//            headA = headA.next;
//        }
//        while (headB != null){
//            if (hashSet.contains(headB))
//                return headB;
//            headB = headB.next;
//        }
//        return headB;
//    }

    /**
     * 双指针法
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode L = headA;
        ListNode R = headB;
        int count=0; //当一个节点达到一个链表的尾部，则从另一个链表继续，同时count++
        while (L != R) {
            L = L.next;
            R = R.next;
            if (L == null) {
                L = headB;
                count ++;
            }
            if (R == null) {
                R = headA;
                count++;
            }
            if (count >2) {
                return null;
            }
        }
        return L;

    }
}
