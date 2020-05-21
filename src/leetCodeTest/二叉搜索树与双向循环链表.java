package leetCodeTest;


import java.util.Deque;
import java.util.LinkedList;

public class 二叉搜索树与双向循环链表 {
    public static void main(String[] args) {
        twoNode treeNode = new twoNode(4);
        treeNode.left = new twoNode(2);
        treeNode.right = new twoNode(5);
        treeNode.left.left = new twoNode(1);
        treeNode.left.right = new twoNode(3);
        twoNode twoNode = treeToDoublyList(treeNode);
        while (twoNode != null){
            System.out.println("twoNode = " + twoNode.val);
            twoNode = twoNode.right;
        }


    }

    /**
     * 使用队列迭代，报空错误。
     */
    private static Deque<twoNode> deque;
    public static twoNode treeToDoublyList(twoNode root) {
        deque = new LinkedList<>();
        find(root);
        twoNode head = new twoNode(0);
        twoNode res = head;
        int size = deque.size();
        for (int i = 0;i<size;i++) {
            twoNode twoNode = deque.pollLast();
            head.right = twoNode;
            twoNode.left = head;
            head = twoNode;
        }
        return res;
    }
    public static twoNode find(twoNode head){
        if (head == null)
            return head;
        if (head.left!= null){
            find(head.left);
        }
        deque.addFirst(head);
        if (head.right != null){
            find(head.right);
        }
        return head;
    }

    /**
     * 直接迭代生成
     */
//    twoNode pre, head;
//    public twoNode treeToDoublyList(twoNode root) {
//        if(root == null) return null;
//        dfs(root);
//        head.left = pre;
//        pre.right = head;
//        return head;
//    }
//     void  dfs(twoNode cur) {
//        if(cur == null) return;
//        dfs(cur.left);
//        if(pre != null) pre.right = cur;
//        else head = cur;
//        cur.left = pre;
//        pre = cur;
//        dfs(cur.right);
//    }
}
class twoNode {
    public int val;
    public twoNode left;
    public twoNode right;

    public twoNode() {}

    public twoNode(int _val) {
        val = _val;
    }

    public twoNode(int _val,twoNode _left,twoNode _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
