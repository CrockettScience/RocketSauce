package com.assets.components.general;
import com.badlogic.ashley.core.Component;

public class ComChunk implements Component{

    /**
     * @return the chunkX
     */
    public int getChunkX() {
        return chunkX;
    }

    /**
     * @return the chunkY
     */
    public int getChunkY() {
        return chunkY;
    }

    /**
     * @param chunkX the chunkX to set
     */
    public void setChunkX(int chunkX) {
        this.chunkX = chunkX;
    }

    /**
     * @param chunkY the chunkY to set
     */
    public void setChunkY(int chunkY) {
        this.chunkY = chunkY;
    }
    
    private int chunkX = 0;
    private int chunkY = 0;
}
