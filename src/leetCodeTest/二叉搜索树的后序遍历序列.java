package leetCodeTest;

public class 二叉搜索树的后序遍历序列 {
    public static void main(String[] args) {
        int[] postorder = new int[]{1,6,3,2,5};
        boolean b = verifyPostorder(postorder);
        System.out.println("b = " + b);
    }
    public static boolean verifyPostorder(int[] postorder) {
        return findAll(postorder,0,postorder.length-1);
    }
    public static boolean findAll(int[] postorder,int i,int j){
        if (i>=j) return true;
        int p = i;
        while (postorder[p] <postorder[j])p++;
        int m = p;
        while (postorder[p] > postorder[j]) p++;
        return p == j&&findAll(postorder,i,m-1)&&findAll(postorder,m,j-1);
    }

}
