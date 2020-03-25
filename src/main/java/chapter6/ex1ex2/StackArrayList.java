package chapter6.ex1ex2;

import java.util.ArrayList;

public class StackArrayList<E> {
    private ArrayList<E> arrayList = new ArrayList<E>();

    public void push(E element) {
        arrayList.add(element);
    }

    public E pop() {
        return arrayList.get(arrayList.size() - 1);
    }

    public boolean isEmpty() {
        return arrayList.size() == 0 ;
    }


}
