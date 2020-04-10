package leetCodeTest;

import util.TreeNode;

public class 验证二叉搜索树 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(15);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(20);
        boolean validBST = isValidBST(treeNode);
        System.out.println("validBST = " + validBST);
    }

    /**
     * 此题不能只判断中间节点与左右子树的大小关系，因为二叉搜索树
     * 左子树的值均小于根节点，右子树的值均大于根节点。
     * 使用中序遍历，比对每次遍历到的节点与根节点并存储每次得到的最小值判断
     */
    static long pre = Long.MIN_VALUE;
    public static boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        if (isValidBST(root.left)) {
            if (pre < root.val) {
                pre = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }
}
