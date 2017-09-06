package tasks.RSA;

import tasks.Euclidian;

import java.util.Random;


public class Alice {
    private int p;
    private int q;
    private int n;
    private int phiN;
    private int e;
    private int d;
    private final int length = 100;
    private Random random;


    public void createKey(){
        random = new Random();
        p = probablePrime(random);
        q = probablePrime(random);
        n = p*q;
        phiN = funcEyler(p, q);
        e = coPrime(phiN);
        d = Euclidian.modInverse(e, phiN);
    }

    public int sendN(){
        return n;
    }

    public int sendE(){
        return e;
    }

    private int funcEyler (int a, int b) {
        int res = (a-1)*(b-1);
        return res;
    }

    private int probablePrime(Random random) {
        int res=0;
        do{
            res = random.nextInt();
        }
        while (!isPrime(res));
        return res;
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }

    private int coPrime (int number){
        int res;
        do {
            res = probablePrime(random);
        }
        while (Euclidian.gcd(res, number)!=1);
        return  res;
    }

    public int decryption(int number) {
        int res = (int)(Math.pow(number, d)%n);
        return res;
    }
}

