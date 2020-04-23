package leetCodeTest;

import util.TreeNode;

import java.util.*;

public class 二叉树的右视图 {
    public static void main(String[] args) {
            TreeNode node= new TreeNode(1);
            node.left = new TreeNode(2);
            node.right = new TreeNode(3);
            node.left.right = new TreeNode(5);
            node.right.right = new TreeNode(4);
        List<Integer> list = rightSideView(node);
        System.out.println("list = " + list);
    }

    /**
     * 广度优先搜索
     * @param root
     * @return
     */
//    public static List<Integer> rightSideView(TreeNode root) {
//        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
//        int max_depth = -1;
//
//        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
//        Queue<Integer> depthQueue = new LinkedList<Integer>();
//        nodeQueue.add(root);
//        depthQueue.add(0);
//
//        while (!nodeQueue.isEmpty()) {
//            TreeNode node = nodeQueue.remove();
//            int depth = depthQueue.remove();
//
//            if (node != null) {
//                // 维护二叉树的最大深度
//                max_depth = Math.max(max_depth, depth);
//
//                // 由于每一层最后一个访问到的节点才是我们要的答案，因此不断更新对应深度的信息即可
//                rightmostValueAtDepth.put(depth, node.val);
//
//                nodeQueue.add(node.left);
//                nodeQueue.add(node.right);
//                depthQueue.add(depth+1);
//                depthQueue.add(depth+1);
//            }
//        }
//        List<Integer> rightView = new ArrayList<Integer>();
//        for (int depth = 0; depth <= max_depth; depth++) {
//            rightView.add(rightmostValueAtDepth.get(depth));
//        }
//
//        return rightView;
//    }

    /**
     * 深度优先搜索
     * @param root
     * @return
     */
    public static List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        int max_depth = -1;

        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> depthStack = new Stack<Integer>();
        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null) {
                // 维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);

                // 如果不存在对应深度的节点我们才插入
                if (!rightmostValueAtDepth.containsKey(depth)) {
                    rightmostValueAtDepth.put(depth, node.val);
                }

                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth+1);
                depthStack.push(depth+1);
            }
        }

        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }

}
