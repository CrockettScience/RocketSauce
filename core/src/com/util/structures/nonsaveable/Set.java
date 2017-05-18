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

    public boolean contains(Object e) {
        
        T element;
        try{
            element = (T) e;
        }
        catch(ClassCastException ex){
            return false;
        }
        
        int currentPos = findPos(element);
        
        if(mapTable[currentPos] != null){
            SetEntry i = mapTable[currentPos];
            
            while(i.next != null){
                if(i.element.equals(element) && i.isActive)
                    return true;
            
                i = i.next;
            }
        }
        
        return false;
    }

    public boolean add(T e) {
        return add(constructSetEntry(e));
    }
    
    public Set<T> union(Set<? extends T> otherSet){
        Set<T> union = new Set<T>();
        
        for(SetEntry<T> entry : mapTable){
            union.add(entry.element);
        }
        
        for(int i = 0; i < otherSet.mapTable.length; i++){
            union.add(otherSet.mapTable[i].element);
        }
        
        return union;
    }
    
    public Set<T> intersection(Set<? extends T> otherSet){
        Set<T> intersection = new Set<T>();
        
        for(SetEntry<T> entry: mapTable){
            if(otherSet.contains(entry.element)){
                intersection.add(entry.element);
            }
        }
        
        return intersection;
    }
    
    public Set<T> not(Set<? extends T> otherSet){
        Set<T> not = new Set<T>();
        
        for(SetEntry<T> entry : mapTable){
            if(!otherSet.contains(entry.element)){
                not.add(entry.element);
            }
        }
        
        return not;
    }
    
    public Set<T> xor(Set<? extends T> otherSet){
        Set<T> xor = new Set<T>();
        
        for(SetEntry<T> entry : mapTable){
            if(!otherSet.contains(entry.element)){
                xor.add(entry.element);
            }
        }
        
        for(int i = 0; i < otherSet.mapTable.length; i++){
            if(!this.contains(otherSet.mapTable[i].element)){
                xor.add(otherSet.mapTable[i].element);
            }
        }
        
        return xor;
    }
    
    protected boolean add(SetEntry<T> entry) {
        int currentPos = findPos(entry.element);
        
        if(mapTable[currentPos] != null){
            SetEntry i = mapTable[currentPos];
            
            while(i.next != null && !i.element.equals(entry.element))
                i = i.next;
            
            if(i.element.equals(entry.element)){
                if(i.isActive)
                    return false;
                else{
                    i.element = entry.element;
                    currentSize++;
                    return true;
                }
            }
            else
                occupied++;
            
            i.next = entry;
            currentSize++;
        }
        
        else{
            occupied++;
            mapTable[currentPos] = entry;
            currentSize++;
        }
        
        if(occupied > mapTable.length)        
            rehash();
        
        return true;
    }

    public boolean remove(T e) {
        int currentPos = findPos(e);
        
        if(mapTable[currentPos] != null){
            SetEntry i = mapTable[currentPos];
            
            while(i.next != null){
                if(i.element.equals(e) && i.isActive){
                    i.isActive = false;
                    currentSize--;
                    return true;
                }
            
                i = i.next;
            }
        }
        
        return false;
    }

    public void clear() {
        allocateArray(DEFAULT_TABLE_SIZE);
        currentSize = 0;
        occupied = 0;
    }
    
    private int findPos(T e){
        return Math.abs(e.hashCode() % mapTable.length);
    }
    
    private void rehash(){
        SetEntry[] oldArray = mapTable;
        
        allocateArray(nextPrime(2 * currentSize));
        currentSize = 0;
        
        for (SetEntry entry : oldArray) {
            SetEntry i = entry;
            while(i != null){
                add(i);
                i = i.next;
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
        private boolean isActive;
        protected SetEntry next = null;
        
        protected SetEntry(T e) {
            element = e;
            isActive = true;
        }
    }
}
