package chapter6.ex15;

import java.util.ArrayList;
import java.util.function.Function;

public class Exercise15 {
    public static <T,R> ArrayList<R> map(ArrayList<T> input, Function<T,R> func){
        ArrayList<R> result = new ArrayList<>();
        for(T elem : input){
            result.add(func.apply(elem));
        }
        return result;
    }

}
