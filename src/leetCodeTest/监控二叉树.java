package leetCodeTest;

import util.TreeNode;

import java.util.HashSet;

public class 监控二叉树 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        treeNode.left = new TreeNode(1);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(3);
        int i = minCameraCover(treeNode);
        System.out.println(i);
    }
    private static int res;
    private static HashSet<TreeNode> hashSet;
    public static int minCameraCover(TreeNode root) {
        res = 0;
        hashSet = new HashSet<>();
        hashSet.add(null);
        slove(root,null);
        return res;
    }
    public static void slove(TreeNode treeNode,TreeNode pre){
        if (treeNode != null){
            slove(treeNode.left,treeNode);
            slove(treeNode.right,treeNode);
            if (pre == null&&!hashSet.contains(treeNode)||
            !hashSet.contains(treeNode.left)||
            !hashSet.contains(treeNode.right)){
                System.out.println(treeNode.val);
                res++;
                hashSet.add(treeNode);
                hashSet.add(pre);
                hashSet.add(treeNode.left);
                hashSet.add(treeNode.right);
            }
        }
    }
}
