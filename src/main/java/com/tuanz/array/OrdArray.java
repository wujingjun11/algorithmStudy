package com.tuanz.array;

/**
 * 对普通队列 增删改方法封装 结构化
 */
public class OrdArray {

    private long[] a;
    private int nElems;

    //构造方法
    public OrdArray(int max){
        a = new long[max];
        nElems = 0;
    }

    public static void main(String[] args) {
        int maxSize = 100;
        OrdArray arr = new OrdArray(maxSize);
        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(10);
        arr.insert(66);
        arr.insert(33);

        int searchKey = 55;
        if(arr.find(searchKey) != arr.size()){
            System.out.println("Found "+searchKey);
        }else {
            System.out.println("Can't find "+ searchKey);
        }

        arr.desplay();

        //delete
        arr.delete(10);
        arr.delete(55);
        arr.delete(99);

        //desplay
        arr.desplay();
    }


    public int size(){
        return nElems;
    }

    //查询方法
    public int find(long searchKey){
        int lowerBound = 0;
        int upperBound = nElems-1;
        int curIn;

        while (true){
            curIn = (lowerBound + upperBound);
            if(a[curIn] == searchKey){
                return curIn;
            }else if(lowerBound > upperBound){
                return nElems;
            }else {
                if(a[curIn] < searchKey){
                    lowerBound = curIn +1;
                }else {
                    upperBound = curIn -1;
                }
            }
        }
    }

    //添加数据方法
    public void insert(long value){
        int j;
        for (j=0; j<nElems; j++){
            if(a[j]> value){
                break;
            }
        }

        for (int k=nElems; k>j; k--){
            a[k] = a[k-1];
        }
        a[j] = value;
        nElems++;
    }

    //删除数据方法
    public boolean delete(long value){
        int j = find(value);
        if(j == nElems){
            return false;
        }else {
            for (int k=j; k<nElems; k++){
                a[k] = a[k+1];
            }
            nElems--;
            return true;
        }
    }

    //队列打印输出方法
    public void desplay(){
        for (int i=0; i<nElems; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }
}
