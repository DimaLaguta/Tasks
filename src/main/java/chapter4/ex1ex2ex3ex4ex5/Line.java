package chapter4.ex1ex2ex3ex4ex5;

public class Line extends Shape {
    private Point from;
    private Point to;

    public Line(Point from, Point to) {
        this.from = from;
        this.to = to;
    }

    public Point getFrom() {
        return from;
    }

    public void setFrom(Point from) {
        this.from = from;
    }

    public Point getTo() {
        return to;
    }

    public void setTo(Point to) {
        this.to = to;
    }

    @Override
    public Point getCenter() {
        return new Point((from.getX() + to.getX()) * 0.5, (from.getY() + to.getY()) * 0.5);
    }
}
