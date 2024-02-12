package Interfaces;

public interface MyList<T> extends MyCollection<T> {
    T get(int index);
    boolean add(T value);
    boolean add(T value,int index);
    boolean remove(T value);
    boolean removeAt(int index);
    int size();
    void clear();
    boolean contains(T value);
}
