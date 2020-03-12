package chapter3.ex15;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class EmployeeService {
    public static Employee[] sortBySalaryAndName(Employee[] employees){
        Arrays.sort(employees, Comparator.comparing(Employee::getSalary,Comparator.reverseOrder()).thenComparing(Employee::getName,Comparator.reverseOrder()));
        return employees;
    }
}
