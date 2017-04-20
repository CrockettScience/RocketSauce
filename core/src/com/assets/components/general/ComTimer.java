package com.assets.components.general;
import com.badlogic.ashley.core.Component;

public class ComTimer implements Component{

    /**
     * @return the time
     */
    public double getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(double time) {
        this.time = time;
    }
    
    private double time = 0;
}
