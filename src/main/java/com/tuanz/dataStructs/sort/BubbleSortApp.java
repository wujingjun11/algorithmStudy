package com.tuanz.dataStructs.sort;

public class BubbleSortApp {

    public static void main(String[] args) {

        int maxSize = 100;
        ArrayBub arr = new ArrayBub(maxSize);

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

        //冒泡排序
        arr.bubbleSort();

        arr.display();
    }


}
