package chapter6.ex1ex2;

import java.lang.reflect.Array;

public class StackArray<E> {
    private E[] array;
    private Class<E> eClass;

    public StackArray(Class<E> cl) {
        eClass = cl;
        array = (E[]) Array.newInstance(cl, 1);
    }

    public void push(E element) {
        changeSizeOfArray(array.length + 1);
        array[array.length - 1] = element;
    }

    public E pop() {
        E result =  array[array.length - 1];
        changeSizeOfArray(array.length-1);
        return result;
    }

    public boolean isEmpty(){
        return array.length==0;
    }
    private void changeSizeOfArray(int newLength) {
        E[] bufArray = (E[]) Array.newInstance(eClass, newLength);
        System.arraycopy(array, 0, bufArray, 0, Math.min(newLength, array.length));
        array = bufArray;
    }
}
