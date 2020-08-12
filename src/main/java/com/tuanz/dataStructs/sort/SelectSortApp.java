package com.tuanz.dataStructs.sort;

public class SelectSortApp {

    public static void main(String[] args) {

        int maxSize = 100;
        ArraySel arr = new ArraySel(maxSize);

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

        //选择排序
        arr.selectionSort();

        arr.display();
    }
}
