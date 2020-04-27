package test;

import java.util.Arrays;
import java.util.Scanner;

public class MiHoYouTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        int i;
        int[] charnums = new int[26];
        char aChar;
        char aChar1;
        for (i=0;i<chars.length;i++){
            if (chars[i] >= 97 && chars[i] <= 123){
                charnums[chars[i] - 97]++;
            }
            if (chars[i] == '-'){
                aChar = chars[i-1];
                charnums[i-1]--;
                charnums[i+1]--;
                aChar1 = chars[i + 1];
                int te = i+2;
                int i2;
                if (aChar1 > aChar)
                    i2 = aChar1 - aChar;
                else{
                    i2 = (aChar1 - 96) + (123 - aChar);
                }
                int num;
                num = aChar - 97;
                System.out.println(num);
                if (chars[te] >= '0' && chars[te] <= '9'){
                    int i1 = chars[te] - '0';
                    int c = 0;;
                    for (int j = 0; j < i2; j++) {
                        if ((num + j) >= 26){
                            charnums[c++] += i1;
                        }else {
                            charnums[num + j] += i1;
                        }
                    }
                }else {
                    int c = 0;;
                    for (int j = 0; j < i2; j++) {
                        if ((num + j) >= 26){
                            charnums[c++]++;
                            continue;
                        }else {
                            charnums[num + j]++;
                        }
                    }
                }
                if ((i+3) < chars.length)
                    i = i+3;
                else
                    break;
            }
            if (chars[i] >= '0' && chars[i] <= '9'){
                charnums[i-1]--;
                charnums[i-1] += chars[i] - '0';
            }
        }
        int temp = 0;
        for (int j = 0; j < charnums.length; j++) {
            temp = Math.max(temp,charnums[j]);
        }
        System.out.println(temp);
    }
}
