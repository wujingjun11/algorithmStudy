package com.tuanz.sort;

public class InsertionSortApp {

    public static void main(String[] args) {

        int maxSize = 100;
        ArrayIns arr = new ArrayIns(maxSize);

        arr.insert(77);
        arr.insert(34);
        arr.insert(23);
        arr.insert(98);
        arr.insert(70);
        arr.insert(38);
        arr.insert(44);
        arr.insert(55);
        arr.insert(66);
        arr.insert(88);

        arr.display();

        //插入排序
        arr.insertionSort();

        arr.display();
    }
}
