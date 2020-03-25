package chapter6.ex1ex2;

public class StackArrayObjects<E> {
    private Object[] array = new Object[1];

    public void push(E element) {
        changeSizeOfArray(array.length + 1);
        array[array.length - 1] = element;
    }

    public E pop() {
        E result = (E) array[array.length - 1];
        changeSizeOfArray(array.length - 1);
        return result;
    }

    public boolean isEmpty() {
        return array.length == 0;
    }

    private void changeSizeOfArray(int newLength) {
        Object[] bufArray = new Object[newLength];
        System.arraycopy(array, 0, bufArray, 0, Math.min(newLength, array.length));
        array = bufArray;
    }
}
