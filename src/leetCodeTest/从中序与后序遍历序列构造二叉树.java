package leetCodeTest;

import util.TreeNode;

import java.util.HashMap;

public class 从中序与后序遍历序列构造二叉树 {
    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        TreeNode treeNode = buildTree(inorder, postorder);
        treeNode.printTree(treeNode);
    }
    private static int postidx;
    private static HashMap<Integer,Integer> hashMap;
    private static int[] post;
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null||inorder.length == 0||postorder == null||postorder.length == 0)
            return null;
        post = postorder;
        postidx = postorder.length-1;
        hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i],i);
        }
        return build(0,inorder.length-1);
    }

    private static TreeNode build(int inostart, int inoend) {
        if (inostart>inoend)
            return null;
        int i = post[postidx];
        TreeNode node = new TreeNode(i);
        int index = hashMap.get(i);
        postidx--;
        node.right = build(index+1,inoend);
        node.left = build(inostart,index-1);
        return node;
    }

}
