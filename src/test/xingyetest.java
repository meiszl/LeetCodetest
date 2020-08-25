package test;

import java.util.*;

public class xingyetest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(",");
        int[] ints = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int anInt : ints) {
            hashMap.put(anInt,hashMap.getOrDefault(anInt,0) + 1);
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            if (next.getValue() == 2){
                System.out.print(next.getKey() + " ");
            }
        }
    }
}
