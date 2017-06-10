package com.util.structures.saveable.util;

/**
 *
 * @author Jonathan Crockett
 */
public interface SaveableData {
    byte[] saveState();
    void loadState(byte[] bytes);
    int byteSize();
}


