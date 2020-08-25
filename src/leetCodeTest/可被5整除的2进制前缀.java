package leetCodeTest;

import java.util.ArrayList;
import java.util.List;

public class 可被5整除的2进制前缀 {
    public static void main(String[] args) {
        int[] a = new int[]{0,1,1,1,1,1};
        List<Boolean> booleans = prefixesDivBy5(a);
        System.out.println(booleans);
    }
    public static List<Boolean> prefixesDivBy5(int[] A) {
        int num=0;
        List<Boolean> ans=new ArrayList<>();
        for(int index=0;index<A.length;index++){
            num=(num*2+A[index])%5;
            if(num==0)ans.add(true);
            else ans.add(false);
        }
        return ans;
    }
}
