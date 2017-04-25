package com.util.file;

/**
 *
 * @author Jonathan Crockett
 */
public interface SaveableElement<T extends ByteChunk> {
    T saveState();
    void loadState(T bytes);
}


