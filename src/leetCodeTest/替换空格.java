package leetCodeTest;

public class 替换空格 {
    public static void main(String[] args) {
        String s = "We are happy.";
        String s1 = replaceSpace(s);
        System.out.println("s1 = " + s1);
    }
    public static String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        char[] chars = new char[]{'%','2','0'};
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == ' '){
                stringBuilder.deleteCharAt(i);
                stringBuilder.insert(i,chars);
            }
        }
        return stringBuilder.toString();
    }
}
