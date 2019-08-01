package com.insis.rongbin.personal.utils;

public class MyQueue<E> {
    private int DEFAULT_SIZE=100;
    private Object[] objectArr=new Object[DEFAULT_SIZE];
    private int start=0;
    private int end=0;
    private int currentSize=0;

    public E poll(){
        if(currentSize == 0){
            return null;
        }else{
            E t = (E)objectArr[start];
            start=start+1;
            if(start>=DEFAULT_SIZE){
                start=0;
            }
            currentSize--;
            return t;
        }
    }

    public boolean add(E e){
        if(currentSize>=DEFAULT_SIZE){
            return false;
        }else{
            objectArr[end]=e;
            currentSize++;
            end++;
            if(end>=DEFAULT_SIZE){
                end=0;
            }
            return true;
        }
    }

    public int getCurrentSize(){
        return currentSize;
    }
}
