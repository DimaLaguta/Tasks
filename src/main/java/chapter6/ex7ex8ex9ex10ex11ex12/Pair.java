package chapter6.ex7ex8ex9ex10ex11ex12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pair<E extends Comparable> {
    private E firstElement;
    private E secondElement;

    public Pair(E firstElement, E secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    public E getFirstElement() {
        return firstElement;
    }

    public E getSecondElement() {
        return secondElement;
    }

    public E max() {
        return firstElement.compareTo(secondElement) >= 0 ? firstElement : secondElement;
    }

    public E min() {
        return firstElement.compareTo(secondElement) <= 0 ? firstElement : secondElement;
    }

    public static <E extends Comparable> Pair<E> firstLast(ArrayList<E> a) {
        return new Pair(a.get(0), a.get(a.size() - 1));
    }

    public static <E extends Comparable<? super E>> E minInArray(List<E> elements) {
        E min = elements.get(0);
        for(E element : elements){
            if(element.compareTo(min) < 0){
                min = element;
            }
        }
        return min;
    }
    public static <E extends Comparable<? super E>> E maxInArray(List<E> elements) {
        E max = elements.get(0);
        for(E element : elements){
            if(element.compareTo(max) > 0){
                max = element;
            }
        }
        return max;
    }

    public static <T> void minmax(List<T> elements, Comparator<? super T> comp, List<? super T> result){
     T max = elements.get(0);
     T min = elements.get(0);

     for(T element : elements){
         if(comp.compare(element,min)<0){
             min = element;
         }
         if(comp.compare(element,max)>0){
             max = element;
         }
     }
     result.add(min);
     result.add(max);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "firstElement=" + firstElement +
                ", secondElement=" + secondElement +
                '}';
    }
}
