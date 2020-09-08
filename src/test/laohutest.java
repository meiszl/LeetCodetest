package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class laohutest {
    public static void main(String[] args) {
        String s = "1-1-3+4-3";
        int maxResult = getMaxResult(s);
        System.out.println(maxResult);
    }
    public static int getMaxResult (String expression) {
        List<Integer> maxResult = getMaxResult1(expression);
        System.out.println(maxResult);
        Collections.sort(maxResult);
        return maxResult.get(maxResult.size()-2);
    }
    public static List<Integer> getMaxResult1(String expression) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+'||c == '-'){
                String leftStr = expression.substring(0, i);
                String rightStr = expression.substring(i + 1);
                List<Integer> maxResult = getMaxResult1(leftStr);
                List<Integer> maxResult1 = getMaxResult1(rightStr);
                for (Integer l : maxResult) {
                    for (Integer r : maxResult1) {
                        if (c == '+'){
                            list.add(l + r);
                        }else if (c == '-'){
                            list.add(l - r);
                        }
                    }
                }
            }
        }
        if (list.size() == 0){
            list.add(Integer.valueOf(expression));
        }
        return list;
    }
}
