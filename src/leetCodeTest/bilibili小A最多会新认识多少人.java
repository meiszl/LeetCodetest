package leetCodeTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bilibili小A最多会新认识多少人 {
    public static void main(String[] args) throws IOException{
        BufferedReader buffR = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffR.readLine());
        int ai = Integer.parseInt(buffR.readLine());
        int m = Integer.parseInt(buffR.readLine());
        HashMap<Integer, HashSet> map = new HashMap<>();
        for(int i = 0; i < m; i++){
            String[] s = buffR.readLine().split(",");
            int node1 = Integer.parseInt(s[0]), node2 = Integer.parseInt(s[1]);
            if(!map.containsKey(node1)){
                map.put(node1, new HashSet());
            }
            if(!map.containsKey(node2)){
                map.put(node2, new HashSet());
            }
            map.get(node1).add(node2);
            map.get(node2).add(node1);
        }
        HashSet<Integer> set = new HashSet<>();
        set.add(ai);
        HashSet<Integer> arrive = map.get(ai);
        int size1 = arrive.size();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(ai);
        while (!queue.isEmpty()) {
            HashSet<Integer> temp = map.get(queue.poll());
            for(Integer t : temp){
                if(!set.contains(t)){
                    set.add(t);
                    queue.offer(t);
                }
            }
        }
        System.out.println(set.size() - size1 - 1);
    }
}