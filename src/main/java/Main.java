import chapter4.ex9ex11.Example;
import chapter4.ex9ex11.Ref;
import chapter6.ex1ex2.StackArray;
import chapter6.ex1ex2.StackArrayObjects;
import chapter6.ex3ex4.Table;
import chapter6.ex6.A1;
import chapter6.ex6.ArrayListService;
import chapter6.ex6.B2;
import chapter6.ex6.C3;
import chapter6.ex7ex8ex9ex10ex11ex12.Pair;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//        //Exercise14 1,2
//        Employee[] employees = new Employee[10];
//
//        for (int i = 0; i < employees.length; i++) {
//            employees[i] = new Employee("name");
//        }
//
//        EmployeeService.average(employees);
//
//
//        //Exercise14 4,5
//        DigitSequence digitSequence = new DigitSequence(12345);
//        IntSequence digitSequence1 = IntSequence.of(1, 2, 3, 4, 5);
//
//        IntSequence intSequence = IntSequence.constant(1);
//
//        //Exercise14 9
//        Greeter greeter1 = new Greeter(5, "Max");
//        Greeter greeter2 = new Greeter(2, "Ivan");
//
//        Thread threadGreeter1 = new Thread(greeter1);
//        Thread threadGreeter2 = new Thread(greeter2);
//
//        threadGreeter1.start();
//        threadGreeter2.start();
//
//
//        //Exercise14 11
//        List<File> directories = Directories.directories("D://УНИВЕР");
//        List<String> files = Directories.filesWithExtension("D://УНИВЕР", "pdf");
//        List<File> files1 = Directories.sortFilesByDirAndPath("D://r");
//
//
//        //Exercise14 14
//        chapter3.ex15.Employee[] employees1 = new chapter3.ex15.Employee[3];
//
//
//        employees1[0] = new chapter3.ex15.Employee("Andrey", 700);
//        employees1[1] = new chapter3.ex15.Employee("Ivan", 900);
//        employees1[2] = new chapter3.ex15.Employee("Alex", 600);
//
//        employees1 = chapter3.ex15.EmployeeService.sortBySalaryAndName(employees1);
//
//        ArrayList<String> names = new ArrayList<String>(100) {
//            public void add(int index, String element) {
//                super.add(index, element);
//                System.out.println("ce");
//            }
//        };
//
//
//        names.add(0, "yu");
//
//        kek(new ArrayList<String>() {{
//            add("ewcecw");
//            add("ercer");
//        }});


//        //Serialization
//        House house = new House();
//
//        house.setAddress("Lenin street");
//        house.setGarage(true);
//        house.setGarden(false);
//
//        List<Room> rooms = new ArrayList<>();
//        rooms.add(new Room("room1", 34));
//        rooms.add(new Room("room2", 67));
//        rooms.add(new Room("room3", 303));
//
//        house.setRooms(rooms);
//
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
//        try {
//            mapper.writeValue(new FileOutputStream("JSONhouse.json"), house);
//            //System.out.println(mapper.writeValueAsString(house));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //Deserialization
//        House house1;
//        try {
//            house1 = (House) mapper.readValue(new FileInputStream("JSONhouse.json"), House.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        XmlMapper xmlMapper = new XmlMapper();
//        xmlMapper.configure(SerializationFeature.INDENT_OUTPUT,true);
//        try {
//            xmlMapper.writeValue(new FileOutputStream("XMLhouse.xml"),house);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        House house2;
//        try {
//            house2 = (House) xmlMapper.readValue(new FileInputStream("XMLhouse.xml"), House.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        Example example = new Example(123, "rfv", "qwer");

        try {
            System.out.println(Ref.ToString(example));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


//        try {
//            Ref.helloWorld("Hello World!");
//        } catch (ClassNotFoundException | InvocationTargetException | IllegalAccessException e) {
//            e.printStackTrace();
//        }

     /*   Exercises ex = new Exercises();
        double sumOfArray;
        try {
            sumOfArray = ex.sumOfValues("Double.txt");
            System.out.println("Сумма элементов массива " + sumOfArray);
        } catch (IOException e) {
            System.out.println("Файл не найден");
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат числа");
        }

        RateService rateService = new RateService();
        List<Rate> rates = rateService.getRates(145, 292, 298);
        for (Rate i : rates) {
            System.out.println(i.toString());
        }*/

        //ex 1 2
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());

        StackArrayObjects<Integer> stackArray = new StackArrayObjects<>();
        stackArray.push(1);
        stackArray.push(2);
        stackArray.push(3);
        System.out.println(stackArray.pop());


        StackArray<Integer> integerStackArray = new StackArray<>(Integer.class);
        integerStackArray.push(1);
        integerStackArray.push(2);
        integerStackArray.push(3);
        System.out.println(integerStackArray.pop());

        //ex 3 4
        Table<String, Integer> table = new Table<>();
        table.setValueByKey("qqq", 123);
        table.setValueByKey("ddd", 367);
        table.setValueByKey("vvv", 456);
        System.out.println(table.getValueByKey("ddd"));

        //ex6
        ArrayList<A1> list1 = new ArrayList<A1>();
        list1.add(new A1(1, 2, 3));
        ArrayList<B2> list2 = new ArrayList<B2>();
        list2.add(new B2(4, 5));
        ArrayList<C3> list3 = new ArrayList<C3>();
        list3.add(new C3(6));

//        ArrayList<? extends B2> list4 = new ArrayList<A1>();
//        ArrayList<? super B2> list5 = new ArrayList<C3>();
//        list5.add(new B2(00,23));

        ArrayListService d = new ArrayListService();

//        ArrayList<C3> resultSuper = (ArrayList<C3>) d.joinArraysSuper(list3,list2);
//        resultSuper.forEach(x-> System.out.println(x+" "));

//        ArrayList<B2> resultExtend = (ArrayList<B2>) d.joinArraysExtend(list2,list1);
//        resultExtend.forEach(x-> System.out.println(x+" "));

        //ex7
//        Pair<Integer> pair1 = new Pair<>(1,2);
//        System.out.println(pair1.max());
//        System.out.println(pair1.min());


        //ex9
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(8);
        arrayList.add(4);
        Pair pair2 = Pair.firstLast(arrayList);
        System.out.println(pair2);

        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(2);
        arrayList1.add(20);
        arrayList1.add(243);
        arrayList1.add(4);

        Integer result = Pair.maxInArray(arrayList1);
        System.out.println(result);

    }
}
