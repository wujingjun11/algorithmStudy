package com.tuanz.dataStructs.sort_hw;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 *
 * 双端队列
 */
public class SimpleArrayDeque<T> implements SimpleDeque<T> {

    //record the position of the most right
    private int rightIndex;
    //record the position of the most left
    private int leftIndex;
    //队列长度对大值
    private int capacity;
    //当前队列长度
    private int size;
    //the array T
    private T[] deque;

    /**
     * Constructs a new array based deque with limited capacity.
     * 
     * @param capacity the capacity
     * @throws IllegalArgumentException if capacity <= 0
     */
    public SimpleArrayDeque(int capacity) throws IllegalArgumentException {
        if(capacity <=0){
            throw new IllegalArgumentException("illegal capacity");
        }

        this.deque = (T[])new Object[capacity];
        this.capacity = capacity;
        this.rightIndex = 0;
        this.leftIndex = 0;
        this.size = 0;
    }

    /**
     * Constructs a new array based deque with limited capacity, and initially populates the deque
     * with the elements of another SimpleDeque.
     *
     * @param otherDeque the other deque to copy elements from. otherDeque should be left intact.
     * @param capacity the capacity
     * @throws IllegalArgumentException if capacity <= 0 or size of otherDeque is > capacity
     */
    public SimpleArrayDeque(int capacity, SimpleDeque<? extends T> otherDeque) 
            throws IllegalArgumentException {
        if ((capacity <= 0) || (otherDeque.size() > capacity)) {
            throw new IllegalArgumentException("illegal capacity");
        }

        this.deque = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.rightIndex = 0;
        this.leftIndex = 0;
        size = 0;
        //将数据添加到队列中
        Iterator<? extends T> iterable = otherDeque.iterator();
        while (iterable.hasNext()) {
            this.pushRight(iterable.next());
        }

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public int size() {
        return size;
    }

    //左边数据进入队列
    @Override
    public void pushLeft(T e) throws RuntimeException {
        //判断队列是否已经满
        if(isFull()){
            throw new RuntimeException();
        }
        //判断队列是否为空
        if(isEmpty()){
            deque[leftIndex] = e;
            size++;
        } else {
            // push element and move pointer
            leftIndex--;
            if (leftIndex < 0) {
                leftIndex += capacity;
            }
            deque[leftIndex] = e;
            size++;
        }
    }

    @Override
    public void pushRight(T e) throws RuntimeException {
        if (isFull()) {
            throw new RuntimeException();
        }
        if (isEmpty()) {
            deque[rightIndex] = e;
            size++;
        } else {
            // push element and move pointer
            rightIndex++;
            if (rightIndex == capacity) {
                rightIndex = 0;
            }
            deque[rightIndex] = e;
            size++;
        }
    }

    @Override
    public T peekLeft() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return deque[leftIndex];
    }

    @Override
    public T peekRight() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return deque[rightIndex];
    }

    @Override
    public T popLeft() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T result = deque[leftIndex];
        leftIndex++;
        // move into a new cycle
        if (leftIndex >= capacity) {
            leftIndex = 0;
        }
        size--;
        return result;
    }

    @Override
    public T popRight() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T result = deque[rightIndex];
        rightIndex--;
        // move into a new cycle
        if (rightIndex < 0) {
            rightIndex += capacity;
        }
        size--;
        return result;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            // the position of pointer
            int queSize = size;
            int index = leftIndex;

            @Override
            public boolean hasNext() {
                return queSize != 0;
            }

            @Override
            public T next() {
                T result = deque[index];
                index++;
                if (index >= capacity) {
                    index = 0;
                }
                queSize--;
                return result;
            }
        };
    }

    @Override
    public Iterator<T> reverseIterator() {
        return new Iterator<T>() {
            int index = rightIndex;
            int queSize = size;

            @Override
            public boolean hasNext() {
                return queSize != 0;
            }

            @Override
            public T next() {
                T result = deque[index];
                index--;
                if (index < 0) {
                    index += capacity;
                }
                queSize--;
                return result;
            }
        };
    }
}
