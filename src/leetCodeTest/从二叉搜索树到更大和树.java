package leetCodeTest;

import util.TreeNode;

public class 从二叉搜索树到更大和树 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(1);
        treeNode.left.left = new TreeNode(0);
        treeNode.left.right = new TreeNode(2);
        treeNode.left.right.right = new TreeNode(3);
        treeNode.right = new TreeNode(6);
        treeNode.right.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(7);
        treeNode.right.right.right = new TreeNode(8);
        TreeNode treeNode1 = bstToGst(treeNode);
    }
    private static int sum;
    public static TreeNode bstToGst(TreeNode root) {
        sum = 0;
        find(root);
        return root;
    }
    public static void find(TreeNode root){
        if (root == null)
            return;
        if (root.right != null) {
            find(root.right);
        }
        root.val += sum;
        sum = root.val;
        if (root.left != null)
            find(root.left);
    }
}
