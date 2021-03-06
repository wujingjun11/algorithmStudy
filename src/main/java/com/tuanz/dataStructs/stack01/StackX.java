package com.tuanz.dataStructs.stack01;

public class StackX {

    private int maxSize;
    private char[] stackArray;
    private int top;

    //栈的构造方法
    public StackX(int s){
        maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
    }

    //入栈
    public void push(char j){
        stackArray[++top] = j;
    }

    //出栈
    public char pop(){
        return stackArray[top--];
    }

    //相同点：大家都返回栈顶的值
    //不同点：peek 不改变栈的值(不删除栈顶的值)，pop会把栈顶的值删除。
    public char peek(){
        return stackArray[top];
    }

    //栈为空
    public boolean isEmpty(){
        return (top == -1);
    }

    //栈满了
    public boolean isFull(){
        return (top == maxSize-1);
    }

    public int size(){
        return top+1;
    }

    public char peekN(int n){
        return stackArray[n];
    }

    public void displayStack(String s){
        System.out.print(s);
        System.out.print("Stack (bottom-->top): ");
        for (int j=0; j<size(); j++){
            System.out.print(peekN(j)+" ");
        }
        System.out.println("");
    }
}

