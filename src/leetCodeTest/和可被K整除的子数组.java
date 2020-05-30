package leetCodeTest;

import java.util.*;

public class 和可被K整除的子数组 {
    public static void main(String[] args) {
        int[] A = new int[]{4,5,0,-2,-3,1};
        int K = 5;
        int i = subarraysDivByK(A, K);
        System.out.println("i = " + i);
    }
    public static int subarraysDivByK(int[] A, int K) {
        if (A == null||A.length == 0||K == 0) return 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(0,1);
        int res = 0,tem = 0;
        for (int i : A) {
            tem += i;
            int module = (tem % K + K)%K;
            int orDefault = hashMap.getOrDefault(module, 0);
            res += orDefault;
            hashMap.put(module,orDefault+1);
        }
        return res;
    }
}
