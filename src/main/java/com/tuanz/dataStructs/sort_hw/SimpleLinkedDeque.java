package com.tuanz.dataStructs.sort_hw;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedDeque<T> implements SimpleDeque<T> {

    // the head of the linked list
    private Node<T> head;
    // the end of the linked list
    private Node<T> end;
    //the size of linked list,exclude head
    private int size;
    //the maximum capacity of this linked list
    private int capacity = -1;

    /**
     * Constructs a new linked list based deque with unlimited capacity.
     */
    public SimpleLinkedDeque() {
        this.head = new Node<>(end, end);
        this.end = new Node<>(head, head);
        this.size = 0;
    }

    /**
     * Constructs a new linked list based deque with limited capacity.
     *
     * @param capacity the capacity
     * @throws IllegalArgumentException if capacity <= 0
     */
    public SimpleLinkedDeque(int capacity) throws IllegalArgumentException {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.head = new Node<>(end, end);
        this.end = new Node<>(head, head);
        this.size = 0;
        this.capacity = capacity;
    }

    /**
     * Constructs a new linked list based deque with unlimited capacity, and initially 
     * populates the deque with the elements of another SimpleDeque.
     *
     * @param otherDeque the other deque to copy elements from. otherDeque should be left intact.
     * @requires otherDeque != null
     */
    public SimpleLinkedDeque(SimpleDeque<? extends T> otherDeque) {
        this.head = new Node<>(end, end);
        this.end = new Node<>(head, head);
        this.size = 0;

        Iterator<? extends T> iterable = otherDeque.iterator();
        while (iterable.hasNext()) {
            this.pushRight(iterable.next());
        }
    }
    
    /**
     * Constructs a new linked list based deque with limited capacity, and initially 
     * populates the deque with the elements of another SimpleDeque.
     *
     * @param otherDeque the other deque to copy elements from. otherDeque should be left intact.
     * @param capacity the capacity
     * @throws IllegalArgumentException if capacity <= 0 or size of otherDeque is > capacity
     */
    public SimpleLinkedDeque(int capacity, SimpleDeque<? extends T> otherDeque) 
            throws IllegalArgumentException {
        if ((capacity <= 0) || (otherDeque.size() > capacity)) {
            throw new IllegalArgumentException("illegal capacity");
        }

        this.head = new Node<>(end, end);
        this.end = new Node<>(head, head);
        this.size = 0;
        this.capacity = capacity;

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
        if (capacity == -1) {
            return false;
        }
        return size == capacity;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void pushLeft(T e) throws RuntimeException {
        if (isFull()) {
            throw new RuntimeException();
        }
        // Suppose that end.pre is most right element
        // and end.next is most left element
        Node<T> temp = end.next;
        Node<T> newNode = new Node<>(e);
        newNode.pre = end;
        end.next = newNode;
        newNode.next = temp;
        temp.pre = newNode;
        size++;
    }

    @Override
    public void pushRight(T e) throws RuntimeException {
        if (isFull()) {
            throw new RuntimeException();
        }
        // Suppose that end.pre is most right element
        // and end.next is most left element
        Node<T> temp = end.pre;
        Node<T> newNode = new Node<>(e);
        newNode.pre = temp;
        temp.next = newNode;
        newNode.next = end;
        end.pre = newNode;
        size++;
    }

    @Override
    public T peekLeft() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (end.next == head) {
            return end.next.next.value;
        }
        return end.next.value;
    }

    @Override
    public T peekRight() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (end.pre == head) {
            return end.pre.pre.value;
        }
        return end.pre.value;
    }

    @Override
    public T popLeft() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        // Suppose that end.pre is most right element
        // and end.next is most left element
        T value = end.next.value;
        Node<T> temp = end.next;
        end.next = temp.next;
        temp.next.pre = end;
        size--;
        return value;
    }

    @Override
    public T popRight() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        // Suppose that end.pre is most right element
        // and end.next is most left element
        T value = end.pre.value;
        Node<T> temp = end.pre;
        temp.pre.next = end;
        end.pre = temp.pre;
        size--;
        return value;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int queSize = size;
            Node<T> temp = end;

            @Override
            public boolean hasNext() {
                return queSize != 0;
            }

            @Override
            public T next() {
                temp = temp.next;
                if (temp == head) {
                    temp = temp.next;
                }
                queSize--;
                return temp.value;
            }
        };
    }

    @Override
    public Iterator<T> reverseIterator() {
        return new Iterator<T>() {
            int queSize = size;
            Node<T> temp = end;

            @Override
            public boolean hasNext() {
                return queSize != 0;
            }

            @Override
            public T next() {
                temp = temp.pre;
                if (temp == head) {
                    temp = temp.pre;
                }
                queSize--;
                return temp.value;
            }
        };
    }


    private static class Node<T> {
        Node<T> pre;
        Node<T> next;
        T value;

        public Node() {

        }

        public Node(T value) {
            this.value = value;
        }

        public Node(Node<T> pre, Node<T> next) {
            this.pre = pre;
            this.next = next;
        }

        public Node(Node<T> pre, Node<T> next, T value) {
            this.pre = pre;
            this.next = next;
            this.value = value;
        }
    }
}
