package test;

import java.util.*;

public class MiHoYouTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int notice_num = sc.nextInt();
        int i,j;
        List<int[]> noticetime = new ArrayList();
        for (i=0;i<notice_num;i++){
            int[] time = new int[2];
            time[0] = sc.nextInt();
            time[1] = sc.nextInt();
            noticetime.add(time);
        }
        Map<int[],Integer> map = new HashMap();
        for (i=0;i<noticetime.size();i++){
            for (j=0;j<noticetime.size();j++){
                if (i != j){
                    int[] ints = noticetime.get(i);
                    int[] ints1 = noticetime.get(j);
                    if (ints[1] <= ints1[0] || ints1[1] <= ints[0]){
                        continue;
                    }else {
                        if (map.containsKey(ints)){
                            Integer integer = map.get(ints);
                            map.put(ints,++integer);
                        }else {
                            map.put(ints,2);
                        }
                    }
                }
            }
        }
        int temp = 0;
        for (Map.Entry<int[], Integer> integerEntry : map.entrySet()) {
            temp = Math.max(temp,integerEntry.getValue());
        }
        System.out.println(temp);
    }
}
