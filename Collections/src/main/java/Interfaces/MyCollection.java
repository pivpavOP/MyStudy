package Interfaces;

public interface MyCollection<T> extends Iterable<T>{
    boolean add(T car);
    boolean remove(T car);
    void clear();
    int size();
    boolean contains(T car);
}
