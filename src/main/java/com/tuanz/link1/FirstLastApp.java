package com.tuanz.link1;

public class FirstLastApp {


    public static void main(String[] args) {
        FirstLastList theList = new FirstLastList();
        //头部插入
        theList.insertFirst(22);
        theList.insertFirst(44);
        theList.insertFirst(88);
        //尾部插入
        theList.insertLast(99);
        theList.insertLast(12);
        //此时应该是88 44 22 99 12

        //混合插入
        theList.insertFirst(25);
        theList.insertLast(26);
        //此时应该是25 88 44 22 99 12 26

        theList.displayList();

        theList.deleteFirst();
        theList.deleteFirst();

        theList.displayList();
    }
}
