package test;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class WangyiMain2 {
    /*
    6
..1.#.
2##3#8
.#.##.
.#6#9.
4###..
..7..5
0 0
     */
    private static int count;
    private static char[][] newmap;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("n = " + n);
        String[] map = new String[n];
        int i,j;
        sc.nextLine();
        for (i=0;i<n;i++){
            map[i] = sc.nextLine();
            System.out.println("map[i] = " + map[i]);
        }
        newmap = new char[n][n];
        for (i=0;i<n;i++){
            newmap[i] = map[i].toCharArray();
        }
        int i1 = sc.nextInt();
        int j2 = sc.nextInt();
        count = 0;
        find(i1,j2);
        System.out.println("count = " + count);

    }
    public static int find(int i,int j){
        if (i < 0||i >= newmap.length || j < 0 || j>=newmap[i].length || newmap[i][j] == '#'){
            return 0;
        }
        if (newmap[i][j] != '.'){
            count += Integer.parseInt(String.valueOf(newmap[i][j]));
            newmap[i][j] = '.';
            System.out.println("count = " + count);
        }
        if (find(i+1,j) == 0){

        }else {
            find(i+1,j);
        }
        return -1;
    }
}
