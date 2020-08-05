package com.tuanz.array;

/**
 * 普通队列
 */
public class Array {

    public static void main(String[] args) {
        long[] arr;
        int i;
        arr = new long[100];
        int nElems = 0;
        long searchKey;

        //insert 10 items
        arr[0] = 77;
        arr[1] = 99;
        arr[2] = 44;
        arr[3] = 55;
        arr[4] = 22;
        arr[5] = 88;
        arr[6] = 11;
        arr[7] = 12;
        arr[8] = 66;
        arr[9] = 33;
        nElems = 10;

        //打印arr队列数据
        for(i=0; i<nElems; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("");

        //遍历查询
        searchKey = 66;
        for (i=0; i<nElems; i++){
            if(arr[i] == searchKey){
                break;
            }
        }
        if(i == nElems){
            System.out.println("Can't find " + searchKey);
        }else {
            System.out.println("Found "+ searchKey);
        }

        //删除队列中某个值
        searchKey = 55;
        for (i=0; i<nElems; i++){
            if(arr[i] == searchKey){
                break;
            }
        }
        for(int j=i; j<nElems; j++){
            arr[j] = arr[j+1];
        }
        nElems--;

        //重新打印arr队列数据
        for(i=0; i<nElems; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}
