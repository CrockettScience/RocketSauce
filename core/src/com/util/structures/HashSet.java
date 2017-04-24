package com.util.structures;

/**
 *
 * @author Jonathan Crockett
 */
public class HashSet<T>{
    private static final int DEFAULT_TABLE_SIZE = 101;
    private int currentSize = 0;
    private T[] elements;
    
    public T get(T data) {
        int pos = findPos(data);
        return elements[pos];
    }
    
    public void add(T data) {        
        int currentPos = findPos(data);
        
        if(elements[currentPos] != null)
            return;//no dupes, don't add
        
        elements[currentPos] = data;
        currentSize++;
        
        if(currentSize > elements.length / 2)        
            rehash( );                
    }
    
    public T remove(T data) {
        int pos = findPos(data);
        T element = elements[pos];
        elements[pos] = null;
        return element;
    }
    
    private int findPos(T data){
        int offset = 1;
        int pos = Math.abs(data.hashCode() % elements.length);

        while(elements[pos] != null){
            if(data.equals(elements[pos]))   
                break;
            
            pos += offset;
            offset += 2;
            
            if(pos >= elements.length)
                pos -= elements.length;
        }
        return pos;
    }
    
    private void rehash(){
        T[] oldArray = elements;
        
        allocateArray(nextPrime(4 * currentSize));
        currentSize = 0;
        
        for (T e : oldArray) {
            if (e != null) {
                add(e);
            }
        }
    }
    
    private static int nextPrime(int n){
        if(n % 2 == 0)
            n++;

        for( ;!isPrime(n) ;)
            n += 2;

        return n;
    }
    
    private static boolean isPrime(int n){
        if(n == 2 || n == 3)
            return true;

        if(n == 1 || n % 2 == 0)
            return false;

        for(int i = 3; i * i <= n; i += 2)
            if(n % i == 0)
                return false;

        return true;
    }
    
    private void allocateArray(int arraySize){
        elements =(T[]) new Object[nextPrime(arraySize)];
    }
}
