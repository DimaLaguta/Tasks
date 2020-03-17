package chapter4.ex1ex2ex3ex4ex5;

public class Circle extends Shape {
    private Point center;
    private double radius;

    public Circle(Point center,double radius){
        super();
        this.center = center;
        this.radius = radius;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public Point getCenter() {
        return center;
    }
}
