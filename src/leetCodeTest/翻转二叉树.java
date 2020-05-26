package leetCodeTest;

import util.TreeNode;

public class 翻转二叉树 {
    public static void main(String[] args) {
        TreeNode tr = new TreeNode(4);
        tr.left = new TreeNode(2);
        tr.right = new TreeNode(7);
        tr.left.left = new TreeNode(1);
        tr.left.right = new TreeNode(3);
        tr.right.left = new TreeNode(6);
        tr.right.right = new TreeNode(9);
        TreeNode treeNode = invertTree(tr);
        treeNode.printTree(treeNode);
    }
    public static TreeNode invertTree(TreeNode root) {
         dfs(root);
         return root;
    }
    public static void dfs(TreeNode treeNode){
        if (treeNode == null)
            return;
        TreeNode tr = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = tr;
        if (treeNode.left != null)
            dfs(treeNode.left);
        if (treeNode.right != null)
            dfs(treeNode.right);
    }
}
