package leetCodeTest;

import util.ListNode;

public class 删除链表的倒数第n个节点 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        int i;
        for (i=2;i<=5;i++){
            head.next = new ListNode(i);
            head = head.next;
        }
        ListNode listNode = removeNthFromEnd(temp, 2);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 思路
     *
     * 我们注意到这个问题可以容易地简化成另一个问题：删除从列表开头数起的第(L−n+1) 个结点，
     * 其中 L 是列表的长度。只要我们找到列表的长度 L，这个问题就很容易解决。
     *
     * 算法
     *
     * 首先我们将添加一个哑结点作为辅助，该结点位于列表头部。哑结点用来简化某些极端情况，
     * 例如列表中只含有一个结点，或需要删除列表的头部。在第一次遍历中，我们找出列表的长度 L。
     * 然后设置一个指向哑结点的指针，并移动它遍历列表，直至它到达第 (L−n) 个结点那里。
     * 我们把第(L−n) 个结点的 next 指针重新链接至第(L−n+2) 个结点，完成这个算法。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-by-l/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        int i;
        for (i=0;i<=n;i++){
            first = first.next;
        }
        while (first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
