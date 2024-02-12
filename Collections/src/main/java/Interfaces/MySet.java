package Interfaces;

import Interfaces.MyCollection;

public interface MySet<T> extends MyCollection<T> {
    boolean add(T car);
    boolean remove(T car);
    int size();
    void clear();
    boolean contains(T car);
}
