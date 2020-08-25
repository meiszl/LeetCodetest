package test;

import java.util.*;


public class qianxintest {

    public static void main(String[] args) {
        int i = CalulateMethodCount(5);
        System.out.println(i);

    }
    /**
     *
     * @param num_money int整型 奖金的总数,单位为元
     * @return int整型
     */
    private static int count;
    private static HashSet<List> hashSet;
    public static int CalulateMethodCount (int num_money) {
        hashSet = new HashSet<>();
        find(num_money,new ArrayList<>());
        return count;
    }
    public static void find(int num_money,List<Integer> list){
        if (num_money == 0){
            if (!hashSet.contains(list))
                count++;
            System.out.println(list);
            hashSet.add(list);
            return;
        }
        int temp = num_money;
        for (int i = 1; i <= num_money; i++) {
            temp = temp - i;
            list.add(i);
            find(temp,new ArrayList<>(list));
            temp = temp + i;
            list.remove(list.size()-1);
        }
    }

}