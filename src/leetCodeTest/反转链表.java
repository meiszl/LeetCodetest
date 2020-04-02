package leetCodeTest;

import util.ListNode;

public class 反转链表 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        int i;
        for (i=2;i<=5;i++){
            head.next = new ListNode(i);
            head = head.next;
        }
        ListNode listNode = reverseList(temp);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 以下思路可以理解为：头插法
     * 1、新建一个用于存放反转结果集的链表
     * 2、遍历链表，也就是代码中的item
     * 3、拿到item中的第一个节点之后，由于为了循环能够正常继续，
     * 我们需要用一个next节点，用来保存第一个节点之后的节点元素
     * 4、再把result节点之后的next元素，赋值给item中的next节点
     * 5、再把item本身，赋值给result中的next，这样就完成一个头插法的操作
     * 6、最后next元素赋值给item，继续循环
     *
     * 作者：chu-xin-e
     * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/solution/dan-lian-biao-fan-zhuan-javaban-ben-by-chu-xin-e/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        // 虚拟头，用于存放反转结果
        ListNode result = new ListNode(0);

        ListNode item = head;
        ListNode next;
        while(true){
            if(item == null){
                break;
            }
            // 为了保证循环正常后移，先把下一个元素临时取出来
            next = item.next;
            // 因为需要移动到result链表中最前一个，所以我们需要把result的next节点，赋值给最新元素的item
            item.next = result.next;
            // 然后再把item插入到result当中
            result.next = item;
            // 元素后移继续循环
            item = next;
        }
        // 由于我们使用的虚拟头，第一个元素是无效的，直接取下一个节点就行了
        return result.next;
    }
}
