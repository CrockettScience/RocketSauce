package com.util.file;

/**
 *
 * @author Jonathan Crockett
 */
public abstract class SaveableCollection<T extends SaveableElement<U>, U extends ByteChunk> implements Iterable<T>{
    protected U ByteChunkBuffer;
    
    public abstract void add(T e);
}
