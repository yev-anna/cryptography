package tasks.Elliptic;

import java.math.BigInteger;
import java.util.function.Function;

public class Curve implements Function<Integer, Integer> {
    int a;
    int b;
    int mod;

    public Curve(int a, int b, int mod){
        this.a = a;
        this.b = b;
        this.mod = mod;
    }

    @Override
    public Integer apply(Integer x) {
        int y2 = x*x*x + a*x + b;
        //x*x*x + a*x + b (mod m)
        return y2%mod;
    }

    public boolean belong(Point point){
        int y2 = (point.y*point.y)%mod;
        return y2 == apply(point.x);
    }
}