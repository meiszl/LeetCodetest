package leetCodeTest;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的最大路径和 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(-1);
        treeNode.left = new TreeNode(-2);
        treeNode.right = new TreeNode(-1);
        int i = maxPathSum(treeNode);
        System.out.println("i = " + i);
    }
    private static int count = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        Path(root);
        return count;
    }
    public static int Path(TreeNode root){
        if (root==null) return 0;
        int left = Math.max(Path(root.left),0);
        int right = Math.max(Path(root.right),0);

        int max_num = root.val + left + right;
        count = Math.max(count,max_num);

        return root.val + Math.max(left,right);
    }
}
