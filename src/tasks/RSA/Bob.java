package tasks.RSA;


public class Bob {
    private int n;
    private int e;
    public void setKey(int n, int e){
        this.n = n;
        this.e = e;
    }

    public int encryption(int number) {
        int res = (int)(Math.pow(number, e)%n);
        return res;
    }
}
