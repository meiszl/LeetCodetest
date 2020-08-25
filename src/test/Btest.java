package test;

import java.util.ArrayList;
import java.util.List;

public class Btest {
    public static void main(String[] args) {
        int[] te = new int[]{7,2,1,10};
        boolean b = Game24Points(te);
        System.out.println(b);
    }
    public static boolean Game24Points(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            list.remove(i);
            if (getResult(list, temp)){
                return true;
            }
            list.add(i, temp);
        }
        return false;
    }

    private static boolean getResult(List<Integer> list, int temp) {
        if (list.size() > 0){
            for (int i = 0; i < list.size(); i++) {
                int n = list.get(i);
                list.remove(i);
                if (getResult(list,temp * n)|| getResult(list, temp + n)|| getResult(list, temp - n)){
                    return true;
                }else if (temp % n == 0){
                    if (getResult(list, temp/n)){
                        return true;
                    }
                }
                list.add(i,n);
            }
            return false;
        }else {
            if (temp == 24){
                return true;
            }else {
                return false;
            }
        }
    }
}
