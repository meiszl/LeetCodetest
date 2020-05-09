package leetCodeTest;

import java.util.HashMap;


public class 直线上最多的点数 {
    public static void main(String[] args) {
        int[][] points = {{4,0},{4,-1},{4,5}};
        int i = maxPoints(points);
        System.out.println("i = " + i);
    }
    public static int maxPoints(int[][] points) {
        int n = points.length;
        if (n==0) return 0;
        if (n==1) return 1;
        int res = 0;
        for (int i = 0; i < n-1; i++) {
            HashMap<String,Integer> hashMap = new HashMap<>();
            int repeat = 0;
            int temp = 0;
            for (int j = i+1; j < n; j++) {
                int dy = points[i][1] - points[j][1];
                int dx = points[i][0] - points[j][0];
                if (dx == 0&&dy == 0){
                    repeat++;
                    continue;
                }
                int g = gcd(dy,dx);
                if (g != 0){
                    dy /= g;
                    dx /= g;
                }
                String tmp = dy + "/" + dx;
                hashMap.put(tmp,hashMap.getOrDefault(tmp,0) + 1);
                temp = Math.max(temp,hashMap.get(tmp));
            }
            res = Math.max(res,repeat + temp + 1);
        }

        return res;
    }
    private static int gcd(int y,int x){
        if (x == 0) return y;
        else return gcd(x,y%x);
    }
}
