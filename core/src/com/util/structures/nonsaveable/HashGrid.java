package com.util.structures.nonsaveable;

/**
 *
 * @author Jonathan Crockett
 */
public class HashGrid<T> {
    protected Map<Coordinates, T> gridMap;
    
    public HashGrid() {
        clear();
    }
    
    public void set(int x, int y, T data) {
        if(x < 0 || y < 0)
            throw new ArrayIndexOutOfBoundsException();
        
        Coordinates point = new Coordinates(x,y);
        gridMap.put(point, data);        
    }
    
    public T get(int x, int y) {
        if(x < 0 || y < 0)
            throw new ArrayIndexOutOfBoundsException();
        
        return gridMap.get(new Coordinates(x,y));
    }
    
    public int size() {
        return gridMap.size();
    }
    
    public void clear() {
        gridMap = new Map<Coordinates, T>();
    }
            
    protected static class Coordinates {
        protected Integer x;
        protected Integer y;
        
        Coordinates(int xx, int yy) {
            x = xx;
            y = yy;
        }

        @Override
        public int hashCode() {
            return x.hashCode() ^ y.hashCode();
        }

        @Override
        public boolean equals(Object obj){
            if(!(obj instanceof Coordinates)){
                return false;
            }
            Coordinates other = (Coordinates) obj;
            return(other.x.equals(x) && other.y.equals(y));
        }
    }
}
