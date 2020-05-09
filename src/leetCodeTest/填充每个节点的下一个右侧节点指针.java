package leetCodeTest;

import util.TreeNode;

import java.util.*;

public class 填充每个节点的下一个右侧节点指针 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        TreeNode connect = connect(root);
//        connect.printTree(connect);

    }
    public static TreeNode connect(TreeNode root) {
        TreeNode res = root;
        if (root != null){
            Deque<TreeNode> deque = new LinkedList();
            deque.addLast(root);
            TreeNode temp = null;
            while (!deque.isEmpty()){
                int size = deque.size();
                //使用List一次存储所有的节点再进行连接
//                List<TreeNode> list = new ArrayList<>();
                temp = null;
                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = deque.removeFirst();
                    if (treeNode.left != null)
                        deque.addLast(treeNode.left);
                    if (treeNode.right != null)
                        deque.addLast(treeNode.right);
//                    list.add(treeNode);
                    if (temp != null){
                        temp.next = treeNode;
                        temp = temp.next;
                    }else {
                        temp = treeNode;
                    }
                }
//                for (int i = 0; i < list.size() - 1; i++) {
//                    list.get(i).next = list.get(i+1);
//                }
            }
        }
        return res;
    }
}
class TNode{
    int val;
    TNode left;
    TNode right;
    TNode next;
    public TNode(int val){
        this.val = val;
    }
}