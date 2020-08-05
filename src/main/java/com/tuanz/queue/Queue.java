package com.tuanz.queue;

/**
 * 队列，遵循FIFO先进先出的原则
 */
public class Queue {

    private int maxSize;
    private long[] queArray;
    private int front;//队头
    private int rear;//队尾
    private int nItems;

    public Queue(int s){
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    //入队列
    public void insert(long j){
        if(rear == maxSize-1){
            rear = -1;
        }
        queArray[++rear] = j;
        nItems++;
    }

    //出队列
    public long remove(){
        long temp = queArray[front++];
        if(front == maxSize){
            front = 0;
        }
        nItems--;
        return temp;
    }

    //查看
    public long peekFront(){
        return queArray[front];
    }

    //空队列
    public boolean isEmpty(){
        return (nItems==0);
    }

    //满队列
    public boolean isFull(){
        return (nItems==maxSize);
    }

    public int size(){
        return nItems;
    }
}
