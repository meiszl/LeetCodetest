package test;

import java.util.*;

public class zijieMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i,j,k;
        List<int[]> list = new ArrayList();
        for (k=0;k<n;k++){
            int len = sc.nextInt();
            for (i=0;i<n;i++){
                int[] a = new int[len];
                for (j=0;j<len;j++){
                    a[j] = sc.nextInt();
                }
                list.add(a);
            }
        }
        for (i=0;i<list.size();i = i+2){
            int[] arr1 = list.get(i);
            int[] arr2 = list.get(i + 1);
            int[] res = new int[arr1.length];
            for (j=0;j<arr1.length;j++){
                res[j] = arr1[j] - arr2[j];
            }
            int temp = 0;
            boolean flag = true;
            for (j=0;j<res.length;j++){
                if (temp == 0 && res[j] != 0){
                    temp = res[j];
                }
                if (res[j]!= 0 && temp != res[j]){
                    flag = false;
                    break;
                }
            }
            if (flag)
                System.out.println("YES");
            else
                System.out.println("No");
        }
    }
}
