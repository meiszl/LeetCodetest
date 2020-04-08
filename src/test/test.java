package test;

import java.util.*;

public class test {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap();
        List<String> names1 = new ArrayList<String>();
        names1.add("Google ");
        names1.add("Runoob ");
        names1.add("Taobao ");
        names1.add("Baidu ");
        names1.add("Sina ");
        test tester = new test();
        tester.sortUsingJava7(names1);
        System.out.println(names1);
        System.out.println(5/10);
    }
    private void sortUsingJava7(List<String> names){
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }
}
