package com.util.structures.saveable.wrappers;

import com.util.structures.saveable.util.SaveableData;
import java.util.Arrays;

/**
 *
 * @author Jonathan Crockett
 */
public class SaveableString implements SaveableData {
    
    public static int TOTAL_BYTES = 8;
    private String string;

    public SaveableString(String str) {
        string = str;
    }
    
    public byte[] saveState() {
        return Arrays.copyOf(string.getBytes(), TOTAL_BYTES);
    }

    public void loadState(byte[] bytes) {
        bytes = Arrays.copyOf(bytes, TOTAL_BYTES);
        string = new String(bytes);
    }

    public int byteSize() {
        return TOTAL_BYTES;
    }

    public String getString() {
        return string;
    }

    public void setString(String str) {
        string = str;
    }
    
    public String toString() {
        return string;
    }
    
}