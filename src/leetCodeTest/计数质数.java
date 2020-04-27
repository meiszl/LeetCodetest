package leetCodeTest;

public class 计数质数 {
    public static void main(String[] args) {
        int n = 10;
        int i = countPrimes(10);
        System.out.println("i = " + i);
    }
    public static int countPrimes(int n) {
        if (n < 2) return 0;
        boolean[] isPrime = new boolean[n];

        for (int i = 2; i < n; i++) {
            if (!isPrime[i])
                //i*2,i*3,i*4...均不为质数
                for (int j = 2*i; j < n; j+=i) {
                    isPrime[j] = true;
                }
        }
        int count = 0;
        for (int i = 0; i < isPrime.length; i++) {
            if (!isPrime[i]) count++;
        }
        return count - 2;
    }
}
