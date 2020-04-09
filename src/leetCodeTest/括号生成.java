package leetCodeTest;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    public static void main(String[] args) {
        int n=3;
        List<String> list = generateParenthesis(n);
        System.out.println(list);
    }
    /**
     * 递归的暴力解法，每次向char数组中分别添加括号，当字符长度等于2*n的时候，
     * 就对字符串进行校验，如果校验成功的话就将此字符串添加进入list。
     */
//    public static List<String> generateParenthesis(int n) {
//        ArrayList<String> list = new ArrayList();
//        char[] a = new char[2*n];
//        generateAll(a,0,list);
//        return list;
//    }
//    public static void generateAll(char[] a,int nums,List<String> result){
//        if (a.length == nums){
//            if (vaild(a)){
//                result.add(new String(a));
//            }
//        }else {
//            a[nums] = '(';
//            generateAll(a,nums + 1,result);
//            a[nums] = ')';
//            generateAll(a,nums + 1,result);
//        }
//    }
//    public static boolean vaild(char[] str){
//        int balanace = 0;
//        for (char c:str){
//            if (c == '(')
//                balanace++;
//            else
//                balanace--;
//            if (balanace<0)
//                return false;
//        }
//        return balanace==0;
//    }

    /**
     * 回溯法改进暴力法，每次递归判断完后就将字符串当前位置的字符删除然后重新添加另一个括号进行递归判断。
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n){
        List<String> ans = new ArrayList();
        backtrack(ans,new StringBuilder(),0,0,n);
        return ans;
    }
    public static void backtrack(List<String> ans,StringBuilder cur,int open,int close,int max){
        //如果总字符长度等于总长度，则将字符串添加进入结果集中。
        if (cur.length() == max *2){
            ans.add(cur.toString());
            return;
        }
        //左括号个数小于总括号数的一半，添加左括号进行递归
        if (open < max){
            cur.append('(');
            backtrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length()-1);//当前位置为左括号的情况遍历完成之后，将此处的左括号去除进行其他的遍历（回溯到没有添加左括号之前）。
        }
        //此处的操作同上。
        if (close<open){
            cur.append(')');
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
