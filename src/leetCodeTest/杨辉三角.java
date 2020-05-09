package leetCodeTest;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角 {
    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> generate = generate(numRows);
        System.out.println("generate = " + generate);
    }
    private static List<List<Integer>> res;
    public static List<List<Integer>> generate(int numRows) {
        res = new ArrayList<>();
        int i;
        for (i=1;i<=numRows;i++){
            List<Integer> list = new ArrayList<>();
            generN(0,list,i);
            System.out.println("res = " + res);
        }
        return res;
    }
    public static void generN(int i,List<Integer> list,int len){
        if (i >= len){
            res.add(list);
            return;
        }
        if (i==0 || i == len-1){
            list.add(1);
        }else {
            list.add(res.get(len - 2).get(i) + res.get(len - 2).get(i - 1));
        }
        generN(i + 1,list,len);
    }
}
