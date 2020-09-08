package test;

import java.util.*;

public class xiechengtest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mingan = sc.nextLine();
        String line = sc.nextLine();
        String mubiao = sc.nextLine();
        if (mingan.equals("")){
            System.out.println(line);
            return;
        }
        StringBuilder sb = new StringBuilder();
        String[] arr = line.split(" |,");
        List<Integer> linarr = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ','){
                linarr.add(count);
                count++;
            }else if (line.charAt(i) == ' '){
                count++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() == mingan.length()){
                boolean flag = true;
                for (int j = 0; j < mingan.length(); j++) {
                    String s = String.valueOf(mingan.charAt(j));
                    if (!arr[i].contains(s)){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    arr[i] = mubiao;
//                    sb.append(mubiao + " ");
                }else {
//                    sb.append(arr[i] + " ");
                }
            }else {
//                sb.append(arr[i] + " ");
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (linarr.contains(i)){
                sb.append(arr[i] + ",");
            }else {
                sb.append(arr[i] + " ");
            }
        }
//        if (line.contains(",")){
//            for (int i = 0; i < linarr.size(); i++) {
//                int value = linarr.get(i).intValue();
//                sb.insert(value + mubiao.length() - mingan.length(), ',');
//            }
//        }
        String res = sb.toString();
        char[] chars = res.toCharArray();
        System.out.println(String.valueOf(chars).substring(0,res.length() - 1));
    }
}
