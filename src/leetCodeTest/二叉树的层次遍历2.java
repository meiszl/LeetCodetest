package leetCodeTest;

import util.TreeNode;

import java.util.*;

public class 二叉树的层次遍历2 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        List<List<Integer>> lists = levelOrderBottom(treeNode);
        System.out.println(lists);
    }
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root != null){
            Deque<TreeNode> deque = new LinkedList<>();
            deque.addFirst(root);
            while (!deque.isEmpty()){
                int n = deque.size();
                List<Integer> list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    TreeNode treeNode = deque.pollLast();
                    list.add(treeNode.val);
                    if (treeNode.left != null)
                        deque.addFirst(treeNode.left);
                    if (treeNode.right != null)
                        deque.addFirst(treeNode.right);
                }
                res.add(list);
            }
            Collections.reverse(res);
        }
        return res;
    }
}
