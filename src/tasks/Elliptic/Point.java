package tasks.Elliptic;

import java.math.BigInteger;

public class Point {
    public int x;
    public int y;
    Point(){

    }
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object point) {
        return this.x == ((Point)point).x && this.y == ((Point)point).y;
    }
}