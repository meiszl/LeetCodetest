package leetCodeTest;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class 树的子结构 {

    List<Integer> lista;
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null&&B != null)&&(recur(A, B)||isSubStructure(A.left,B)||isSubStructure(A.right,B));
    }
    public boolean recur(TreeNode tra,TreeNode trb){
        if (trb == null) return true;
        if (tra == null || tra.val != trb.val) return false;
        return recur(tra.left, trb.left) && recur(tra.right, trb.right);
    }
}
