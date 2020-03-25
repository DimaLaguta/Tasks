package chapter6.ex6;

public class B2 extends C3 {


    int b;

    public B2(int c, int b) {
        super(c);
        this.b = b;
    }

    @Override
    public String toString() {
        return "B2{" +
                "b=" + b +
                ", c=" + c +
                '}';
    }
}
