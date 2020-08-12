package com.tuanz.dataStructs.sort;

/**
 * 选择排序法
 */
public class ArraySel {

    private long[] a;
    private int nElems;

    public ArraySel(int max){
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
     * 选择排序
     * 在每一个in的新位置,数据项a[in]和a[min]进行比较，如果a[in]更小，则min被赋值为in的值。
     * 在内层循环的最后，min指向最小的数据项，然后交换out和min指向的数组数据项。
     */
    public void selectionSort(){
        int out, in, min;

        for (out=0; out<nElems-1; out++){
            min = out;
            for (in=out+1; in<nElems; in++){
                if(a[in] < a[min]){
                    min = in;//得到最小
                }
            }
            swap(out,min);
        }
    }

    //位置互换
    private void swap(int one,int two){
        long tmp = a[one];
        a[one] = a[two];
        a[two] = tmp;
    }
}
