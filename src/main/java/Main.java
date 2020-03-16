import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import serialization.House;
import serialization.Room;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        //Exercise 1,2
//        Employee[] employees = new Employee[10];
//
//        for (int i = 0; i < employees.length; i++) {
//            employees[i] = new Employee("name");
//        }
//
//        EmployeeService.average(employees);
//
//
//        //Exercise 4,5
//        DigitSequence digitSequence = new DigitSequence(12345);
//        IntSequence digitSequence1 = IntSequence.of(1, 2, 3, 4, 5);
//
//        IntSequence intSequence = IntSequence.constant(1);
//
//        //Exercise 9
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
//        //Exercise 11
//        List<File> directories = Directories.directories("D://УНИВЕР");
//        List<String> files = Directories.filesWithExtension("D://УНИВЕР", "pdf");
//        List<File> files1 = Directories.sortFilesByDirAndPath("D://r");
//
//
//        //Exercise 14
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


        //Serialization
        House house = new House();

        house.setAddress("Lenin street");
        house.setGarage(true);
        house.setGarden(false);

        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room("room1", 34));
        rooms.add(new Room("room2", 67));
        rooms.add(new Room("room3", 303));

        house.setRooms(rooms);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        try {
            mapper.writeValue(new FileOutputStream("JSONhouse.json"), house);
            //System.out.println(mapper.writeValueAsString(house));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Deserialization
        House house1;
        try {
            house1 = (House) mapper.readValue(new FileInputStream("JSONhouse.json"), House.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(SerializationFeature.INDENT_OUTPUT,true);
        try {
            xmlMapper.writeValue(new FileOutputStream("XMLhouse.xml"),house);
        } catch (IOException e) {
            e.printStackTrace();
        }

        House house2;
        try {
            house2 = (House) xmlMapper.readValue(new FileInputStream("XMLhouse.xml"), House.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    public static void kek(List<String> g) {
//        //do something
//    }
}
