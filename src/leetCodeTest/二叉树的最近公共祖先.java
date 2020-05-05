package leetCodeTest;

import util.TreeNode;

public class 二叉树的最近公共祖先 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(1);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode.left.left = new TreeNode(6);
        treeNode.left.right = new TreeNode(2);
        treeNode.left.right.left = new TreeNode(7);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode.left.right.right = treeNode4;
        treeNode.right.left = new TreeNode(0);
        treeNode.right.right = new TreeNode(8);
        TreeNode treeNode3 = lowestCommonAncestor(treeNode, treeNode1, treeNode4);
        System.out.println("treeNode3.val = " + treeNode3.val);
    }

    /**
     * 递归 + 标识求祖先。
     */
    private static TreeNode ans;
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findTree(root, p, q);
        return ans;
    }
    public static boolean findTree(TreeNode treeNode,TreeNode p,TreeNode q){
        if (treeNode == null)
            return false;
        int left = findTree(treeNode.left,p,q)?1:0;
        int right = findTree(treeNode.right,p,q)?1:0;
        int mid = (treeNode == p||treeNode==q)?1:0;
        if (mid + left + right >= 2)
            ans = treeNode;
        return (mid + left + right >0);

    }
}
