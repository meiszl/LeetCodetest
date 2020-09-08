package test;

import java.util.Scanner;

public class kedaxunfeitest3 {
    static int k = 2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        getNum(n);
    }
    private static void getNum(int n){
        while (k <= n){
            if (k==n){
                System.out.print(n);
                return;
            }else if (n > k&& n%k == 0){
                System.out.print(k + "*");
                n = n/k;
                getNum(n);
                break;
            }else if (n > k && n%k != 0){
                k++;
                getNum(n);
                break;
            }
        }
    }
}
