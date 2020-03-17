package chapter4.ex9ex11;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Ref {
    public static String ToString(Object object) throws IllegalAccessException {
        String result = "";

        Class classObject = object.getClass();
        Field[] publicFields = classObject.getDeclaredFields();

        for (Field i : publicFields) {
            //Class c = Class.forName(i.getName());
            i.setAccessible(true);
            result += i.getName().toString() + " : " + i.get(object).toString() + "\n";
        }
        return result;
    }

    public static void helloWorld(String input) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {

        //не работает

        String system = "java.lang.System";

        Class c = Class.forName(system);
        Field[] fields = c.getFields();
        for (Field i : fields) {
            if (i.getName().equals("out")) {
                Class c2 = Class.forName(i.getType().getName());
                Method[] methods = c2.getMethods();
                for (Method j : methods) {
                    if (j.getName().equals("println") && j.getParameterTypes()[0].toString().equals(input.getClass().toString())) {

                        j.invoke(c2);
                    }
                }
            }
        }
    }
}
