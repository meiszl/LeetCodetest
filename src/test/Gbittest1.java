package test;

import java.util.Scanner;

public class Gbittest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        int n = sc.nextInt();

        int xa = sc.nextInt();
        int ya = sc.nextInt();
        int xb = sc.nextInt();
        int yb = sc.nextInt();
        int xc = sc.nextInt();
        int yc = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int temp_x = x;
            int temp_y = y;
            int temp_z = z;
            x += (temp_y*xb+temp_z*xc)%1000000007;
            y += (temp_x*xa+temp_z*yc)%1000000007;
            z += (temp_x*ya + temp_y*yb)%1000000007;
            System.out.println(x + " " + y + " " + z);
        }
    }
}
