package leetCodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7};
        reOrderArray(array);
        System.out.println("array = " + Arrays.toString(array));
    }
    public static void reOrderArray(int[] array) {
        List<Integer> a= new ArrayList<>();
        List<Integer> b= new ArrayList<>();
        int temp,tem;
        for(int i=0;i<array.length;i++){
            if (array[i]%2==0){
                a.add(array[i]);
            }else {
                b.add(array[i]);
            }
        }
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        int[] ints = a.stream().mapToInt(Integer::intValue).toArray();
        int[] ints1 = b.stream().mapToInt(Integer::intValue).toArray();
        int[] res = new int[a.size() + b.size()];
        for (int i = 0; i < b.size(); i++) {
            res[i] = b.get(i);
        }
        for (int i = 0; i < a.size(); i++) {
            res[i + b.size()] = a.get(i);
        }
//        System.arraycopy(ints1,0,array,0,ints1.length);
//        System.arraycopy(ints,ints1.length-1,array,array.length-1,ints.length);
    }
}
