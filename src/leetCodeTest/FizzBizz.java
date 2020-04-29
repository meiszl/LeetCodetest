package leetCodeTest;

import java.util.ArrayList;
import java.util.List;

public class FizzBizz {
    public static void main(String[] args) {
        int n = 1;
        List<String> list = fizzBuzz(n);
        System.out.println("list = " + list);
    }

    /**
     * 传统的判断方法
     * @param n
     * @return
     */
//    public static List<String> fizzBuzz(int n) {
//        List<String> list = new ArrayList<>();
//        String str = new String();
//        if (n > 0){
//            for (int i = 1; i <= n; i++) {
//                if (i % 3 == 0)
//                    str = "Fizz";
//                if (i%5 == 0)
//                    str = "Buzz";
//                if ((i%3 == 0) && (i%5 == 0))
//                    str = "FizzBuzz";
//                if ((i%3 != 0) && (i%5 != 0))
//                    str = String.valueOf(i);
//                list.add(str);
//            }
//        }else {
//            for (int i = 1; i >= n; i--) {
//                if (i % 3 == 0)
//                    str = "Fizz";
//                if (i%5 == 0)
//                    str = "Buzz";
//                if ((i%3 == 0) && (i%5 == 0))
//                    str = "FizzBuzz";
//                if ((i%3 != 0) && (i%5 != 0))
//                    str = String.valueOf(i);
//                list.add(str);
//            }
//        }
//        return list;
//    }

    /**
     * 可以兼顾多种情况的判断方法
     * @param n
     * @return
     */
    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        String str = new String();
        boolean flag1;
        boolean flag2;
        for (int i = 1; i <= n; i++) {
            flag1 = (i%3==0);
            flag2 = (i%5==0);

            str = "";
            if (flag1){
                str += "Fizz";
            }
            if (flag2){
                str += "Buzz";
            }
            if (str.equals("")){
                str += String.valueOf(i);
            }
            list.add(str);
        }
        return list;
    }
}
