package tasks.Elliptic;

import tasks.Euclidian;

/**
 * Created by Анна on 21.12.2016.
 */
public class EllipticCurve {
    Curve f;
    int mod;

    public EllipticCurve(int a, int b, int mod){
        f = new Curve(a, b, mod);
    }

    public Point add(Point p1, Point p2){
        int m=0;
        if(p1.equals(p2))
            m = mEquals(p1);
        Point p3 = new Point();
        p3.x = m*m-p1.x-p2.x;
        p3.y = m*(p1.x - p3.x) - p1.y;
        p3.x %= mod;
        p3.y %= mod;
        return p3;
    }

    private int mEquals (Point p){
        int m = (3*p.x*p.x + f.a)* Euclidian.modInverse(2 * p.y, mod);
        m %= mod;
        return m;
    }

    private int mDiff(Point p1, Point p2){
        int m = (p2.y - p1.y)*Euclidian.modInverse(p2.x-p1.x, mod);
        m %= mod;
        return m;
    }


}


