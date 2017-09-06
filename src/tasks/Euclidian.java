package tasks;

public class Euclidian {
    private Euclidian(){}

    private static int x = 0;
    private static int y = 0;

    public static int modInverse(int a, int mod){
        advancedGCD(a, mod);
        return x;
    }

    private static int advancedGCD(int a, int n) {
        if (a == 0) {
            x = 0;
            y = 1;
            return n;
        }
        int d = advancedGCD(n % a, a);
        int x1 = x;
        int y1 = y;
        x = y1 - (n / a) * x;
        y = x1;
        return d;
    }

    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        int i;
        for (i = 0; ((a | b) & 1) == 0; i++) {
            a >>= 1; // a/2
            b >>= 1;
        }
        while ((a & 1) == 0)
            a >>= 1;

        do {
            while ((b & 1) == 0)
                b >>= 1;
            if (a > b) { //swap
                int temp = b;
                b = a;
                a = temp;
            }
            b = b - a;
        } while (b != 0);
        return a << i;
    }
}
