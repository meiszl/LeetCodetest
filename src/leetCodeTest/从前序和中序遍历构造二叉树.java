package leetCodeTest;

import util.TreeNode;


public class 从前序和中序遍历构造二叉树 {
    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode treeNode = buildTree(preorder, inorder);
        treeNode.printTree(treeNode);
    }
    /**
     * 数组拷贝的方法
     */
//    public static TreeNode buildTree(int[] preorder, int[] inorder) {
//        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0)
//            return null;
//        if (preorder.length != inorder.length)
//            return null;
//        TreeNode treeNode = new TreeNode(preorder[0]);
//        int i;
//        for (i=0;i<preorder.length;i++){
//            if (preorder[0] == inorder[i]){
//                treeNode.left = buildTree(Arrays.copyOfRange(preorder,1,i+1),Arrays.copyOfRange(inorder,0,i));
//                treeNode.right = buildTree(Arrays.copyOfRange(preorder,i+1,preorder.length),Arrays.copyOfRange(inorder,i+1,inorder.length));
//            }
//        }
//        return treeNode;
//    }
    private static int[] pre;
    private static int[] ino;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0)
            return null;
        pre = preorder;
        ino = inorder;
        TreeNode treeNode = buildTree(0,preorder.length -1,0,inorder.length -1);
        return treeNode;
    }
    public static TreeNode buildTree(int prel,int prer,int inol,int inor) {
        if (prel > prer || inol > inor)
            return null;
        int rootvalue = pre[prel];
        int index = 0;
        TreeNode treeNode = new TreeNode(rootvalue);
        while (index < inor && ino[index] != rootvalue){
            index++;
        }
        treeNode.left = buildTree(prel + 1,prel - inol + index,inol,index);
        treeNode.right = buildTree(prel - inol + index + 1,prer,index + 1,inor);
        return treeNode;
    }
}
