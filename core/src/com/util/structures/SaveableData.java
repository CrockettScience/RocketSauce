package com.util.structures;

/**
 *
 * @author Jonathan Crockett
 */
public interface SaveableData {
    byte[] saveState();
    void loadState(byte[] bytes);
    int byteSize();
}


