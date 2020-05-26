package leetCodeTest;

import util.TreeNode;

import java.util.HashMap;

public class 打家劫社3 {
    public static void main(String[] args) {
        TreeNode tr = new TreeNode(3);
        tr.left = new TreeNode(4);
        tr.right = new TreeNode(5);
        tr.left.left = new TreeNode(1);
        tr.left.right = new TreeNode(3);
        tr.right.right = new TreeNode(1);
        int rob = rob(tr);
        System.out.println("rob = " + rob);
    }

    /**
     *动态规划，按偷不偷划分。
     */
//    private static HashMap<TreeNode,Integer> hashMap = new HashMap<>();
//    public static int rob(TreeNode root) {
//        if (root == null) return 0;
//        if (hashMap.containsKey(root))
//            return hashMap.get(root);
//        int rob = root.val + (root.left == null ? 0:rob(root.left.left) + rob(root.left.right))
//                + (root.right == null ? 0:rob(root.right.left) + rob(root.right.right));
//        int Norob = rob(root.left) + rob(root.right);
//        int res = Math.max(rob,Norob);
//        hashMap.put(root,res);
//        return res;
//
//    }

    /**
     * 优化的动态规划,按偷左右子树划分。
     * @param root
     * @return
     */
    private static HashMap<TreeNode,Integer> hashMap;
    public static int rob(TreeNode root) {
        hashMap = new HashMap<>();
        int[] robint = robint(root);
        return Math.max(robint[0],robint[1]);
    }
    public static int[] robint(TreeNode treeNode){
        if (treeNode == null) return new int[2];
        int[] res = new int[2];
        int[] left = robint(treeNode.left);
        int[] right = robint(treeNode.right);
        //不偷当前节点的话，结果就是左子树的最大值+右子树的最大值。
        res[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        //偷当前节点的话，结果就是左子树不偷的值+右子树不偷的值。
        res[1] = left[0] + right[0] + treeNode.val;
        return res;
    }
}
