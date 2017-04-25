package com.util.file;

/**
 *
 * @author Jonathan Crockett
 */
public class Chunk32Bit extends ByteChunk{
    
    public Chunk32Bit(byte b0, byte b1, byte b2, byte b3){
        b = new byte[4];
        
        b[0] = b0;
        b[1] = b1;
        b[2] = b2;
        b[3] = b3;
    }
    
}
