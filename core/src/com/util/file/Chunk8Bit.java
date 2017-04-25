package com.util.file;

/**
 *
 * @author Jonathan Crockett
 */
public class Chunk8Bit extends ByteChunk{
    
    public Chunk8Bit(byte b0){
        b = new byte[1];
        
        b[0] = b0;
    }
    
}
