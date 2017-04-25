package com.util.file;

/**
 *
 * @author Jonathan Crockett
 */
public class Chunk64Bit extends ByteChunk{
    
    public Chunk64Bit(byte b0, byte b1, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7){
        b = new byte[8];
        
        b[0] = b0;
        b[1] = b1;
        b[2] = b2;
        b[3] = b3;
        b[4] = b4;
        b[5] = b5;
        b[6] = b6;
        b[7] = b7;
    }
    
}
