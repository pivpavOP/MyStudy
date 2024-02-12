package MyCollections;

import Interfaces.MyList;
import Interfaces.MyQueue;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T>, MyQueue<T> {
    private Node first;
    private Node last;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;

    }

    @Override
    public boolean removeAt(int index) {
        Node node = getNode(index);
        Node nodeNext = node.next;
        Node nodePrevious = node.previous;
        if (nodeNext != null) {
            nodeNext.previous = nodePrevious;
        } else {
            last = nodePrevious;
        }
        if (nodePrevious != null) {
            nodePrevious.next = nodeNext;
        } else {
            first = nodeNext;
        }
        size--;
        return true;
    }

    @Override
    public boolean remove(Object car) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(car)) {
                return removeAt(i);
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public T get(int index) {
        return getNode(index).value;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node node = first;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    @Override
    public boolean contains(T value) {
        Node search = first;
        for (int i = 0; i < size; i++) {
            if (search.value.equals(value)) {
                return true;
            }
            search = search.next;
        }
        return false;
    }

    @Override
    public boolean add(T value, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            return add(value);

        }
        Node nodeNext = getNode(index);
        Node nodePrevios = nodeNext.previous;
        Node newNode = new Node(nodePrevios, value, nodeNext);
        nodeNext.previous = newNode;
        if (nodePrevios != null) {
            nodePrevios.next = newNode;
        } else {
            first = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean add(T value) {
        if (size == 0) {
            first = new Node(null, value, null);
            last = first;
        } else {
            Node secondLast = last;
            last = new Node(secondLast, value, null);
            secondLast.next = last;
        }
        size++;
        return true;
    }

    @Override
    public T poll() {
        T value = (T)get(0);
        removeAt(0);
        return value;
    }

    @Override
    public T peek() {
        return size > 0 ? (T)get(0) : null;//тернарный оператор
    }

    private Node getNode(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private class Node {
        private Node previous;
        private T value;
        private Node next;

        public Node(Node previous, T value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}
