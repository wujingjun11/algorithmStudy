package com.tuanz.dataStructs.sort;

/**
 * 比较各种排序的时间复杂度
 */
public class Test {

    public static void main(String[] args) {
        int maxSize = 100000;
        ArrayBub arrayBub = new ArrayBub(maxSize);//冒泡排序数组
        ArrayIns arrayIns = new ArrayIns(maxSize);//插入排序数组
        ArraySel arraySel = new ArraySel(maxSize);//选择排序数组

        for (int j=0;j<maxSize; j++){
            long n = (long)(java.lang.Math.random()*maxSize-1) ;
            arrayBub.insert(n);
            arrayIns.insert(n);
            arraySel.insert(n);
        }

        //冒泡排序用时
        long arrayBubBeginTime = System.currentTimeMillis();
        arrayBub.bubbleSort();
        long arrayBubEndTime = System.currentTimeMillis();
        System.out.println("bubbleSort finish in "+ (arrayBubEndTime-arrayBubBeginTime)+" ms");

        //冒泡排序用时
        long arrayInsBeginTime = System.currentTimeMillis();
        arrayIns.insertionSort();
        long arrayInsEndTime = System.currentTimeMillis();
        System.out.println("insertionSort finish in "+ (arrayInsEndTime-arrayInsBeginTime)+" ms");

        //冒泡排序用时
        long arraySelBeginTime = System.currentTimeMillis();
        arraySel.selectionSort();
        long arraySelEndTime = System.currentTimeMillis();
        System.out.println("selectionSort finish in "+ (arraySelEndTime-arraySelBeginTime)+" ms");


    }
}
