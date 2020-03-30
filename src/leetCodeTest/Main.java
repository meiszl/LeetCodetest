package leetCodeTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        String s1 = sc.nextLine();
//        s = s.replace("\"", "");
//        s1 = s1.replace("\"","");
//        int i = Integer.parseInt(s);
//        int i1 = Integer.parseInt(s1);
//        System.out.println("\"" + String.valueOf(i+i1) + "\"");
//
//    }


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        if (s.length() == 0)
//            System.out.println(0);
//        int i,j,count = 0;
//        for (i=0;i<s.length();i++){
//            for (j = i+1;j<s.length()+1;j++){
//                String substring = s.substring(i, j);
//                boolean b = find(substring);
//                if (b)
//                    count++;
//            }
//        }
//        System.out.println(count);
//
//    }
//    public static boolean find(String s){
//        int i;
//        boolean flag = true;
//        for (i=0;i<s.length()/2;i++){
//            if (!(s.charAt(i) == s.charAt(s.length() - i - 1))){
//                flag = false;
//                break;
//            }
//
//        }
//        return flag;
//    }


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] a = new int[n];
//        int i,j;
//        for (i=0;i<n;i++){
//            a[i] = sc.nextInt();
//        }
//        int[] b = a;
//        Arrays.sort(b);
//        List<Integer> list = new ArrayList();
//        for (i=0;i<a.length;i++){
//            list.add(a[i]);
//        }
//        int temp = 0;
//        for (i=0;i<list.size();i++){
//            for (j=0;j<b.length;j++){
//                if (list.get(i) == b[j]){
//                    if (i!=0 && i != list.size()-1){
//                        temp = Math.max(list.get(i-1),list.get(i+1));
//                        if (temp == list.get(i-1))
//                            list.remove(i-1);
//                        if (temp == list.get(i+1))
//                            list.remove(i+1);
//                    }
//                    if (i==0){
//                        temp = list.get(i+1);
//                        list.remove(i+1);
//                    }
//                    if (i==list.size()-1){
//                        temp = list.get(i-1);
//                        list.remove(i-1);
//                    }
//                    temp += list.get(i);
//                    list.remove(i);
//                    list.add(i,temp);
//                }
//            }
//        }
//        System.out.println("list = " + list);
//    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int i,j;
//        String[] strings = new String[n+1];
//        String[] res = new String[n+1];
//        for (i=0;i<=n;i++){
//            strings[i] = sc.nextLine();
//            res[i] = "";
//        }
//        for (i=0;i<strings.length;i++){
//            if (i!=strings.length-1)
//                for (j=0;j<strings.length;j++){
//                    if (i!=j){
//                        String comparestr = comparestr(strings[i], strings[j]);
//                        if (res[i].length() < comparestr.length())
//                            res[i] = comparestr;
//                    }
//                }
//            if (i==strings.length-1)
//                for (j=strings.length-2;j>=0;j--){
//                    String comparestr = comparestr(strings[i], strings[j]);
//                    if (res[i].length() < comparestr.length())
//                        res[i] = comparestr;
//                }
//        }
//        for (i=0;i<strings.length;i++)
//            System.out.println(res[i]);
//    }
//    public static String comparestr(String str1,String str2){
//        int i;
//        StringBuilder stringBuilder = new StringBuilder();
//        for (i=0;i<str1.length();i++){
//            stringBuilder.append(str1.charAt(i));
//            if (i>=str2.length() || !(str1.charAt(i) == str2.charAt(i)))
//                break;
//        }
//        return stringBuilder.toString();
//    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] jinbi = new int[n];
        int[] sum = new int[n];
        for(int i=0;i<n;i++) {
            jinbi[i] = in.nextInt();
            if(i==0)
                sum[i]=jinbi[i];
            else
                sum[i]=sum[i-1]+jinbi[i];
        }
        in.close();
        long temp = 0;
        long min =0;
        long[][] dp = new long[n][n];
        for(int l=1;l<n;l++) {
            for(int i=0;i<n&&i+l<n;i++) {
                min = dp[i][i]+dp[i+1][i+l];
                for(int k=i+1;k<=i+l-1;k++) {
                    temp = dp[i][k] + dp[k+1][i+l];
                    if(temp<min)
                        min = temp;
                }
            if(i>0)
                dp[i][i+l]=min+sum[i+l]-sum[i-1];
            else
                dp[i][i+l]=min+sum[l];
            }
        }
        System.out.println(dp[0][n-1]);
        for(int i =0;i <n;i++){
            for(int j = 0;j<n;j++){
            System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
