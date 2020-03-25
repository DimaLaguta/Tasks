package chapter6.ex6;

public class A1 extends B2 {
    int a;

    public A1(int c, int b, int a) {
        super(c, b);
        this.a = a;
    }

    @Override
    public String toString() {
        return "A1{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
