package leetCodeTest;

import util.TreeNode;

public class 二叉树中的最大路径和 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        int i = maxPathSum(treeNode);
        System.out.println("i = " + i);
    }
    public static int maxPathSum(TreeNode root) {
        if (root == null) return 0;

        return 1;
    }
    public static void search(TreeNode root){

    }
}
