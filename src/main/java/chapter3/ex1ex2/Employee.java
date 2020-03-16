package chapter3.ex1ex2;

public class Employee implements Measurable {

    String name;
    int Salary;

    public Employee(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getMeasure() {
        return random(10, 20);
    }

    private double random(int min, int max) {
        max -= min;
        return (double) (Math.random() * ++max) + min;
    }

    
}
