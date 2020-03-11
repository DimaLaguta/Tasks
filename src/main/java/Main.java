import chapter3.ex11.Directories;
import chapter3.ex1ex2.Employee;
import chapter3.ex1ex2.EmployeeService;
import chapter3.ex4ex5.*;
import chapter3.ex9ex10.Greeter;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Exercise 1,2
        Employee[] employees = new Employee[10];

        for(int i=0;i<employees.length;i++){
            employees[i]=new Employee("name");
        }

         EmployeeService.average(employees);


        //Exercise 4,5
        DigitSequence digitSequence = new DigitSequence(12345);
        IntSequence digitSequence1 = IntSequence.of(1,2,3,4,5);

        IntSequence intSequence = IntSequence.constant(1);

        //Exercise 9
        Greeter greeter1 = new Greeter(5, "Max");
        Greeter greeter2 = new Greeter(2,"Ivan");

        Thread threadGreeter1 = new Thread(greeter1);
        Thread threadGreeter2 = new Thread(greeter2);

        threadGreeter1.start();
        threadGreeter2.start();


        //Exercise 11
        List<File> directories = Directories.directories("D://УНИВЕР");
        List<String> files = Directories.filesWithExtension("D://УНИВЕР","pdf");
    }
}
