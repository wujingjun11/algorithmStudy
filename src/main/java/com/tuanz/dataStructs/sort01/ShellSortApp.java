package com.tuanz.dataStructs.sort01;

/**
 * 希尔排序
 */
public class ShellSortApp {

    public static void main(String[] args) {
        int maxSize = 10;
        ArraySh arr;
        arr = new ArraySh(maxSize);

        for (int j=0; j<maxSize; j++){
            long n = (int)(java.lang.Math.random()*99);
            arr.insert(n);
        }
        arr.display();
        arr.shellSort();
        arr.display();
    }
}
