package leetCodeTest;

import java.util.Arrays;
import java.util.Stack;

public class 有效括号的嵌套深度 {
    public static void main(String[] args) {
        String seq =  "((()))";
        int[] ints = maxDepthAfterSplit(seq);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    /**
     * 计数法：
     * 使用count计数得到每组括号的分层，然后根据分层信息划分，
     * 分层数是奇数的为一组括号，分层数是偶数的为一组括号（因为划分时要考虑
     * 将括号字符串划分为有效地最短括号字符串所以采用奇偶划分可以得到最佳的分组）
     * @param seq
     * @return
     */
//    public static int[] maxDepthAfterSplit(String seq) {
//        if (seq == null || seq.equals(""))return new int[0];
//        int i,counta = 0;
//        int[] a = new int[seq.length()];
//        for (i=0;i<seq.length();i++){
//            if (seq.charAt(i) == '('){
//                a[i] = counta;
//                counta++;
//            }
//            if (seq.charAt(i) == ')'){
//                counta--;
//                a[i] = counta;
//            }
//        }
//        for (i=0;i<a.length;i++){
//            if (a[i]%2 == 0 ){
//                a[i]=1;
//            }else {
//                a[i]=0;
//            }
//        }
//        return a;
//    }
    /**
     * 栈方法：
     * 使用栈记录括号的层数，当遇到‘（’时就入栈，遇到‘）’就出栈，
     * 最后栈的size就是所得到的括号层数，然后利用size去切分原字符串即可。
     */
    public static int[] maxDepthAfterSplit(String seq) {
        if (seq == null || seq.equals("")) return new int[0];
        Stack<Character> stack = new Stack<>();
        int[] res = new int[seq.length()];
        //遍历
        for (int i = 0; i < seq.length(); i++) {
            char c = seq.charAt(i);
            if (c == '(') {//入栈,记录括号对所在深度,奇数用0标记，偶数用1标记。
                res[i] = stack.size() % 2;
                stack.push(c);
            } else {//出栈,记录括号对所在深度,奇数用0标记，偶数用1标记。
                stack.pop();
                res[i] = stack.size() % 2;
            }
        }
        return res;
    }

}
