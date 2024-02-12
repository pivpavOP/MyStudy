package Interfaces;

import Interfaces.MyCollection;

public interface MyQueue<T> extends MyCollection<T> {
    boolean add(T car);
    T peek();
    T poll();
}
