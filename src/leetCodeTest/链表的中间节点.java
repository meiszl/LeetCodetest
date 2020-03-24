package leetCodeTest;

import util.ListNode;

public class 链表的中间节点 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        ListNode listNode1 = middleNode(listNode);
        while (listNode1 != null){
            System.out.print(listNode1.val + " ");
            listNode1 = listNode1.next;
        }
    }

    /**
     * 对链表遍历两边，第一遍记录链表长度，第二遍将指针移动到中间返回。
     * @param head
     * @return
     */
//    public static ListNode middleNode(ListNode head) {
//        int i,count=0;
//        ListNode temp = head;
//        while (temp!=null){
//            temp =temp.next;
//            count++;
//        }
//        for (i=0;i<count/2;i++){
//            head = head.next;
//        }
//        System.out.println("count = " + count);
//        return head;
//    }

    /**
     * 我们可以继续优化方法二，用两个指针 slow 与 fast 一起遍历链表。slow 一次走一步，fast 一次走两步。那么当 fast 到达链表的末尾时，slow 必然位于中间。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/middle-of-the-linked-list/solution/lian-biao-de-zhong-jian-jie-dian-by-leetcode-solut/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
