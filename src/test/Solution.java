package test;

import util.TreeNode;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        String serialize = solution.serialize(treeNode);
        System.out.println("serialize = " + serialize);
    }
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }
    private int index = -1;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index++;
        int len = data.length();
        String[] strr = data.split(",");
        if (index >= len)
            return null;
        TreeNode tr = null;
        if (!strr[index].equals("#")){
            tr = new TreeNode(Integer.valueOf(strr[index]));
            tr.left = deserialize(data);
            tr.right = deserialize(data);
        }
        return tr;
    }
}
