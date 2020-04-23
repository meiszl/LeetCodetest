package leetCodeTest;

import util.TreeNode;


public class 把二叉搜索树转换为累加树 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(13);
        TreeNode treeNode1 = convertBST(treeNode);
        printTree(treeNode1);
    }
    public boolean isOneBitCharacter(int[] bits) {
        if (bits == null || bits.length == 0) return false;
        if (bits.length == 1)return true;
        if (bits[bits.length - 2] == 1)
            return false;
        else
            return true;
    }
    /**
     * 回溯算法，考虑对一个子树的详细操作然后进行递归操作所有子树。
     */
    private static int sum = 0;
    public static TreeNode convertBST(TreeNode root) {
        if (root != null){
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
    public static void printTree(TreeNode treeNode){
        if (treeNode == null) return;
        System.out.print(treeNode.val + " ");
        printTree(treeNode.left);
        printTree(treeNode.right);
    }
}
