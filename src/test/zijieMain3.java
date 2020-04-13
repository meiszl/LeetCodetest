package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class zijieMain3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<int[]> list = new ArrayList();
        int i,j,k;
        for (i=0;i<t;i++){
            int len = sc.nextInt();
            int[] a = new int[len];
            for (j=0;j<len;j++){
                a[j] = sc.nextInt();
            }
            list.add(a);
        }
        for (i=0;i<list.size();i++){
            int[] hig = list.get(i);
            int[] res = new int[hig.length];
            for (j=0;j<hig.length;j++){
                int temp = 0;
                int fir = j-1;
                int sec = j+1;
                for (k=j+1;k<hig.length;k++){
                    if (hig[k] > hig[j])
                        break;
                    temp++;
                }
                for (k = j-1;k>=0;k--){
                    if (hig[k]>hig[j])
                        break;
                    temp++;
                }
                res[j] = temp;
            }
            for (j=0;j<res.length;j++){
                if (j != res.length-1)
                    System.out.print(res[j] + " ");
                else
                    System.out.print(res[j]);
            }
            System.out.println();
        }
    }
}
