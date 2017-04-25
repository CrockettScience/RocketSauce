package com.util.file;

/**
 *
 * @author Jonathan Crockett
 */
public class Chunk16Bit extends ByteChunk{
    
    public Chunk16Bit(byte b0, byte b1){
        b = new byte[2];
        
        b[0] = b0;
        b[1] = b1;
    }
}
