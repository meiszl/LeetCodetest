package leetCodeTest;

import util.TreeNode;

public class 将有序数组转换为二叉搜索树 {
    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        TreeNode treeNode = sortedArrayToBST(nums);
        treeNode.printTree(treeNode);
    }
    private static int[] temp;
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null|| nums.length == 0)
            return null;
        temp = nums;
        TreeNode treeNode = searchTree(0,nums.length - 1);
        return treeNode;
    }
    public static TreeNode searchTree(int left,int right){
        if (left > right) return null;

        int mid = (left + right) >>> 1;

        TreeNode treeNode = new TreeNode(temp[mid]);

        treeNode.left = searchTree(left, mid - 1);
        treeNode.right = searchTree(mid + 1,right);

        return treeNode;
    }
}
