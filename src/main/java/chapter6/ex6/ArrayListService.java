package chapter6.ex6;

import java.util.ArrayList;

public class ArrayListService {
    public ArrayList<? super B2> joinArraysSuper (ArrayList<? super B2> array1, ArrayList<B2> array2){
        for (int i=0;i<array2.size();i++){
            array1.add(array2.get(i));
        }
        return array1;
    }


    public ArrayList<? extends B2> joinArraysExtend (ArrayList<B2> array1, ArrayList<? extends B2> array2){
        for (int i=0;i<array2.size();i++){
            array1.add(array2.get(i));
        }
        return array1;
    }
}
