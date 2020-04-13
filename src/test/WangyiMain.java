package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class WangyiMain {
    /*
    3
1 2 3 1
2 1 3 2
3 1 2 3
1 1 2 3
2 1 2 3
3 1 2 3
     */
    static int[][] res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i,j;
        int[][] newuser = new int[n][4];
        int[][] olduser = new int[n][4];
        for (i=0;i<n;i++){
            for (j=0;j<newuser[i].length;j++){
                newuser[i][j] = sc.nextInt();
            }
        }
        for (i=0;i<n;i++){
            for (j=0;j<olduser[i].length;j++){
                olduser[i][j] = sc.nextInt();
            }
        }
        res = new int[n][2];
        HashSet<Integer> set = new HashSet();
        for (i=0;i<newuser.length;i++){
            res[i][0] = newuser[i][0];
        }
        res[0][0] = newuser[0][0];
        res[0][1] = newuser[0][1];
        set.add(newuser[0][1]);
        for (i=0;i<newuser.length;i++){
            int[] ints = newuser[i];
            for (j=1;j<ints.length;j++){
                if (set.contains(ints[j])){
                    continue;
                }else {
                    res[i][1] = ints[j];
                }
            }
        }
        for (i=0;i<res.length;i++){
            System.out.println(Arrays.toString(res[i]));
        }
    }
//    public static void find(int[][] newuser,int[][] olduser,int i,int j){
//        if (res != null)
//        for (int[] a: res){
//
//        }
//    }
}
