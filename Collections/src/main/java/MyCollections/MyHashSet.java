package MyCollections;

import Interfaces.MySet;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class MyHashSet<T> implements MySet<T> {

    private Map<T, Object> map = new HashMap<>();
    private Object object = new Object();

    @Override
    public boolean add(T elem) {
        if (map.containsKey(elem)) {
            return false;
        }
        map.put(elem, object);
        return true;
    }

    @Override
    public boolean remove(T elem) {
        Object removed = map.remove(elem);
        return removed != null;
    }

    @Override
    public boolean contains(T elem) {
        return map.containsKey(elem);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }
}

