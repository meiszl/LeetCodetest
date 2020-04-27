package util;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x){
        val = x;
    }
    public void printTree(TreeNode treeNode){
        System.out.println(treeNode.val);
        if (treeNode.left != null){
            printTree(treeNode.left);
        }
        if (treeNode.right != null){
            printTree(treeNode.right);
        }
    }
}
