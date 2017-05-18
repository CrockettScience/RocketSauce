package com.util.structures;

import java.io.File;

/**
 *
 * @author Jonathan Crockett
 */
public interface SaveableStructure<T extends SaveableData>{
    
    boolean save(File file);
    
    boolean load(File file, CreateData<T> func);
}
