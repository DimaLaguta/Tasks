package chapter4.ex1ex2ex3ex4ex5;

public abstract class Shape {
    private Point point;

    public Shape() { }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public void moveBy(double dx, double dy){
        point.setX(point.getX() + dx);
        point.setY(point.getY() + dy);
    }

    public abstract Point getCenter();


}
