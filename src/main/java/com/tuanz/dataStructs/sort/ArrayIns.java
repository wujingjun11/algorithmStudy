package com.tuanz.dataStructs.sort;

/**
 * 插入排序法
 */
public class ArrayIns {

    private long[] a;
    private int nElems;

    public ArrayIns(int max){
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

    /**
     * 插入排序
     */
    public void insertionSort(){
        int out, in;

        for (out=1; out<nElems; out++){
            long tmp = a[out];
            in = out;
            while (in>0 && a[in-1]>= tmp){
                a[in] = a[in-1];
                --in;
            }
            a[in] = tmp;
        }
    }

    //位置互换
    private void swap(int one,int two){
        long tmp = a[one];
        a[one] = a[two];
        a[two] = tmp;
    }
}
