package com.util.structures.nonsaveable;

/**
 *
 * @author Jonathan Crockett
 */
public class Set<T> {
    private static final int DEFAULT_TABLE_SIZE = 101;
    
    protected SetEntry<T>[] mapTable;
    private int occupied;
    private int currentSize;

    public Set(){
        clear();
    }
    
    public int size() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean contains(T e) {
        int currentPos = findPos(e);
        T other = mapTable[currentPos] == null ? null : mapTable[currentPos].element;
        
        return e.equals(other);
    }

    public boolean add(T e) {
        return add(constructSetEntry(e));
    }
    
    protected boolean add(SetEntry<T> entry) {        
        int currentPos = findPos(entry.element);
        
        if(mapTable[currentPos] != null){
            if(mapTable[currentPos].isActive)
                return false;
        }
        else
            occupied++;
        
        mapTable[currentPos] = entry;
        currentSize++;
        
        if(occupied > mapTable.length / 2)        
            rehash();
        
        return true;
    }

    public boolean remove(T e) {
        int currentPos = findPos(e);
        
        if(mapTable[currentPos] == null || !mapTable[currentPos].isActive)
            return false;
        
        mapTable[currentPos] = null;
        currentSize--;
        
        return true;
    }

    public void clear() {
        allocateArray(DEFAULT_TABLE_SIZE);
        currentSize = 0;
        occupied = 0;
    }
    
    private int findPos(T e){
        int offset = 1;
        int currentPos = Math.abs(e.hashCode() % mapTable.length);

        while(mapTable[currentPos] != null){
            if(e.equals(mapTable[currentPos].element))   
                break;
            
            currentPos += offset;
            offset += 2;
            
            if(currentPos >= mapTable.length)
                currentPos -= mapTable.length;
        }
        return currentPos;
    }
    
    private void rehash(){
        SetEntry[] oldArray = mapTable;
        
        allocateArray(nextPrime(4 * currentSize));
        currentSize = 0;
        
        for (SetEntry entry : oldArray) {
            if (entry != null) {
                add(entry);
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
        mapTable = new SetEntry[nextPrime(arraySize)];
    }
    
    protected SetEntry<T> constructSetEntry(T e){
        return new SetEntry(e);
    }
    
    protected class SetEntry<T> {
        protected T element;
        boolean isActive;
        
        protected SetEntry(T e) {
            element = e;
            isActive = true;
        }
    }
}
