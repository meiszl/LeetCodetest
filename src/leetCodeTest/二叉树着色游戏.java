package leetCodeTest;

import util.TreeNode;

public class 二叉树着色游戏 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        treeNode.left.left.left = new TreeNode(8);
        treeNode.left.left.right = new TreeNode(9);
        treeNode.left.right.left = new TreeNode(10);
        treeNode.left.right.right = new TreeNode(11);
        boolean b = btreeGameWinningMove(treeNode,11,3);
        System.out.println("b = " + b);
    }
    private static int left;
    private static int right;
    private static int num;
    public static boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        num = x;
        dfs(root);
        int half = n/2;
        if (left > half||right>half||(right + left) < half){
            return true;
        }else
            return false;
    }
    public static int dfs(TreeNode root){
        if (root == null)
            return 0;
        int lefnum = 0,rightnum = 0;
        if (root.left != null)
            lefnum = dfs(root.left);
        if (root.right != null)
            rightnum = dfs(root.right);
        if (root.val == num){
            left = lefnum;
            right = rightnum;
        }
        return lefnum + rightnum + 1;
    }
}
