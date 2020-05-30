package leetCodeTest;

import util.TreeNode;

public class 路径总和3 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int build1 = build(root, sum);
        int buildleft = pathSum(root.left, sum);
        int buildright = pathSum(root.right, sum);
        return build1 + buildleft + buildright;
    }
    public int build(TreeNode tr,int sum){
        if (tr == null)return 0;
        sum = sum - tr.val;
        int res = sum == 0?1:0;
        return res + build(tr.left, sum) + build(tr.right,sum);
    }
}
