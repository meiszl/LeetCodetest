package test;

import java.util.*;

public class tengxuntest964 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0){
            System.out.println(0);
            return;
        }
        int[] nums = new int[n+1];
        int[] tem = new int[n+1];
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 1; i < n+1; i++) {
            int nu = sc.nextInt();
            nums[i] = nu;
            tem[i] = nu;
        }
        Arrays.sort(tem);
        for (int i = 1; i < n+1; i++) {
            hashMap.put(tem[i],i-1);
        }
//        System.out.println(Arrays.toString(nums));
        int blo = n/2;
//        System.out.println(hashMap);
//        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();
//        entries.forEach(o -> {
//            if (o.getValue() < blo)
//                System.out.println(nums[blo+1]);
//            else
//                System.out.println(nums[blo]);
//        });
        for (int i = 1; i < n+1; i++) {
            if (hashMap.get(nums[i]) < blo)
                System.out.println(tem[blo+1]);
            else
                System.out.println(tem[blo]);
        }
    }
}
