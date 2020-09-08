package test;

import java.util.*;

public class shunfengtest1 {
    private static int n;
    private static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();
        List<List<Integer>> arr = new ArrayList<>();
        while (sc.hasNextInt()){
            int n = sc.nextInt();
            nums.add(n);
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int nu = sc.nextInt();
                list.add(nu);
            }
            arr.add(list);
        }
        List<List<Integer>> Dlis = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            List<Integer> list = arr.get(i);
            HashSet<Integer> hashSet = new HashSet<>();
            for (int j = 0; j < list.size(); j++) {
                hashSet.add(list.get(j));
            }
            if (hashSet.size() <= 2 && hashSet.contains(-1)){
                int num = 1;
                Iterator<Integer> iterator = hashSet.iterator();
                while (iterator.hasNext()){
                    Integer next = iterator.next();
                    if ( next != -1){
                        num = next;
                    }
                }
                for (int j = 0; j < arr.get(i).size(); j++) {
                    if (arr.get(i).get(j) != num){
                        arr.get(i).set(j,num);
                    }
                }
                continue;
            }
            List<Integer> list1 = new ArrayList<>();
            for (int j = 1; j < list.size(); j++) {
                list1.add(list.get(j) - list.get(j-1));
            }
            Dlis.add(list1);
        }
        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                if (j != arr.get(i).size() - 1)
                    System.out.print(arr.get(i).get(j) + " ");
                else
                    System.out.print(arr.get(i).get(j));
            }
            System.out.println();
        }
    }
    private static void dfs(int dep,int[] A,List<Long> cur){
        if (dep == n){
            if (cur.size() < 3)
                return;
            long diff = cur.get(1) - cur.get(0);
            for (int i = 0; i < cur.size(); i++) {
                if (cur.get(i) - cur.get(i-1) != diff){
                    return;
                }
            }
            ans++;
            return;
        }
        dfs(dep + 1,A,cur);
        cur.add((long)A[dep]);
        dfs(dep + 1,A,cur);
        cur.remove((long)A[dep]);
    }
}
