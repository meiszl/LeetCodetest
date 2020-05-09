package leetCodeTest;

import util.TreeNode;

public class 二叉树的最大深度 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        treeNode.right.right.right = new TreeNode(1);
        int i = maxDepth(treeNode);
        System.out.println("i = " + i);
    }
    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int allDepth = findAllDepth(root, 0);
        return allDepth;
    }
    public static int findAllDepth(TreeNode treeNode,int depth){
        if (treeNode == null) return depth;
        depth++;
        int leftDepth = findAllDepth(treeNode.left,depth);
        int rightDepth = findAllDepth(treeNode.right,depth);
        return Math.max(leftDepth,rightDepth);
    }
}
