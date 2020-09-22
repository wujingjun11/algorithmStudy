package com.tuanz.dataStructs.sort_hw;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 可逆转的队列
 */
public class ReversibleDeque<T> implements SimpleDeque<T> {

    SimpleDeque<T> data;

    /**
     * Constructs a new reversible deque, using the given data deque to store
     * elements.
     * The data deque must not be used externally once this ReversibleDeque
     * is created.
     * @param data a deque to store elements in.
     */
    public ReversibleDeque(SimpleDeque<T> data) {
        this.data = data;
    }

    public void reverse() {
        T[] arr = (T[]) new Object[data.size()];
        int index = 0;

        Iterator<? extends T> iterable = data.iterator();
        //get the data and put it in a array
        while (iterable.hasNext()) {
            arr[index] = iterable.next();
            data.popLeft();
            index++;
        }
        //push the data into deque
        for (T element : arr) {
            data.pushLeft(element);
        }
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return data.isFull();
    }

    @Override
    public void pushLeft(T e) throws RuntimeException {
        data.pushLeft(e);
    }

    @Override
    public void pushRight(T e) throws RuntimeException {
        data.pushRight(e);
    }

    @Override
    public T peekLeft() throws NoSuchElementException {
        return data.peekLeft();
    }

    @Override
    public T peekRight() throws NoSuchElementException {
        return data.peekRight();
    }

    @Override
    public T popLeft() throws NoSuchElementException {
        return data.popLeft();
    }

    @Override
    public T popRight() throws NoSuchElementException {
        return data.popRight();
    }

    @Override
    public Iterator<T> iterator() {
        return data.iterator();
    }

    @Override
    public Iterator<T> reverseIterator() {
        return data.reverseIterator();
    }
}
