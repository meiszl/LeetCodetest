package leetCodeTest;

import util.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class 二叉树的直径 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left =new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        int result = diameterOfBinaryTree(root);
        System.out.println("result = " + result);
    }
    static int res = 0;

    /**
     * 任意两个节点之间的边数都可能是最大直径
     *
     * 最大的直径不一定包括根节点
     *
     * 这道题很容易有的误区就是：从根节点出发，找到左边数的最大深度 leftDepth，再找到右边树的最大深度 rigthDepth
     *
     * 然后 return leftDepth+rigthDepth + 1（如果二叉树的根节点深度为0的话）
     *
     *
     *
     * 从上面的图可以看出，情况并不是这样，因为最大值不一定要包含根节点。
     *
     * 解题思路
     * 从上面的分析可知，最大值不一定包含根节点，但是一定是：经过一个节点，
     * 该节点左右子树的最大深度之和 +1（二叉树的根节点深度为 0）
     * 于是，可以使用 DFS，找出所有节点的最大直径，在取出最大值 res;
     *
     * 定义一个全局变量 res，用来记录最大直径
     * 使用 dfs(root) 遍历所有的节点，dfs(root) 的作用是：找出以 root 为根节点的二叉树的最大深度
     *
     * 将根节点的深度定义为 1（和上面分析的深度定义不一样）
     * root 为跟节点的最大深度为 Math.max(leftDepth,rigthDepth) + 1
     * res 取值为以经过 root，左右子树的最大深度之和 leftDepth + rigthDepth（不用加 1，是因为根节点的深度是 1）
     * 通过递归，找到 res 的最大值
     *
     * 作者：sugar-31
     * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree/solution/java-shen-du-you-xian-bian-li-dfs-by-sugar-31/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param root
     * @return
     */
    public static int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    // 函数dfs的作用是：找到以root为根节点的二叉树的最大深度
    public static int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = dfs(root.left);
        int rigthDepth = dfs(root.right);
        res = Math.max(res,leftDepth + rigthDepth);
        return Math.max(leftDepth,rigthDepth) + 1;
    }
}
