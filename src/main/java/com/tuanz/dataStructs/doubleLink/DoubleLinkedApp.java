package com.tuanz.dataStructs.doubleLink;

/**
 * 双向链表 简单实例
 */
public class DoubleLinkedApp {

    public static void main(String[] args) {
        DoubleLinkedList theList = new DoubleLinkedList();

        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(66);

        theList.insertLast(11);
        theList.insertLast(33);
        theList.insertLast(55);

        theList.displayForward();//正向
        theList.displayBackward();//反向

        theList.deleteFirst();
        theList.deleteLast();
        theList.deleteKey(11);

        theList.displayForward();

        theList.insertAfter(22,77);
        theList.insertAfter(33,88);

        theList.displayForward();
    }
}
