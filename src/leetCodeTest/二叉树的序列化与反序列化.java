package leetCodeTest;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 二叉树的序列化与反序列化 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        Codec codec = new Codec();
        String serialize = codec.serialize(treeNode);
        TreeNode deserialize = codec.deserialize(serialize);
        deserialize.printTree(deserialize);
    }

}
class Codec {
    // Encodes a tree to a single string.
    public String rese(TreeNode treeNode,String str){
        if (treeNode == null){
            str +="null,";
        }else {
            str += treeNode.val + ",";
           str = rese(treeNode.left, str);
           str = rese(treeNode.right, str);
        }
        return str;
    }
    public String serialize(TreeNode root) {
        return rese(root,"");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] datasp = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(datasp));
        return build(list);
    }
    public TreeNode build(List<String> list){
        if (list.get(0).equals("null")){
            list.remove(0);
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        treeNode.left = build(list);
        treeNode.right = build(list);
        return treeNode;
    }
}