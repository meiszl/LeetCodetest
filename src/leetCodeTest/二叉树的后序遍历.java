package leetCodeTest;

import util.TreeNode;

import java.util.*;

public class 二叉树的后序遍历 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        List<Integer> list = postorderTraversal(treeNode);
        System.out.println(list);
    }
//    private static List<Integer> res;
//    public static List<Integer> postorderTraversal(TreeNode root) {
//        res = new ArrayList<>();
//        dfs(root);
//        return res;
//    }
//    public static void dfs(TreeNode root){
//        if (root == null)
//            return;
//        if (root.left != null)
//            dfs(root.left);
//        if (root.right != null)
//            dfs(root.right);
//        res.add(root.val);
//    }
    public static List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        if (root == null)
            return res;
        deque.addFirst(root);
        while (!deque.isEmpty()){
            TreeNode treeNode = deque.pollFirst();
            res.addFirst(treeNode.val);
            if (treeNode.left != null)
                deque.addFirst(treeNode.left);
            if (treeNode.right != null)
                deque.addFirst(treeNode.right);
        }
        return res;
    }
}
