package MyCollections;

import Interfaces.MyMap;

import java.util.*;

public class MyHashMap<K,V> implements MyMap<K,V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_Factor = 0.75;
    private int size = 0;
    private Object[] array = new Object[INITIAL_CAPACITY];

    private boolean put(K key, V car, Object[] qrt) {
        Entry newElem = new Entry(key, car, null);
        int position = Math.abs(key.hashCode() % qrt.length);
        if (qrt[position] == null) {
            qrt[position] = newElem;
            return true;
        } else {
            Entry oldElem = (Entry) qrt[position];
            while (true) {
                if (newElem.key.equals(oldElem.key)) {
                    oldElem.value = newElem.value;
                    return false;
                } else if (oldElem.next == null) {
                    oldElem.next = newElem;
                    return true;
                } else {
                    oldElem = oldElem.next;
                }
            }
        }
    }

    @Override
    public void put(K key, V car) {
        if (size >= array.length * LOAD_Factor) {
            increaseArray();
        }
        if (put(key, car, array)) {
            size++;
        }

    }

    @Override
    public V get(K key) {
        int position = getPozition(key);
        if (((Entry)array[position]).key.equals(key)) {
            return ((Entry)array[position]).value;
        }
        Entry search = (Entry)array[position];
        while (search.next != null) {
            if (search.next.key.equals(key)) {
                return search.next.value;
            }
            search = search.next;
        }
        return null;
    }

    @Override
    public Set<K> keySet() {
        Set<K> result = new HashSet<>();
        for (Object entry : array) {
            Entry existedElement = (Entry) entry;
            while (existedElement != null) {
                result.add(existedElement.key);
                existedElement = existedElement.next;
            }
        }
        return result;
    }

    @Override
    public List<V> values() {
        List<V> result = new ArrayList<>();
        for (Object entry : array) {
            Entry existedElement = (Entry) entry;
            while (existedElement != null) {
                result.add(existedElement.value);
                existedElement = existedElement.next;
            }
        }
        return result;
    }


    @Override
    public boolean remove(K key) {
        int position = getPozition(key);
        if (array[position] == null) {
            return false;
        }
        if (((Entry)array[position]).key.equals(key)) {
            array[position] = ((Entry)array[position]).next;
            size--;
            return true;
        }
        Entry secondLast = (Entry) array[position];
        Entry last = secondLast.next;
        while (last.next != null) {
            if (last.key.equals(key)) {
                secondLast.next = last.next;
                size--;
                return true;
            }
            last = last.next;
            secondLast = secondLast.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    private int getPozition(K key) {
        return Math.abs(key.hashCode() % array.length);
    }

    private void increaseArray() {
        Object[] newarray = new Object[array.length * 2];

        for (Object elem : array) {
            Entry existedElem = (Entry) elem;
            while (existedElem != null) {
                put(existedElem.key, existedElem.value, newarray);
                existedElem = existedElem.next;
            }
        }
        array = newarray;
    }


    protected class Entry {
        K key;
        V value;
        Entry next;

        public Entry(K key, V value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
