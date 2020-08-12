package com.tuanz.dataStructs.sort;

/**
 * 冒泡排序法
 */
public class ArrayBub {

    private long[] a;
    private int nElems;

    public ArrayBub(int max){
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value){
        a[nElems] = value;
        nElems++;
    }

    public void display(){
        for(int i=0; i<nElems; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    //冒泡排序
    public void bubbleSort(){
        int out, in;
        for(out=nElems-1; out>1; out--){
            for (in=0; in<out; in++){
                if(a[in] > a[in+1]){
                    swap(in, in+1);
                }
            }
        }
    }

    //位置互换
    private void swap(int one,int two){
        long tmp = a[one];
        a[one] = a[two];
        a[two] = tmp;
    }
}
