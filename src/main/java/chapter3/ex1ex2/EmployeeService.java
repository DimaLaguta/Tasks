package chapter3.ex1ex2;


public class EmployeeService {
    public static double average(Measurable[] objects) {
        double sum = 0;
        for (Measurable i : objects) {
            sum += i.getMeasure();
        }
        return objects.length > 0 ? sum / objects.length : 0;
    }

    public static Measurable largest(Measurable[] objects) {
        if (objects.length == 0) {
            return null;
        }
        Measurable maxMeasurable = objects[0];
        for (int i = 1; i < objects.length; i++) {
            if (objects[i].getMeasure() > maxMeasurable.getMeasure()) {
                maxMeasurable = objects[i];
            }
        }
        return maxMeasurable;
    }
}
