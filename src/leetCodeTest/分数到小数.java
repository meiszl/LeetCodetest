package leetCodeTest;

import java.util.HashMap;

public class 分数到小数 {
    public static void main(String[] args) {
        int numerator = -1;
        int denominator = -2147483648;
        String s = fractionToDecimal(numerator, denominator);
        System.out.println("s = " + s);
    }

    /**
     * 转成long型防止溢出，分部计算每一位的数字，然后合成串即可。
     * @param numerator
     * @param denominator
     * @return
     */
    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        boolean flag = (numerator < 0 )^(denominator < 0);
        long num = Math.abs(Long.valueOf(numerator));
        long denom = Math.abs(Long.valueOf(denominator));
        StringBuilder stringBuilder = new StringBuilder();
        if (flag)
            stringBuilder.append("-");
        long res = num / denom;
        long dere = num % denom;
        stringBuilder.append(res);
        if (dere == 0)
            return stringBuilder.toString();
        stringBuilder.append(".");
        HashMap<Long,Integer> map = new HashMap<>();
        while (dere != 0){
            if (map.containsKey(dere)){
                stringBuilder.insert(map.get(dere),"(");
                stringBuilder.append(")");
                break;
            }
            map.put(dere,stringBuilder.length());
            dere *= 10;
            stringBuilder.append(dere / denom);
            dere %= denom;
        }
        return stringBuilder.toString();
    }
}
