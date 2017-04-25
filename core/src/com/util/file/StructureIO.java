package com.util.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Jonathan Crockett
 */
public class StructureIO{
    
    public static void saveStructure(FileOutputStream fOut, SaveableCollection<?,?> coll) throws IOException{
        if(coll.ByteChunkBuffer == null){
            throw(new IOException("FileHandling: Cannot acquire temporary chunk"));
        }
        
        for(SaveableElement e: coll){
            fOut.write(e.saveState().getBytes());
        }
    }
    
    public static <T extends SaveableElement<U>, U extends ByteChunk> void loadStructure(FileInputStream fIn, SaveableCollection<T,U> coll, CreateElement<T> func) throws IOException{
        if(coll.ByteChunkBuffer == null){
            throw(new IOException("FileHandling: Cannot acquire temporary chunk"));
        }        
        
        while(fIn.read(coll.ByteChunkBuffer.getBytes()) >= 0){
            T e = func.createElement();
            e.loadState(coll.ByteChunkBuffer);
            coll.add(e);
        }
    }
    
    public static interface CreateElement<T extends SaveableElement>{
        public T createElement();
    }
    
}
